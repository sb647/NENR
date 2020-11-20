package domain;

import java.util.*;

public class CompositeDomain extends Domain {

    private List<SimpleDomain> domains;

    public CompositeDomain(SimpleDomain... domains) {
        this.domains = new ArrayList<>();
        this.domains.addAll(Arrays.asList(domains));
    }

    @Override
    public int getCardinality() {
        int cardinality = 1;
        for(SimpleDomain d : domains) {
            cardinality *= d.getCardinality();
        }

        return cardinality;
    }

    @Override
    public IDomain getComponent(int n) {
        if ( n >= 0 && n < domains.size()) {
            return domains.get(n);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int getNumberOfComponents() {
        return domains.size();
    }

    @Override
    public Iterator<DomainElement> iterator() {
        return new CompositeDomainIterator();
    }

    private class CompositeDomainIterator implements Iterator<DomainElement> {

        private int index = 0;
        private int cardinality = CompositeDomain.this.getCardinality();

        private List<Iterator<DomainElement>> iterators = new ArrayList<>();
        private List<DomainElement> elementToReturn = new ArrayList<>();

        public CompositeDomainIterator() {

            for(SimpleDomain d : domains) {
                iterators.add(d.iterator());
            }
        }

        @Override
        public boolean hasNext() {
            return index < cardinality;
        }

        @Override
        public DomainElement next() {
            if(hasNext()) {
                updateElementToReturn();
                index++;

                List<Integer> l = new ArrayList<>();
                for( DomainElement c : elementToReturn) {
                    l.add(c.getValues()[0]);
                }

                return new DomainElement(l.stream().mapToInt(i->i).toArray());
            } else {
                throw new NoSuchElementException();
            }
        }

        private void updateElementToReturn () {

            if (index == 0) {
                for (Iterator<DomainElement> i : iterators) {
                    elementToReturn.add(i.next());
                }
            } else {
                for(int i = iterators.size()-1; i >= 0; i--) {

                    Iterator<DomainElement> iterator = iterators.get(i);

                    if( iterator.hasNext()) {
                        elementToReturn.set(i,iterator.next());
                        break;
                    } else {

                        iterators.set(i, CompositeDomain.this.domains.get(i).iterator());
                        elementToReturn.set(i, iterators.get(i).next());
                    }

                }

            }
        }
    }
}
