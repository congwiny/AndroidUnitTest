package com.congwiny.androidunittest.powermock;

import com.congwiny.androidunittest.bean.Banana;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Banana.class})
public class PowerMockito_2_PrivateMethodTest {
    @Test
    public void testPrivateMethod() throws Exception {
        Banana banana = PowerMockito.mock(Banana.class);
        PowerMockito.when(banana.getBananaInfo()).thenCallRealMethod();
        PowerMockito.when(banana,"flavor").thenReturn("苦苦的");
        Assert.assertEquals("苦苦的黄色的", banana.getBananaInfo());
        //验证flavor是否调用了一次
        PowerMockito.verifyPrivate(banana).invoke("flavor");
    }

    @Test
    public void skipPrivateMethod() {//跳过私有方法
        Banana banana = new Banana();
        //跳过flavor方法
        PowerMockito.suppress(PowerMockito.method(Banana.class,"flavor"));
        Assert.assertEquals("null黄色的",banana.getBananaInfo());
    }

    @Test
    public void testChangeParentPrivate() throws Exception {
        Banana banana = new Banana();
        MemberModifier.field(Banana.class,"fruit").set(banana,"蔬菜");
        Assert.assertEquals("蔬菜", banana.getFruit());
    }
}
