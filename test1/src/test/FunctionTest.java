package test;

import main.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class FuntionTest {

    @Test
    void test0(){
        Assertions.assertEquals((1/Math.cos(0)), Function.sec(0), Function.eps,
                "Wrong value. Тест: sec(0)");
    }

    @Test
    void test1(){
        Assertions.assertEquals((1/Math.cos(1)), Function.sec(1), Function.eps,
                "Wrong value. Тест: sec(1)");
    }

    @Test
    void test1_5(){
        Assertions.assertEquals((1/Math.cos(1.5)), Function.sec(1.5), Function.eps,
                "Wrong value. Тест: sec(1.5)");
    }

    @Test
    void test1_7(){
        Assertions.assertEquals((1/Math.cos(1.7)), Function.sec(1.7), Function.eps,
                "Wrong value. Тест: sec(1.7) " + ((1/Math.cos(1.7))-Function.sec(1.7)));
    }

    @Test
    void test2(){
        Assertions.assertEquals((1/Math.cos(2)), Function.sec(2), Function.eps,
                "Wrong value. Тест: sec(1)");
    }

    @Test
    void test2_5(){
        Assertions.assertEquals((1/Math.cos(2.5)), Function.sec(2.5), Function.eps,
                "Wrong value. Тест: sec(2.5)");
    }

    @Test
    void test3(){
        Assertions.assertEquals((1/Math.cos(3)), Function.sec(3), Function.eps,
                "Wrong value. Тест: sec(3)");
    }

    @Test
    void test3_4(){
        Assertions.assertEquals((1/Math.cos(3.4)), Function.sec(3.4), Function.eps,
                "Wrong value. Тест: sec(3.4)");
    }




}
