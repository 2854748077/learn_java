/*
* @BeforeEach:每一个test之前都执行
* @AfterEach：每一个test之后都执行
* @BeforeAll和@AfterAll：在所有@Test方法运行前后仅运行一次，只能初始化静态变量
* */
package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator c;
    @BeforeEach
    public void setup(){
        this.c=new Calculator();
    }
    @AfterEach
    public void tearDown(){
        this.c=null;
    }
    @Test
    void test(){
        assertEquals(1,this.c.add(1));
        assertEquals(3,this.c.add(2));
        assertEquals(1,this.c.sub(2));
    }
}