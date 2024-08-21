/*
assertEquals(期望结果值，实际结果（方法及参数）)
浮点数：assertEquals(期望结果值，实际结果（方法及参数），允许误差范围)
assertTrue(): 期待结果为true
assertFalse(): 期待结果为false
assertNotNull(): 期待结果为非null
assertArrayEquals(): 期待结果为数组并与期望数组每个元素的值均相等
@Disabled ： 标记不要运行该测试   {@DisabledOnOs(OS.WINDOWS)：只能在xx系统运行；@DisabledOnJre(JRE.JAVA_8)：只能在java9
及更改版本运行；@EnabledIfSystemProperty：允许测试方法或测试类根据系统属性的值是否符合特定条件来启用或禁用；
@EnabledIfEnvironmentVariable(named = "DEBUG", matches = "true")：只有传入DEBUG=true才能执行测试}
* */
package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class FactorialTest {

    @Disabled         //忽略
    @Test
    void testFact() {
        assertEquals(1, Factorial.fact(0));
        assertEquals(1, Factorial.fact(1));
        assertEquals(2, Factorial.fact(2));
        assertEquals(6, Factorial.fact(3));
        assertEquals(3628800, Factorial.fact(10));
        assertEquals(2432902008176640000L, Factorial.fact(20));
    }

    @Test
    void testNegative() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Factorial.fact(-1);
            }
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.fact(-1);
        });
    }

    @Test
    void testLargeInput() {
        assertThrows(ArithmeticException.class, () -> {
            Factorial.fact(21);
        });
    }


}
