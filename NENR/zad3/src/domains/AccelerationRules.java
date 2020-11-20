package domains;

import set.IFuzzySet;
import rule.IRule;
import rule.IfThenRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccelerationRules {

    private static List<IFuzzySet> listAcc = Arrays.asList(new IFuzzySet[]{null, null, null, null, LinguisticVariables.Slow, null} );
    public static final IRule speedUpWhenSlow = new IfThenRule("IF Slow THEN Accelerate",LinguisticVariables.Accelerate,listAcc);

    private static List<IFuzzySet> listDec = Arrays.asList(new IFuzzySet[]{null, null, null, null, LinguisticVariables.Fast, null} );
    public static final IRule decelerateWhenFast = new IfThenRule("IF Fast THEN Decelerate",LinguisticVariables.Decelerate,listDec);

    private static List<IFuzzySet> listStrongAcc = Arrays.asList(new IFuzzySet[]{null, null, null, null, LinguisticVariables.TooSlow, null} );
    public static final IRule speedUpWhenTooSlow = new IfThenRule("IF Too Slow THEN Strong Accelerate",LinguisticVariables.StrongAccelerate,listStrongAcc);

    private static List<IFuzzySet> listStrongDec = Arrays.asList(new IFuzzySet[]{null, null, null, null, LinguisticVariables.TooFast, null} );
    public static final IRule decelerateWhenTooFast = new IfThenRule("IF Too Fast THEN Strong Decelerate",LinguisticVariables.StrongDecelerate,listStrongDec);



    public static List<IRule> getRules() {
        List<IRule> list = new ArrayList<>();
        list.add(speedUpWhenSlow);
        list.add(decelerateWhenFast);
        list.add(speedUpWhenTooSlow);
        list.add(decelerateWhenTooFast);

        return list;
    }

}
