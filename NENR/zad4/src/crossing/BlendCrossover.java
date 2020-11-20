package crossing;

public class BlendCrossover implements ICrossover {

    private double alpha;

    public BlendCrossover(double alpha) {
        this.alpha = alpha;
    }

    public double[] cross(double[] parent1, double[] parent2) {
        double[] child = new double[parent1.length];

        for(int i = 0; i < parent1.length; i++) {
            double min = parent1[i];
            double max = parent2[i];

            if(min > max) {
                double temp = min;
                min = max;
                max = temp;
            }
            double I = (max - min);
            double a = min - I * alpha;
            double b = max + I * alpha;

            double value =  Math.random() * (b - a) + a;

            if(value < min) value = min;
            if (value > max ) value = max;

            child[i] = value;

        }
        return child;
    }
}
