package com.congwiny.androidunittest.junit.utils;

import com.congwiny.androidunittest.utils.DateUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DateFormatTest {

    private String time;

    public DateFormatTest(String time){
        this.time = time;
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("测试开始！");
    }

    @Parameterized.Parameters
    public static Collection<String> data() {
        return Arrays.asList(
                "2017-10-15",
                "2017-10-15 16:00:02",
                "2017年10月15日 16时00分02秒"
        );
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束！");
    }

    @Test(expected = ParseException.class)
    public void dateToStamp() throws Exception {
        DateUtil.dateToStamp(time);
    }

}