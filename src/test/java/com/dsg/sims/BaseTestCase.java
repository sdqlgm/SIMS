package com.dsg.sims;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;

import junit.framework.TestCase;

/**
 * 公共单元测试类<br>
 * 所有单元测试父类<br>
 * 继承于此类的单元测试类须具备以下条件：<br>
 * 	1）"@Parameters"注解静态参数化结构方法，返回Collection
 *  2）具有测试期望值属性、测试参数属性
 *  3)带参数构造方法
 *  示例：
 *  @see com.dsg.sims.service.waitconversionqueue.TestJunit
 * @author chenjie
 * @createtime 2015-10-21 下午2:07:21
 */
@ContextConfiguration(locations = { "classpath*:applicationContext*.xml"})
public class BaseTestCase extends TestCase{

    protected Logger logger = LoggerFactory.getLogger("Junit Test");

	protected TestContextManager testContextManager;

	@Before
    public void beforeTest() throws Exception {
        this.testContextManager = new TestContextManager(getClass());
        this.testContextManager.prepareTestInstance(this);
    }

    @Test
    public void test1(){
        logger.info("1");
    }
}
