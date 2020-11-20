package function;

public class Function implements IFunction {


    public double calculate(double x, double y, double[] params) {
        double b0 = params[0];
        double b1 = params[1];
        double b2 = params[2];
        double b3 = params[3];
        double b4 = params[4];

        double result = Math.sin(b0 + b1*x) + b2*Math.cos(x*(b3+y)) *
                (double) 1 / (1 + Math.exp(Math.pow(x - b4, 2)));
        return  result;
    }
}
