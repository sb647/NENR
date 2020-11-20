package selection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TournamentSelection implements ISelectMethod {
    int N;

    public TournamentSelection (int N) {
        this.N = N;
    }

    @Override
    public List<double[]> selectParents(List<double[]> population, double[] errors) {
        List<Integer> indices = new ArrayList<>();
        List<double[]> result = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            int index;
            while(true){
                index = ThreadLocalRandom.current().nextInt(0, population.size());
                if(! indices.contains(Integer.valueOf(index))) {
                    indices.add(index);
                    result.add(population.get(index));
                    break;
                }
            }
        }

        return result;
    }


    private int findMin(double[] errors) {
        double min = errors[0];
        int index = 0;

        for(int i = 1; i < errors.length; i++) {
            if(errors[i] < min) {
                min = errors[i];
                index = i;
            }
        }
        return index;
    }
}
