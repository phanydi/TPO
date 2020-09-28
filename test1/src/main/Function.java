package main;

public class Function {
    public static double eps = 1E-8;

    public static double sec(double x){
        if (Math.abs(x - Math.PI/2) < eps) {
            System.out.print("undefined\n");
        }
        double before, after, num;
        int  minus, current, lim;
        long[] factorial = new long[20];
        after = 1;
        minus = -1;
        lim = 0;
        factorial[0] = 1;
        current = 1;
        num = x*x;

        do {
            before = after;
            if (Long.MAX_VALUE /(current*(current + 1)) < factorial[lim]){
                lim++;
                factorial[lim] = 1;
            }
            factorial[lim] *=  current*(current + 1);
            //System.out.println( minus + " " + factorial[lim] + " " + lim);
            double tmp = minus * num;
            for (int i=0; i<=lim; i++)
                tmp /= factorial[i];
            after += tmp;

            minus *= -1;
            current += 2;
            num = num * x * x;

            //System.out.println(after + " " + Math.abs(after - before));
        } while (Math.abs(after - before) > eps);
        return 1/after;
    }

}
