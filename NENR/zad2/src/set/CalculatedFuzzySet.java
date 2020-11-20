package set;

import domain.DomainElement;
import domain.IDomain;
import unaryFunction.IIntUnaryFunction;

public class CalculatedFuzzySet implements IFuzzySet {

    private IDomain domain;
    private IIntUnaryFunction function;

    public CalculatedFuzzySet(IDomain domain, IIntUnaryFunction function) {
        this.domain = domain;
        this.function = function;

    }

    @Override
    public IDomain getDomain() {
        return domain;
    }

    @Override
    public double getValueAt(DomainElement de) {
        return function.valueAt(domain.indexOfElementDomain(de));
    }
}
