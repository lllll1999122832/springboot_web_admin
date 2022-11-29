package com.example.springboot_web_admin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import java.util.Stack;

@SpringBootTest
@DisplayName("嵌套测试")
public class testingStackDemo {
    Stack<Object>stack;

    String Java;
    @Test
    void testFirst(){
        Assertions.assertNull(stack,"这个真的是空的");
        stack.forEach(System.out::println);
    }
    @Nested
    class testNested{
        @Test
        @BeforeEach
        void testBefore(){
            stack=new Stack<>();
        }
    }
    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,4})
    void testParameterizedTest(int j){
        System.out.println(j);
    }
}
