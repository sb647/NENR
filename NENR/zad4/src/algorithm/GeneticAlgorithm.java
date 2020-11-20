package algorithm;

import crossing.ICrossover;
import function.IFunction;
import mutation.IMutation;
import selection.ISelectMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class GeneticAlgorithm {
    private static final int SIZE = 5;
    private static final int MIN_VALUE = -4;
    private static final int MAX_VALUE = 4;

    int populationSize;
    boolean elitism;
    int numberOfIterations;
    double tolerance;
    List<double[]> startingPopulation;
    List<double[]> data;
    IFunction function;
    ISelectMethod selector;
    ICrossover crossover;
    IMutation mutation;

    public void execute() {
        int t = 0;
        List<double[]> population = this.clonePopulation(startingPopulation);
        int solutionIndex = findIndexOfBestSolution(population);
        double lowestError = meanSquaredError(population.get(solutionIndex));

        while(t < numberOfIterations && lowestError > tolerance) {
            solutionIndex = findIndexOfBestSolution(population);
            double error = meanSquaredError(population.get(solutionIndex));

            if (t == 0 || error < lowestError) {
                lowestError = error;
                System.out.println(t + ". iteration:");
                double[] beta = population.get(solutionIndex);
                System.out.println("Beta0 = " + beta[0] + " Beta1 = " + beta[1] + " Beta2 = " + beta[2] +
                        " Beta3 = " + beta[3] + " Beta4 = " + beta[4]);
                System.out.println("Mean Squared Error: " + lowestError);
            }

            t++;
            population = createNextGeneration(population, solutionIndex);
        }
    }

    public List<double[]> createNextGeneration(List<double[]> population, int solutionIndex) {
        return new ArrayList<>();
    }

    public double meanSquaredError(double[] beta){
        double realOutput, output, x, y;
        double sum = 0;
        for(int i = 0; i < data.size(); i++) {
            x = data.get(i)[0];
            y = data.get(i)[1];
            realOutput = data.get(i)[2];
            output = function.calculate(x, y, beta);
            sum += Math.pow(realOutput - output, 2);
        }
        return (double) sum / data.size();
    }


    public List<double[]> generateStartingPopulation(int size) {
        List<double[]> list = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            double[] beta = new double[SIZE];
            double random;
            for(int j = 0; j < SIZE; j++) {
                random = ThreadLocalRandom.current().nextDouble(MIN_VALUE, MAX_VALUE);
                beta[j] = random;
            }
            list.add(beta);
        }
        return list;
    }

    public List<double[]> clonePopulation(List<double[]> startingPopulation) {
        List<double[]> list = new ArrayList<>();

        for(double[] p : startingPopulation) {
            list.add(p.clone());
        }
        return list;
    }

    int findIndexOfBestSolution(List<double[]> population) {
        double[] beta = population.get(0);
        int index = 0;
        double min = meanSquaredError(beta);
        double value;
        for(int i = 1; i < population.size(); i++) {
            value = meanSquaredError(population.get(i));
            if(value < min) {
                min = value;
                index = i;
            }
        }
        return index;
    }

    public String arrayToString(double[] solution) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < solution.length; i++) {
            sb.append(solution[i]);
            sb.append(" ");
        }
        return sb.toString();

    }

}
