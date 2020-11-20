package mutation;


import java.util.Random;

public class Mutation implements IMutation {

    private double p;
    private double sigma;
    private double min;
    private double max;

    public Mutation(double p, double sigma, double min, double max) {
        this.p = p;
        this.sigma = sigma;
        this.min = min;
        this.max = max;
    }

    @Override
    public double[] mutate(double[] child) {
       double[] mutant = child.clone();

       for(int i = 0; i < mutant.length; i ++) {
           if(Math.random() < p) {
               double value = mutant[i] + new Random().nextGaussian() * sigma;
               if(value < min) value = min;
               if(value > max) value = max;

               mutant[i] = value;
           }
       }
       return mutant;
    }
}
