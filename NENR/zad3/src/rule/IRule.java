package rule;

import set.IFuzzySet;

public interface IRule {
    public IFuzzySet getConclusion(int... elems);


    public String getName();


}
