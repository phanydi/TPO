package Test;

import Main.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;

public class BasicFuncTest {
    double eps = 1E-6;

    static ArrayList<Double> testTrigoGenerated(){
        double step = 0.1;
        double start = -3.14;
        double end = 3.14;

        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            res.add(start);
            start += step;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testValueSin(double x){
        Assertions.assertEquals(Math.sin(x), Function.sin(x), eps,
                "Wrong value. Тест: sin(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testPeriodSin(double x){
        Assertions.assertEquals(Function.sin(x+2*Math.PI), Function.sin(x), eps,
                "Wrong value. Тест: period sin(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testValueCos(double x){
        Assertions.assertEquals(Math.cos(x), Function.cos(x), eps,
                "Wrong value. Тест: cos(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testPeriodCos(double x){
        Assertions.assertEquals(Function.cos(x+2*Math.PI), Function.cos(x), eps,
                "Wrong value. Тест: period cos(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testValueSec(double x){
        Assertions.assertEquals(1/Math.cos(x), Function.sec(x), eps,
                "Wrong value. Тест: sec(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testPeriodSec(double x){
        Assertions.assertEquals(Function.sec(x+2*Math.PI), Function.sec(x), eps,
                "Wrong value. Тест: period sec(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testValueCsc(double x){
        Assertions.assertEquals(1/Math.sin(x), Function.csc(x), eps,
                "Wrong value. Тест: csc(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testTrigoGenerated")
    void testPeriodCsc(double x){
        Assertions.assertEquals(Function.csc(x+2*Math.PI), Function.csc(x), eps,
                "Wrong value. Тест: period csc(" + x +")");
    }

    static ArrayList<Double> testLogarGenerated(){
        double step = 0.1;
        double start = step;
        double end = 5;

        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            res.add(start);
            start += step;
        }

        step = 2;
        start = 5 + step;
        end = 100;
        while (start <= end){
            res.add(start);
            start += step;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testLogarGenerated")
    void testValueLn(double x){
        Assertions.assertEquals(Math.log(x), Function.ln(x), eps,
                "Wrong value. Тест: csc(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testLogarGenerated")
    void testValueLog3(double x){
        Assertions.assertEquals(Math.log(x)/Math.log(3), Function.log_3(x), eps,
                "Wrong value. Тест: csc(" + x +")");
    }

    @ParameterizedTest
    @MethodSource("testLogarGenerated")
    void testValueLog5(double x){
        Assertions.assertEquals(Math.log(x)/Math.log(5), Function.log_5(x), eps,
                "Wrong value. Тест: csc(" + x +")");
    }
}
