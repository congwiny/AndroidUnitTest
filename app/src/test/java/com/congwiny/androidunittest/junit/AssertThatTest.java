package com.congwiny.androidunittest.junit;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

/**
 * assertThat(T actual, Matcher<? super T> matcher);
 * assertThat(String reason, T actual, Matcher<? super T> matcher);
 */
public class AssertThatTest {

    @Test
    public void testMobilePhone() throws Exception {
        //assertThat("13588888888", new IsMobilePhoneMatcher());
        assertThat("123", new IsMobilePhoneMatcher());
    }

    @Test
    public void testAssertThat1() throws Exception {
        assertThat(6, is(6));
    }

    @Test
    public void testAssertThat2() throws Exception {
        assertThat("2", nullValue());
    }

    @Test
    public void testAssertThat3() throws Exception {
        assertThat("Hello UT", both(startsWith("Hello")).and(endsWith("AUT")));
    }

    /**
     * 自定义匹配器，继承自BaseMatcher
     */
    private class IsMobilePhoneMatcher extends BaseMatcher<String> {

        /**
         *
         * 进行断言判定，返回true则断言成功，否则断言失败
         * @param item
         * @return
         */
        @Override
        public boolean matches(Object item) {
            if (item == null) {
                return false;
            }
            Pattern pattern = Pattern.compile("(1|861)([3578])\\d{9}$*");
            Matcher matcher = pattern.matcher((String) item);
            return matcher.find();
        }

        /**
         *
         * 给期待断言成功的对象增加描述
         * @param description
         */
        @Override
        public void describeTo(Description description) {
            description.appendText("预计此字符串是手机号码！");
        }

        /**
         * 给断言失败的对象增加描述
         */
        @Override
        public void describeMismatch(Object item, Description description) {
            description.appendText(item.toString() + "不是手机号码！");
        }
    }
}