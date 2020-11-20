package algorithm;

import crossing.ICrossover;
import function.IFunction;
import mutation.IMutation;
import selection.ISelectMethod;

import java.util.ArrayList;
import java.util.List;

public class EliminationAlgorithm extends GeneticAlgorithm {

    public EliminationAlgorithm(int numberOfIterations, double value,
                                int populationSize, List<double[]> data, IFunction function, ISelectMethod selector, ICrossover crossover, IMutation mutation) {


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
       List<double[]> sortedParents = sort(selector.selectParents(population, new double[3]));
       double[] kid = crossover.cross(sortedParents.get(0), sortedParents.get(1));
       kid = mutation.mutate(kid);

       for(int i = 0; i < population.size(); i++) {
           if(compare(population.get(i), sortedParents.get(2))) {
               population.remove(i);
               population.add(i, kid);
               break;
           }
       }


       return population;
    }

    private List<double[]> sort(List<double[]> parents) {
        List<double[]> result = new ArrayList<>();
        List<double[]> temp = this.clonePopulation(parents);
        while(! temp.isEmpty()) {
            int index = findIndexOfBestSolution(temp);
            result.add(temp.get(index));
            temp.remove(index);
        }
        return result;
    }

    private boolean compare(double[] array1, double[] array2) {
         for(int i = 0; i < array1.length; i++) {
            if(Math.abs(array1[i] - array2[i]) <= 0.000001) return false;
        }
         return true;
    }
}