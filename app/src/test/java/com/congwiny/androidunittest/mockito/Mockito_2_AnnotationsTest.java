package com.congwiny.androidunittest.mockito;

import com.congwiny.androidunittest.bean.Person;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;

/**
 * Created by niuchong on 2017/12/13.
 */

public class Mockito_2_AnnotationsTest {
    @Mock //<--使用@Mock注解
    private Person mPerson;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this); //<--初始化
    }

    @Test
    public void testIsNotNull() {
        assertNotNull(mPerson);
    }
}
