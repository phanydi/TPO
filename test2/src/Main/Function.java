package Main;

public class Function {
    public static double eps = 1E-8;

    public double MainFunc(double x){
        if (x<=0) return TrigoFunc(x);
        return LogarFunc(x);
    }

    public static double TrigoFunc(double x){
        //System.out.println(sec(x) + " " + csc(x) + " " + cos(x));
        return pow(( pow(sec(x),2) + csc(x) + cos(x)) * cos(x),2);
    }

    public double LogarFunc(double x){
        //System.out.println(ln(x) + " " + log_3(x) + " " + log_5(x));
        return (pow((log_5(x) - log_3(x)) - log_3(x), 2) / pow(ln(x), 3)) / log_5(x);
    }

    public static double preProcess(double x){ // Bring x down to range [-2*PI, 0]
        x = x % (Math.PI*2);
        return x;
    }

    public static double sin(double x){
        x = preProcess(x);

        double thisEps = 1E-10;
        double before, after, xn;
        int n;
        after = x;
        n = 1;
        xn = x;

        do {
            before = after;
            xn *= (-1)*x*x/2/n/(2*n+1);
            after += xn;
            n++;
        } while (Math.abs(Math.abs(after) - Math.abs(before)) > thisEps);
        return after;
    }

    public static double cos(double x){
        x = preProcess(x);
        //System.out.println(x);
        double sinx = sin(x);
        if ((x < -Math.PI/2) && (x > -3*Math.PI/2)) return -Math.sqrt(1-sinx*sinx);
            else return Math.sqrt(1- sinx*sinx);
    }

    public static double sec(double x){
        return 1/cos(x);
    }

    public static double csc(double x){
        return 1/sin(x);
    }

    public static double pow(double x, int n){
        double res = x;
        int loop = Math.abs(n);
        for (int i=2; i<=loop; i++) res *= x;
        if (n == 0) return 1;
        if (n < 0) return 1/res;
        return res;
    }

    public double ln(double x){
        double thisEps = 1E-10;
        double before, after, xn, base;
        int n;

        n = 2;
        xn = (x-1)/(x+1);
        base = xn*xn;
        after = xn;

        do {
            before = after;
            xn *= base;
            //System.out.println(xn + " " + (2*n-1));
            after += xn/(2*n-1);
            n++;
        } while (Math.abs(Math.abs(after) - Math.abs(before)) > thisEps);
        return 2*after;
    }

    public double log_3(double x){
        return ln(x)/ln(3);
    }

    public double log_5(double x){
        return ln(x)/ln(5);
    }
}
