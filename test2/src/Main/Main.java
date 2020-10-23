package Main;

public class Main {
    public static void main(String[] args) {

        CsvWritter writter = new CsvWritter("result.csv");
        writter.printResult(-10.0 ,10.0, 0.5);
    }

    static void valueTest(){
        Function func = new Function();
        System.out.println((func.MainFunc(-2.5)));
        System.out.println((func.MainFunc(-1.5)));
        System.out.println((func.MainFunc(-0.5)));
        System.out.println((func.MainFunc(0.5)));
        System.out.println((func.MainFunc(1.5)));
        System.out.println((func.MainFunc(2.5)));
    }

}
