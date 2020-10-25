package Test;

import Main.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;


public class TrigoFuncTest {

    static double step = 0.05;
    double eps = 1E-6;

    double mathTrigoFunc(double x){
        return Math.pow(( Math.pow(1/Math.cos(x),2) + 1/Math.sin(x) + Math.cos(x)) * Math.cos(x),2);
    }

    static ArrayList<Double> testFirstPartGenerated(){
        double start = -6;
        double end = -4.9;

        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            res.add(start);
            start += step;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testFirstPartGenerated")
    void testFirstPart(double x){
        Assertions.assertEquals(mathTrigoFunc(x), Function.TrigoFunc(x), eps,
                "Wrong value. Тест: first part for TrigoFunc(" + x +")");
    }

    static ArrayList<Double> testSecondPartGenerated(){
        double start = -4.6;
        double end = -3.2;

        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            res.add(start);
            start += step;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testSecondPartGenerated")
    void testSecondPart(double x){
        Assertions.assertEquals(mathTrigoFunc(x), Function.TrigoFunc(x), eps,
                "Wrong value. Тест: second part for TrigoFunc(" + x +")");
    }

    static ArrayList<Double> testThirdPartGenerated(){
        double start = -3.1;
        double end = -1.6;

        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            res.add(start);
            start += step;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testThirdPartGenerated")
    void testThirdPart(double x){
        Assertions.assertEquals(mathTrigoFunc(x), Function.TrigoFunc(x), eps,
                "Wrong value. Тест: third part for TrigoFunc(" + x +")");
    }

    static ArrayList<Double> testFourthPartGenerated(){
        double start = -1.5;
        double end = 0;

        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            res.add(start);
            start += step;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testFourthPartGenerated")
    void testFourthPart(double x){
        Assertions.assertEquals(mathTrigoFunc(x), Function.TrigoFunc(x), eps,
                "Wrong value. Тест: fourth part for TrigoFunc(" + x +")");
    }

    static ArrayList<Double> testPeriodGenerated(){
        double start = -6;
        double end = 0;

        ArrayList<Double> res = new ArrayList<Double>();
        while (start <= end){
            res.add(start);
            start += step;
        }
        return  res;
    }

    @ParameterizedTest
    @MethodSource("testPeriodGenerated")
    void testPeriod(double x){
        Assertions.assertEquals(Function.TrigoFunc(x-2*Math.PI), Function.TrigoFunc(x), eps,
                "Wrong value. Тест: test for period for TrigoFunc(" + x +")");
    }


}
