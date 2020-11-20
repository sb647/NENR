package domain;

public interface IDomain extends Iterable<DomainElement> {

    public int getCardinality();

    public IDomain getComponent(int n);

    public int getNumberOfComponents();

    public int indexOfElementDomain(DomainElement element);

    public DomainElement elementForIndex(int n);
}
