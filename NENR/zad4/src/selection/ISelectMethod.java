package selection;

import java.util.List;

public interface ISelectMethod {

    List<double[]> selectParents(List<double[]> population, double[] errors);

}
