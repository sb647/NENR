package rule;

import domain.DomainElement;
import domains.LinguisticVariables;
import rule.IRule;
import set.IFuzzySet;
import set.MutableFuzzySet;

import java.util.Arrays;
import java.util.List;

public class IfThenRule implements IRule {

    private IFuzzySet consecvent;
    private List<IFuzzySet> relations;
    private String name;

    public IfThenRule(String name, IFuzzySet consecvent, List<IFuzzySet> relations) {
        this.name = name;
        this.consecvent = consecvent;
        this.relations = relations;

    }

    public IFuzzySet getConclusion(int... elems) {

        double membership = 1;
        for(int i = 0; i < relations.size(); i++) {
            if(relations.get(i) == null) continue;

            //minimum machine
            DomainElement el = DomainElement.of(elems[i]);
            membership *= relations.get(i).getValueAt(el);
        }

        MutableFuzzySet result = new MutableFuzzySet(consecvent.getDomain());

        for(DomainElement el : result.getDomain()) {
            result = result.set(el, consecvent.getValueAt(el) * membership);
        }

        return result;
    }

    public String getName() {
        return name;
    }


}
