package unaryFunction;

public class GammaFunction implements IIntUnaryFunction {

    private int alpha;
    private int beta;


    public GammaFunction(int alpha, int beta) {
        this.alpha = alpha;
        this.beta = beta;
    }

    @Override
    public double valueAt(int x) {
        if (x < alpha) return 0;
        if (x >= beta) return 1;
        else return (double) (x - alpha) / (beta - alpha);
    }
}
