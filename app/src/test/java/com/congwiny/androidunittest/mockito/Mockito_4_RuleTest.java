package com.congwiny.androidunittest.mockito;

import com.congwiny.androidunittest.bean.Person;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertNotNull;

/**
 * Created by niuchong on 2017/12/13.
 */

public class Mockito_4_RuleTest {
    @Mock //<--使用@Mock注解
    private Person mPerson;

    @Rule //<--使用@Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testIsNotNull() {
        assertNotNull(mPerson);
    }
}
