package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvWritter {
    private File file;
    Function function = new Function();
    StringBuilder sb = new StringBuilder();

    public CsvWritter(String fileName, double start, double end, double step){
        try (PrintWriter log = new PrintWriter(new File(fileName))) {
            sb.append("x"); sb.append(',');
            sb.append("Value"); sb.append(',');
            sb.append("sin(x)"); sb.append(',');
            sb.append("cos(x)"); sb.append(',');
            sb.append("sec(x)"); sb.append(',');
            sb.append("csc(x)"); sb.append(',');
            sb.append("ln(x)"); sb.append(',');
            sb.append("log_3(x)"); sb.append(',');
            sb.append("log_5(x)"); sb.append('\n');

            Double i = start;
            while (i < end) {
                write(i);
                i += step;
            }

            log.write(sb.toString());
            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void write(Double x) {
        if (x<=0){
            sb.append(x); sb.append(',');
            sb.append(function.MainFunc(x)); sb.append(',');
            sb.append(function.sin(x)); sb.append(',');
            sb.append(function.cos(x)); sb.append(',');
            sb.append(function.sec(x)); sb.append(',');
            sb.append(function.csc(x)); sb.append('\n');
        } else {
            sb.append(x); sb.append(',');
            sb.append(function.MainFunc(x)); sb.append(',');
            sb.append(function.sin(x)); sb.append(',');
            sb.append(function.cos(x)); sb.append(',');
            sb.append(function.sec(x)); sb.append(',');
            sb.append(function.csc(x)); sb.append(',');
            sb.append(function.ln(x)); sb.append(',');
            sb.append(function.log_3(x)); sb.append(',');
            sb.append(function.log_5(x)); sb.append('\n');
        }

    }

}
