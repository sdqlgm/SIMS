'use strict';
/** 
  * A set of directives for left and right sidebar.
*/
app.directive('sidebar', ['$document', '$rootScope',
function ($document, $rootScope) {
    return {
        replace: false,
        restrict: "C",
        link: function (scope, elem, attrs) {
            var shouldCloseOnOuterClicks = true;

            if (attrs.closeOnOuterClicks == 'false' || attrs.closeOnOuterClicks == '0') {
                shouldCloseOnOuterClicks = false;
            }

            var isAncestorOrSelf = function (element, target) {
                var parent = element;

                while (parent.length > 0) {
                    if (parent[0] === target[0]) {
                        parent = null;
                        return true;
                    }
                    parent = parent.parent();
                }

                parent = null;
                return false;
            };

            var closeOnOuterClicks = function (e) {

                if (!isAncestorOrSelf(angular.element(e.target), elem)) {
                    $rootScope.toggle(attrs.id, 'off');
                    e.preventDefault();
                    return false;
                }
            };

            var clearCb1 = angular.noop();

            if (shouldCloseOnOuterClicks) {
                clearCb1 = $rootScope.$on('clip-two.toggled', function (e, id, active) {

                    if (id == attrs.id) {

                        if (active) {
                            setTimeout(function () {
                                $document.on('click tap', closeOnOuterClicks);
                            }, 300);
                        } else {
                            $document.off('click tap', closeOnOuterClicks);
                        }
                    }
                });
            }

            scope.$on('$destroy', function () {
                clearCb1();
                $document.off('click tap', closeOnOuterClicks);
            });

        }
    };
}]).directive('searchForm', function () {
    return {
        restrict: 'AC',
        link: function (scope, elem, attrs) {
            var wrap = $('.app-aside');
            var searchForm = elem.children('form');
            var formWrap = elem.parent();

            $(".s-open").on('click', function (e) {
                searchForm.prependTo(wrap);
                e.preventDefault();
                $(document).on("mousedown touchstart", closeForm);
            });
            $(".s-remove").on('click', function (e) {
                searchForm.appendTo(elem);
                e.preventDefault();
            });
            var closeForm = function (e) {
                if (!searchForm.is(e.target) && searchForm.has(e.target).length === 0) {
                    $(".s-remove").trigger('click');
                    $(document).off("mousedown touchstart", closeForm);
                }
            };
        }
    };
    function isSidebarClosed() {
        return $('.app-sidebar-closed').length;
    }

    function isSidebarFixed() {
        return $('.app-sidebar-fixed').length;
    }

}).directive('appAside', ['$window', '$rootScope', '$timeout', 'APP_MEDIAQUERY',
function ($window, $rootScope, $timeout, mq) {
    var $html = $('html'), $win = $($window), _this, wrap = $('.app-aside');
    return {
        restrict: 'AC',

        link: function (scope, elem, attrs, controllers) {
            var eventObject = isTouch() ? 'click' : 'mouseenter';
            var ul = "";
            var menuTitle;
            elem.on('click', 'a', function (e) {

                _this = $(this);
                if (isSidebarClosed() && !isMobile() && !_this.closest("ul").hasClass("sub-menu"))
                    return;

                _this.closest("ul").find(".open").not(".active").children("ul").not(_this.next()).slideUp(200).parent('.open').removeClass("open");
                if (_this.next().is('ul') && _this.parent().toggleClass('open')) {

                    _this.next().slideToggle(200, function () {
                        $win.trigger("resize");

                    });
                    e.stopPropagation();
                    e.preventDefault();
                } else {
                    $rootScope.toggle('sidebar', 'off');

                }
            });
            elem.on(eventObject, 'a', function (e) {
                if (!isSidebarClosed() || isMobile())
                    return;
                _this = $(this);

                if (!_this.parent().hasClass('hover') && !_this.closest("ul").hasClass("sub-menu")) {
                    wrapLeave();
                    _this.parent().addClass('hover');
                    menuTitle = _this.find(".item-inner").clone();
                    if (_this.parent().hasClass('active')) {
                        menuTitle.addClass("active");
                    }
                    var offset = $("#sidebar").position().top;
                    var itemTop = isSidebarFixed() ? _this.parent().position().top + offset : (_this.parent().position().top);
                    menuTitle.css({
                        position: isSidebarFixed() ? 'fixed' : 'absolute',
                        height: _this.outerHeight(),
                        top: itemTop
                    }).appendTo(wrap);
                    if (_this.next().is('ul')) {
                        ul = _this.next().clone(true);

                        ul.appendTo(wrap).css({
                            top: menuTitle.position().top + _this.outerHeight(),
                            position: isSidebarFixed() ? 'fixed' : 'absolute',
                        });
                        if (_this.parent().position().top + _this.outerHeight() + offset + ul.height() > $win.height() && isSidebarFixed()) {
                            ul.css('bottom', 0);
                        } else {
                            ul.css('bottom', 'auto');
                        }

                        wrap.children().first().scroll(function () {
                            if (isSidebarFixed())
                                wrapLeave();
                        });

                        setTimeout(function () {

                            if (!wrap.is(':empty')) {
                                $(document).on('click tap', wrapLeave);
                            }
                        }, 300);

                    } else {
                        ul = "";
                        return;
                    }

                }
            });
            wrap.on('mouseleave', function (e) {
                $(document).off('click tap', wrapLeave);
                $('.hover', wrap).removeClass('hover');
                $('> .item-inner', wrap).remove();
                $('> ul', wrap).remove();

            });


            $rootScope
                .$on('$locationChangeSuccess',
                    function () {
                        var newPath;
                        newPath = window.location.hash;
                        angular.forEach(elem.find('.main-navigation-menu a'), function (domLink) {
                            var link = angular.element(domLink);
                            var menu;
                            if (domLink.hash === newPath && (!isSidebarClosed() || isMobile())) {

                                if (link.closest("ul").hasClass("sub-menu")) {
                                    menu = link.closest("ul");
                                    var activeMenu = menu;
                                    menu.slideDown(200).parent().siblings().children('.sub-menu').slideUp(200, function () {
                                        $(this).parent().removeClass("open");
                                    });
                                } else {
                                    $('.sub-menu').slideUp(200, function () {
                                        $(this).parent().removeClass("open");
                                    });
                                }

                            }
                            activeMenu = null;
                            menu = null;
                        });
                    });

        }
    };
    function wrapLeave() {
        wrap.trigger('mouseleave');
    }
    function isTouch() {
        return $html.hasClass('touch');
    }

    function isMobile() {
        return $win.width() < mq.desktop;
    }

    function isSidebarClosed() {
        return $('.app-sidebar-closed').length;
    }

    function isSidebarFixed() {
        return $('.app-sidebar-fixed').length;
    }

}]);
