package com.congwiny.androidunittest.mockito;

import com.congwiny.androidunittest.bean.Person;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * Created by niuchong on 2017/12/13.
 */

public class Mockito_5_StubTest {
    @Mock //<--使用@Mock注解
    private Person mPerson;

    @Rule //<--使用@Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testPersonReturn(){
        /**
         * 使用when打桩方法时，语义：当执行什么方法时，然后就返回什么结果。
         * 当然如果我们不打桩，打印结果就是null和0了。
         */
        when(mPerson.getName()).thenReturn("小明");
        when(mPerson.getSex()).thenThrow(new NullPointerException("滑稽：性别不明"));
        // 输出"小明"
        System.out.println(mPerson.getName());
        //抛出异常
        //System.out.println(mPerson.getSex());

        /**
         * 如果使用doReturn等打桩方法时，语义为：以什么结果返回，当执行什么方法时。
         * thenReturn和doReturn这个两者的区别就是我们熟悉的while与do while。
         * doReturn这类方法主要是为了应对无法使用thenReturn等方法的场景（比如方法为void），可读性来说thenReturn这类更好。
         */
        doReturn("笑笑").when(mPerson).getName();
        // 输出"笑笑"
        System.out.println(mPerson.getName());
    }

    @Test
    public void testPersonAnswer() {
        //我们用thenAnswer拿到了吃进去的东西，将返回结果重新进行处理。(吃什么吐什么)
        when(mPerson.eat(anyString())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                return args[0].toString() + "真好吃";
            }
        });
        //牛肉真好吃
        System.out.println(mPerson.eat("牛肉"));
    }
}
