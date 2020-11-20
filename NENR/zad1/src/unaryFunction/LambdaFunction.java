package unaryFunction;

public class LambdaFunction implements  IIntUnaryFunction {

    private int alpha;
    private int beta;
    private int gamma;

    public LambdaFunction(int alpha, int beta, int gamma) {
        this.alpha = alpha;
        this.beta = beta;
        this.gamma = gamma;
    }

    @Override
    public double valueAt(int x) {
        if (x < alpha || x >= gamma) return 0;
        else if( x >= alpha && x < beta) return (x - alpha) / (beta - alpha);
        else return (double) (gamma - x) / (gamma - beta);

    }
}
