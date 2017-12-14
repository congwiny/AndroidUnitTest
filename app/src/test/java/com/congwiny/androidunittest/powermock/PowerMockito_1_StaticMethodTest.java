package com.congwiny.androidunittest.powermock;

import com.congwiny.androidunittest.bean.Banana;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * 使用PowerMock必须加注解@PrepareForTest和@RunWith(PowerMockRunner.class)
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Banana.class})//@PrepareForTest里写的是静态方法所在的类
public class PowerMockito_1_StaticMethodTest {
    @Test
    public void testStaticMethod() {
        PowerMockito.mockStatic(Banana.class);//mock Banana静态方法
        Mockito.when(Banana.getColor()).thenReturn("绿色");
        Assert.assertEquals("绿色",Banana.getColor());
    }

    @Test
    public void testChangeColor(){//更改类的私有static常量
        Whitebox.setInternalState(Banana.class,"COLOR","红色的");
        Assert.assertEquals("红色的",Banana.getColor());
    }
}
