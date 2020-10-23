package Test;

import Main.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class TrigoFuncTest {

    double mathTrigoFunc(double x){
        return Math.pow(( Math.pow(sec(x),2) + csc(x) + cos(x)) * cos(x),2);
    }
    @ParameterizedTest
    @ValueSource(doubles = {1,2,3,4,5,6})
    void test0(double x){
        Assertions.assertEquals(Function.TrigoFunc(x), Function.sec(0), Function.eps,
                "Wrong value. Тест: sec(0)");
    }



}
