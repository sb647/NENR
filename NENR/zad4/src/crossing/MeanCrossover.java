package crossing;

public class MeanCrossover implements ICrossover{

    private double min;
    private double max;

    public MeanCrossover( double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public double[] cross(double[] parent1, double[] parent2) {
        double[] child = new double[parent1.length];

        for(int i = 0; i < parent1.length; i++) {
            double gene1 = parent1[i];
            double gene2 = parent2[i];

            double mean = (gene1 + gene2 )/ 2;
            if(mean < min) mean = min;
            if(mean > max) mean = max;

            child[i] = mean;
        }
        return child;
    }
}
