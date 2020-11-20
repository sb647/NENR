package demo;

import algorithm.EliminationAlgorithm;
import algorithm.GenerationAlgorithm;
import crossing.BlendCrossover;
import crossing.ICrossover;
import function.Function;
import function.IFunction;
import mutation.IMutation;
import mutation.Mutation;
import selection.ISelectMethod;
import selection.RouletteWheelSelection;
import selection.TournamentSelection;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int MIN = -4;
    private static final int MAX = 4;
    private static final int N = 3;
    private static final int POPULATION_SIZE = 50;
    private static final int ITERATIONS = 1000;
    private static final double TOLERANCE = 0.001;

    public static void main(String[] args) {
        List<double[]> list = new ArrayList<>();

        try{
            list = Util.parseFile(args[0]);
        } catch(Exception ex) {

        }

        IFunction func = new Function();
        double pOfMutation = Double.valueOf(args[1]);
        double factor = Double.valueOf(args[2]);
        double alpha = Double.valueOf(args[3]);


        IMutation mutation = new Mutation(pOfMutation, factor, MIN, MAX);
        ICrossover cross = new BlendCrossover(alpha);
        ISelectMethod selector = new TournamentSelection(N);
        ISelectMethod roulette = new RouletteWheelSelection();

        //System.out.println("Elimination Algorithm: ");
        //EliminationAlgorithm ea = new EliminationAlgorithm(ITERATIONS,  TOLERANCE, POPULATION_SIZE, list, func, selector, cross, mutation);
        //ea.execute();

        System.out.println();
        System.out.println("Generation Algorithm: ");
        GenerationAlgorithm ga = new GenerationAlgorithm(true,  ITERATIONS, TOLERANCE, POPULATION_SIZE, list, func, roulette, cross, mutation);
        ga.execute();
    }
}
