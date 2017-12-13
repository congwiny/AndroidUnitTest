package com.congwiny.androidunittest.junit;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * 为每个Test都可加上这个，都会遵守这个规则
 * 不用再每个Test前后写@Before和@After了。
 */
public class MyRule implements TestRule {

    @Override
    public Statement apply(final Statement base, final Description description) {

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                // evaluate前执行方法相当于@Before
                String methodName = description.getMethodName(); // 获取测试方法的名字
                System.out.println(methodName + "测试开始！");

                base.evaluate();  // 运行的测试方法

                // evaluate后执行方法相当于@After
                System.out.println(methodName + "测试结束！");
            }
        };
    }

}
