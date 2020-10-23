package Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CsvWritter {
    private File file;
    Function function = new Function();

    public CsvWritter(String fileName){
        File file = new File(fileName);
        if (file.exists()){
            boolean st = file.delete();
        }

        try {
            boolean created = file.createNewFile();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        this.file = file;
    }

    public void printResult(double start, double end, double step) {
            String heading = String.format("%20s", "x")  + " | " +
                    String.format("%20s", "Value")  + " | " +
                    String.format("%20s", "sin(x)")  + " | " +
                    String.format("%20s", "cos(x)")  + " | " +
                    String.format("%20s", "sec(x)")  + " | " +
                    String.format("%20s", "csc(x)")  + " || " +
                    String.format("%20s", "ln(x)")  + " | " +
                    String.format("%20s", "log_3(x)")  + " | " +
                    String.format("%20s", "log_5(x)")
                    ;
            write(heading);
            Double i = start;
            while (i < end) {

                write(i);
                i += step;
            }
        }

    public void write(Double x) {
        try {
            //String new_line = x + " , " + value + "\n";
            String new_line;
            if (x<=0){
                new_line = String.format("%20s", x) + " | " +
                        String.format("%20s", function.MainFunc(x)) + " | " +
                        String.format("%20s", function.sin(x)) + " | " +
                        String.format("%20s", function.cos(x)) + " | " +
                        String.format("%20s", function.sec(x)) + " | " +
                        String.format("%20s", function.csc(x))  + " || " +
                        String.format("%20s", "_")  + " | " +
                        String.format("%20s", "_")  + " | " +
                        String.format("%20s", "_") + "\n";
            } else {
                new_line = String.format("%20s", x) + " | " +
                        String.format("%20s", function.MainFunc(x)) + " | " +
                        String.format("%20s", "_")  + " | " +
                        String.format("%20s", "_")  + " | " +
                        String.format("%20s", "_")  + " | " +
                        String.format("%20s", "_")  + " || " +
                        String.format("%20s", function.ln(x))  + " | " +
                        String.format("%20s", function.log_3(x))  + " | " +
                        String.format("%20s", function.log_5(x)) + "\n";
            }

            String path = file.getPath();
            Files.write(Paths.get(path), new_line.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void write(String str) {
        try {
            String new_line = str + "\n";
            String path = file.getPath();
            Files.write(Paths.get(path), new_line.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
