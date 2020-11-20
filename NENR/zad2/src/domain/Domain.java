package domain;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class Domain implements IDomain {

    public Domain() {
    }


    public static IDomain intRange(int first, int last) {
        return new SimpleDomain(first, last);
    }

    public static Domain combine(IDomain d1, IDomain d2) {
        return new CompositeDomain( (SimpleDomain)d1, (SimpleDomain) d2);
    }


    @Override
    public int indexOfElementDomain(DomainElement element) {
        int index = 0;

        for (DomainElement e : this) {
            if (e.equals(element)) return index;
            else index++;
        }

            throw new NoSuchElementException();

    }

    @Override
    public DomainElement elementForIndex(int n) {
        int index = 0;

        for (DomainElement e : this) {
            if (index == n) return e;
            else index++;
        }

        throw new IndexOutOfBoundsException();

    }

    @Override
    public Iterator<DomainElement> iterator() {
        return null;
    }
}
