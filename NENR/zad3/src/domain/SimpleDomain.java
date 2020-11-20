package domain;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleDomain extends Domain {

    private int first;
    private int last;

    private static final int NUMBER_OF_COMPONENTS = 1;

    public SimpleDomain(int first, int last) {
        if(first < last) {
            this.first = first;
            this.last = last;
        } else {
            this.first = last;
            this.last = first;
        }

    }

    @Override
    public int getCardinality() {
        return Math.abs(this.last - this.first);
    }

    @Override
    public IDomain getComponent(int n) {
        return this;
    }

    @Override
    public int getNumberOfComponents() {
        return NUMBER_OF_COMPONENTS;
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }




    @Override
    public Iterator<DomainElement> iterator() {
        return new SimpleDomainIterator();
    }

    private class SimpleDomainIterator implements Iterator<DomainElement> {

        private int value;

        public SimpleDomainIterator() {
            this.value = SimpleDomain.this.first;
        }

        @Override
        public boolean hasNext() {
            return value < SimpleDomain.this.last;
        }

        @Override
        public DomainElement next() {
            if(hasNext()) {
                return new DomainElement(value++);
            }
            else
                throw new NoSuchElementException();
        }
    }

    @Override
    public String toString() {
        return "SimpleDomain{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }
}
