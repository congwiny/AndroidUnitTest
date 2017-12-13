package com.congwiny.androidunittest.mockito;

import com.congwiny.androidunittest.bean.Person;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Created by niuchong on 2017/12/13.
 */

public class Mockito_1_Test {
    @Test
    public void testIsNotNull(){
        Person mPerson = mock(Person.class); //<--使用mock方法
        assertNotNull(mPerson);
    }
}
