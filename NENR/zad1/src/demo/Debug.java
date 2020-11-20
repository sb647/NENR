package demo;

import domain.DomainElement;
import domain.IDomain;
import set.IFuzzySet;

public class Debug {

    public static void print(IDomain domain, String headingText) {
        if(headingText!=null) {
            System.out.println(headingText);
        }
        for(DomainElement e : domain) {
            System.out.println("Element domene: " + e);
        }
        System.out.println("Kardinalitet domene je: " + domain.getCardinality());
        System.out.println();
    }

    public static void print(IFuzzySet set, String headingText) {
        if (headingText!=null) {
            System.out.println(headingText);
        }

        for(DomainElement element : set.getDomain()) {
            System.out.println( "d(" + element.getComponentValue(0) + ")=" + set.getValueAt(element));
        }
        System.out.println();
    }


}
