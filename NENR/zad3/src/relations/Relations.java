package relations;

import domain.*;
import set.IFuzzySet;
import set.MutableFuzzySet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Relations {

    public static boolean isUtimesURelation(IFuzzySet relation) {

        IDomain domain = relation.getDomain();
        if (domain.getNumberOfComponents() != 2) return false;
        else return domain.getComponent(0).equals(domain.getComponent(1));

    }

    public static boolean isSymmetric(IFuzzySet relation) {

        if (! isUtimesURelation(relation)) return false;
        IDomain domain = relation.getDomain();
        for(DomainElement element : domain) {
            if(relation.getValueAt(element) != relation.getValueAt(DomainElement.of(element.getComponentValue(1),
                    element.getComponentValue(0)))) return false;
        }

        return true;
    }

    public static boolean isReflexive(IFuzzySet relation) {

        if (! isUtimesURelation(relation)) return false;
        IDomain domain = relation.getDomain();
        for (DomainElement element : domain) {
            if (element.getComponentValue(0) != element.getComponentValue(1)) continue;
            if (relation.getValueAt(element) != 1) return false;
        }

        return true;
    }

    public static boolean isMaxMinTransitive(IFuzzySet relation) {
        if (! isUtimesURelation(relation)) return false;
        IDomain domain = relation.getDomain();

        for(DomainElement xy : domain) {
            for(DomainElement yz : domain) {

                if( xy.getComponentValue(1) != yz.getComponentValue(0)) continue;

                double xzValue = relation.getValueAt(DomainElement.of(xy.getComponentValue(0), yz.getComponentValue(1)));
                double xyValue = relation.getValueAt(DomainElement.of(xy.getComponentValue(0), yz.getComponentValue(0)));
                double yzValue = relation.getValueAt(DomainElement.of(xy.getComponentValue(1), yz.getComponentValue(1)));

                if(xzValue < Math.min (xyValue, yzValue)) return false;
            }

        }
        return true;
    }

    public static boolean  isFuzzyEquivalence(IFuzzySet relation) {
        return  (isReflexive(relation) && isSymmetric(relation) && isMaxMinTransitive(relation));
    }

    public static IFuzzySet compositionOfBinaryRelations(IFuzzySet r1,IFuzzySet r2) {
        if(! r1.getDomain().getComponent(1).equals(r2.getDomain().getComponent(0))) {
            throw new IllegalArgumentException("Incompatible relations!");
        }

        IDomain uDomain = r1.getDomain().getComponent(0);
        IDomain vDomain = r1.getDomain().getComponent(1);
        IDomain wDomain = r2.getDomain().getComponent(1);
        Domain uw = new CompositeDomain((SimpleDomain) uDomain, (SimpleDomain) wDomain);
        MutableFuzzySet result = new MutableFuzzySet(uw);

        for (DomainElement u : uDomain) {
            for (DomainElement w : wDomain) {

                List<Double> list = new ArrayList<>();
                for (DomainElement v : vDomain) {
                    double uvValue = r1.getValueAt(DomainElement.of(u.getComponentValue(0), v.getComponentValue(0)));
                    double vwValue = r2.getValueAt(DomainElement.of(v.getComponentValue(0), w.getComponentValue(0)));
                    list.add(Math.min(uvValue, vwValue));
                }

                double max = Collections.max(list);
                result.set(DomainElement.of(u.getComponentValue(0), w.getComponentValue(0)), max);
            }
        }
        return result;
    }
}
