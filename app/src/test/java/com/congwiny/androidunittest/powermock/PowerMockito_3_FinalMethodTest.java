package com.congwiny.androidunittest.powermock;

import com.congwiny.androidunittest.bean.Banana;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * mock final方法
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Banana.class})
public class PowerMockito_3_FinalMethodTest {

    @Test
    public void testFinalMethod() throws Exception {
        Banana banana = PowerMockito.mock(Banana.class);
        PowerMockito.when(banana.isLike()).thenReturn(false);//修改final方法的返回值
        Assert.assertFalse(banana.isLike());
    }
}
