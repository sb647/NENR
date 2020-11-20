package system;

import set.IFuzzySet;

import java.util.List;

public interface FuzzySystem {

    public int defuzzy(int... values);

    public IFuzzySet conclude (int... values);



}
