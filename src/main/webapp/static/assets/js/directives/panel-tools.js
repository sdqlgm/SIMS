'use strict';
/** 
  * Add several features to panels.  
*/
app.directive('ctPaneltool', function () {
    var templates = {
        /* jshint multistr: true */
        collapse: "<a href='#' class='btn btn-transparent btn-sm' panel-collapse='' tooltip-placement='top' tooltip='Collapse' ng-click='{{panelId}} = !{{panelId}}' ng-init='{{panelId}}=false'>" + "<i ng-if='{{panelId}}' class='ti-plus'></i>" + "<i ng-if='!{{panelId}}' class='ti-minus'></i>" + "</a>",
        dismiss: "<a href='#' class='btn btn-transparent btn-sm' panel-dismiss='' tooltip-placement='top' tooltip='Close'>" + "<i class='ti-close'></i>" + "</a>",
        refresh: "<a href='#' class='btn btn-transparent btn-sm' panel-refresh='' tooltip-placement='top' tooltip='Refresh' data-spinner='{{spinner}}'>" + "<i class='ti-reload'></i>" + "</a>"
    };

    return {
        restrict: 'E',
        template: function (elem, attrs) {
            var temp = '';
            if (attrs.toolCollapse)
                temp += templates.collapse.replace(/{{panelId}}/g, (elem.parent().parent().attr('id')));
            if (attrs.toolDismiss)
                temp += templates.dismiss;
            if (attrs.toolRefresh)
                temp += templates.refresh.replace(/{{spinner}}/g, attrs.toolRefresh);
            return temp;
        }
    };
});
app.directive('panelDismiss', function () {
    'use strict';
    return {
        restrict: 'A',
        controller: function ($scope, $element) {
            var removeEvent = 'panel-remove', removedEvent = 'panel-removed';

            $element.on('click', function () {

                var parent = $(this).closest('.panel');

                destroyPanel();

                function destroyPanel() {
                    var col = parent.parent();
                    parent.fadeOut(300, function () {
                        $(this).remove();
                        if (col.is('[class*="col-"]') && col.children('*').length === 0) {
                            col.remove();
                        }
                    });
                }

            });
        }
    };
})

.directive('panelRefresh', function () {
    'use strict';

    return {
        restrict: 'A',
        controller: function ($scope, $element) {

            var refreshEvent = 'panel-refresh', csspinnerClass = 'csspinner', defaultSpinner = 'load1';

            // method to clear the spinner when done
            function removeSpinner() {
                this.removeClass(csspinnerClass);
            }

            // catch clicks to toggle panel refresh
            $element.on('click', function () {
                var $this = $(this), panel = $this.parents('.panel').eq(0), spinner = $this.data('spinner') || defaultSpinner;

                // start showing the spinner
                panel.addClass(csspinnerClass + ' ' + spinner);

                // attach as public method
                panel.removeSpinner = removeSpinner;

                // Trigger the event and send the panel object
                $this.trigger(refreshEvent, [panel]);

            });

        }
    };
});

(function ($, window, document) {
    'use strict';

    $(document).on('panel-refresh', '.panel', function (e, panel) {

        // perform any action when a .panel triggers a the refresh event
        setTimeout(function () {
            // when the action is done, just remove the spinner class
            panel.removeSpinner();
        }, 3000);

    });

}(jQuery, window, document));