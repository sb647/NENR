package defuzzifier;

import domain.DomainElement;
import domain.IDomain;
import set.IFuzzySet;

public class COADefuzzifier implements Defuzzifier {

    public int defuzzyfie(IFuzzySet set) {

        IDomain domain = set.getDomain();
        double numerator = 0;
        double denominator = 0;

        for (DomainElement elem : domain) {
            numerator += (double) elem.getComponentValue(0) * set.getValueAt(elem);
            denominator += set.getValueAt(elem);
        }
        return (int)(numerator/denominator);
    }

}
