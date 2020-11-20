package set;

import domain.DomainElement;
import domain.IDomain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MutableFuzzySet implements IFuzzySet {

    private double[] memberships;
    private IDomain domain;

    public MutableFuzzySet( IDomain domain) {
        this.domain = domain;
        this.memberships = new double[domain.getCardinality()];

    }

    @Override
    public IDomain getDomain() {
        return domain;
    }

    @Override
    public double getValueAt(DomainElement de) {
        int index;
        try {
            index = domain.indexOfElementDomain(de);
            return memberships[index];
        } catch (Exception ex) {
            throw new NoSuchElementException();
        }
    }


    public MutableFuzzySet set(DomainElement de, double value) {
        if (value < 0 || value > 1) throw new IllegalArgumentException();
        int index;
        try {
            index = domain.indexOfElementDomain(de);
            memberships[index] = value;
        } catch (Exception ex) {
            throw new NoSuchElementException();
        }

        return this;
    }

    @Override
    public String toString() {
        return "MutableFuzzySet{" +
                "memberships=" + Arrays.toString(memberships) +
                ", domain=" + domain +
                '}';
    }
}
