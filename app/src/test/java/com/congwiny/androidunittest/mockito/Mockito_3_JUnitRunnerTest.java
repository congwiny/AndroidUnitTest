package com.congwiny.androidunittest.mockito;

import com.congwiny.androidunittest.bean.Person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by niuchong on 2017/12/13.
 */
@RunWith(MockitoJUnitRunner.class) //<--使用MockitoJUnitRunner运行器
public class Mockito_3_JUnitRunnerTest {
    @Mock //<--使用@Mock注解
    private Person mPerson;

    @Test
    public void testIsNotNull() {
        assertNotNull(mPerson);
    }
}
