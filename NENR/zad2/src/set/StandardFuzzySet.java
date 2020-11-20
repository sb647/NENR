package set;

import unaryFunction.GammaFunction;
import unaryFunction.IIntUnaryFunction;
import unaryFunction.LFunction;
import unaryFunction.LambdaFunction;

public class StandardFuzzySet {

    public StandardFuzzySet() {
    }

    public static IIntUnaryFunction lFunction (int a, int b) { return new LFunction(a, b); }

    public static IIntUnaryFunction gammaFunction (int a, int b) {
        return new GammaFunction(a, b);
    }

    public static IIntUnaryFunction lambdaFunction( int a, int b, int g) {
        return new LambdaFunction(a, b, g);
    }
}
