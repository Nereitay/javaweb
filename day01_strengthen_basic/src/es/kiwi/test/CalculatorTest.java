package es.kiwi.test;

import es.kiwi.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试add方法
 */
public class CalculatorTest {

    /**
     * 所有测试方法执行之前，用于资源的申请
     */
    @Before
    public void init() {
        System.out.println("init...");
    }

    /**
     * 释放资源,出现异常依然会执行
     */
    @After
    public void close() {
        System.out.println("close....");
    }

    @Test
    public void testAdd() {
//        System.out.println("我被执行了");

        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);
        // 断言
        Assert.assertEquals(3, result);
    }

    @Test
    public void testSub() {
        Calculator calculator = new Calculator();
        int result = calculator.sub(1, 2);

        Assert.assertEquals(-1, result);

    }

}
