package Test;

import Main.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

public class LogarFuncTest {
    double eps = 1E-6;

    double mathLogarFunc(double x){
        return (Math.pow((Math.log(x)/Math.log(5) - Math.log(x)/Math.log(3)) - Math.log(x)/Math.log(3), 2) / Math.pow(Math.log(x), 3)) / (Math.log(x)/Math.log(5));
    }

    static ArrayList<Double> testFirstPartGenerated(){
        double step = 0.01;
        double start = step;
        double end = 1;


        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            res.add(start);
            start += step;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testFirstPartGenerated")
    //@ValueSource(doubles = {0.625})
    void testFirstPart(double x){
        Assertions.assertEquals(mathLogarFunc(x), Function.LogarFunc(x), eps,
                "Wrong value. Тест: first part for LogarFunc(" + x +")");
    }

    static ArrayList<Double> testSecondPartGenerated(){
        double step = 0.01;
        double start = 1 + step;
        double end = 4;

        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            res.add(start);
            start += step;
        }

        step = 1;
        start = 4;
        end = 100;

        while (start <= end){
            res.add(start);
            start += step;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testSecondPartGenerated")
    void testSecondPart(double x){
        Assertions.assertEquals(mathLogarFunc(x), Function.LogarFunc(x), eps,
                "Wrong value. Тест: second part for LogarFunc(" + x +")");
    }
}
