package set;

import domain.DomainElement;
import domain.IDomain;

public interface IFuzzySet {

    public IDomain getDomain();

    public double getValueAt(DomainElement de);

}
