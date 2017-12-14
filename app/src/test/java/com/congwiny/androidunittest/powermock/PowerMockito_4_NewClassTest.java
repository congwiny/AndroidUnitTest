package com.congwiny.androidunittest.powermock;

import com.congwiny.androidunittest.bean.Banana;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

/**
 * mock new方法
 */
@PrepareForTest({Banana.class})
public class PowerMockito_4_NewClassTest {

    /**
     * 上面我们有说到使用PowerMock就必须加@RunWith(PowerMockRunner.class)，
     * 但是我们毕竟有时会使用多个测试框架，可能@RunWith会占用。
     * 这时我们可以使用@Rule。
     */
    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Test
    public void testNewClass() throws Exception {
        //设置规则
        Banana banana = PowerMockito.mock(Banana.class);
        PowerMockito.when(banana.getBananaInfo()).thenReturn("大香蕉");
        PowerMockito.whenNew(Banana.class).withNoArguments().thenReturn(banana);

        /**
         * whenNew 方法的意思是之后 new 这个对象时，返回某个被 Mock 的对象而不是让真的 new 新的对象。
         * 如果构造方法有参数，可以在withNoArguments方法中传入。
         */
        Banana newBanana = new Banana();//返回的是banana
        Assert.assertSame(banana, newBanana);
        Assert.assertEquals("大香蕉",newBanana.getBananaInfo());
    }
}
