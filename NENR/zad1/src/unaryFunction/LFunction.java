package unaryFunction;

public class LFunction implements IIntUnaryFunction {

    private int alpha;
    private int beta;


    public LFunction(int alpha, int beta) {
        this.alpha = alpha;
        this.beta = beta;
    }

    @Override
    public double valueAt(int x) {
        if ( x < alpha) return 1;
        if ( x >= beta) return 0;
        else return (double) (beta - x) / (beta - alpha);

    }
}
