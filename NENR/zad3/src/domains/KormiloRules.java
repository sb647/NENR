package domains;

import domain.Domain;
import rule.IRule;
import rule.IfThenRule;
import set.IFuzzySet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KormiloRules {

    // L, D, LK, DK, V i S
    private static List<IFuzzySet> list = Arrays.asList(new IFuzzySet[]{null, null, LinguisticVariables.VerySmallDistanceToShore, null, null, null} );
    public static final IRule SharpTurnRight = new IfThenRule("IF Very Close To Shore THEN Sharp Right",LinguisticVariables.SharpRight, list);

    private static List<IFuzzySet> list2 = Arrays.asList(new IFuzzySet[]{null, null, null, LinguisticVariables.VerySmallDistanceToShore,  null, null} );
    public static final IRule SharpTurnLeft = new IfThenRule("IF Very Close To Shore THEN Sharp Left",LinguisticVariables.SharpLeft, list2);

    private static List<IFuzzySet> list3 = Arrays.asList(new IFuzzySet[]{null, null, null, null,  null, LinguisticVariables.WrongDirection} );
    public static final IRule wrongDirection = new IfThenRule("IF Wrong Direction THEN Set Right Dir",LinguisticVariables.GoodDirection, list3);

    private static List<IFuzzySet> list4 = Arrays.asList(new IFuzzySet[]{null, null, LinguisticVariables.SmallDistanceToShore, null, null, null} );
    public static final IRule TurnRight = new IfThenRule("IF Close To Shore THEN Turn Right",LinguisticVariables.TurnRight, list4);

    private static List<IFuzzySet> list5 = Arrays.asList(new IFuzzySet[]{null, null, null, LinguisticVariables.SmallDistanceToShore,  null, null} );
    public static final IRule TurnLeft = new IfThenRule("IF Close To Shore THEN Turn Left",LinguisticVariables.TurnLeft, list5);


    public static List<IRule> getRules() {
        List<IRule> list = new ArrayList<>();

        list.add(SharpTurnLeft);
        list.add(SharpTurnRight);
        list.add(wrongDirection);
        list.add(TurnLeft);
        list.add(TurnRight);

        return list;
    }


}
