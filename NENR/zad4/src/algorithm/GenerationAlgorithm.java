package algorithm;

import crossing.ICrossover;
import function.IFunction;
import mutation.IMutation;
import selection.ISelectMethod;

import java.util.ArrayList;
import java.util.List;

public class GenerationAlgorithm extends GeneticAlgorithm {

    public GenerationAlgorithm(boolean elitism, int numberOfIterations, double value,
                               int populationSize, List<double[]> data, IFunction function, ISelectMethod selector, ICrossover crossover, IMutation mutation) {
        this.elitism = elitism;
        this.numberOfIterations = numberOfIterations;
        this.tolerance = value;
        this.populationSize = populationSize;
        this.data = data;
        this.function = function;
        this.startingPopulation = generateStartingPopulation(populationSize);
        this.selector = selector;
        this.crossover = crossover;
        this.mutation = mutation;

    }

    @Override
    public List<double[]> createNextGeneration(List<double[]> population, int solutionIndex) {
        List<double[]> nextGeneration = new ArrayList<>();
        if (elitism) nextGeneration.add(population.get(solutionIndex));

        while(nextGeneration.size() < population.size()) {
            List<double[]> parents = selector.selectParents(population, calculateError(population));
            double[] child1 = crossover.cross(parents.get(0), parents.get(1));
            double[] child2 = crossover.cross(parents.get(0), parents.get(1));
            child1 = mutation.mutate(child1);
            child2 = mutation.mutate(child2);
            nextGeneration.add(child1);
            if(nextGeneration.size() < population.size()) nextGeneration.add(child2);

        }
        return nextGeneration;
    }

    private double[] calculateError(List<double[]> population) {
        double[] errors = new double[population.size()];
        for(int i =  0; i < errors.length; i++) {
            errors[i] = meanSquaredError(population.get(i));
        }
        return errors;
    }
}
