package system;
import defuzzifier.COADefuzzifier;
import defuzzifier.Defuzzifier;
import domains.KormiloRules;
import operations.IBinaryFunction;
import operations.Operations;
import set.IFuzzySet;
import rule.IRule;

import java.util.ArrayList;
import java.util.List;

public class KormiloFuzzySystemMin implements FuzzySystem {

    private Defuzzifier def;
    private List<IRule> rules = new ArrayList<>();

    public KormiloFuzzySystemMin(Defuzzifier def) {
        this.def = def;
        this.rules.addAll(KormiloRules.getRules());
    }

    @Override
    public int defuzzy (int... values) {
        IFuzzySet set = this.conclude(values);
        return def.defuzzyfie(set);
    }

    public IFuzzySet conclude (int... values) {

        IFuzzySet set1 = rules.get(0).getConclusion(values);
        IBinaryFunction op = Operations.zadehOr();

        for(int i = 1; i < rules.size(); i++) {
            IFuzzySet set2 = rules.get(i).getConclusion(values);
            set1 = Operations.binaryOperation(set1,set2, op);
        }

        return set1;

    }

    public List<IRule> getRules() {
        return rules;
    }

    public static void main(String[] args) {
        COADefuzzifier def = new COADefuzzifier();
        KormiloFuzzySystemMin akc = new KormiloFuzzySystemMin(def);

        IFuzzySet set = akc.conclude(195,20, 275, 20 ,36 , 1);

        System.out.println(set);
        System.out.println(def.defuzzyfie(set));

    }


}
