package system;

import defuzzifier.COADefuzzifier;
import defuzzifier.Defuzzifier;
import domains.AccelerationRules;
import domains.LinguisticVariables;
import operations.IBinaryFunction;
import operations.Operations;
import rule.IfThenRule;
import set.IFuzzySet;
import rule.IRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AkcelFuzzySystemMin implements FuzzySystem {
    private Defuzzifier def;
    private List<IRule> rules = new ArrayList<>();

    public AkcelFuzzySystemMin(Defuzzifier def) {
        this.def = def;
        this.rules.addAll(AccelerationRules.getRules());

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
        AkcelFuzzySystemMin akc = new AkcelFuzzySystemMin(def);

        IFuzzySet set = akc.conclude(142, 64, 153 ,72 ,50, 1);
        System.out.println(set);
        System.out.println(def.defuzzyfie(set));

    }

}
