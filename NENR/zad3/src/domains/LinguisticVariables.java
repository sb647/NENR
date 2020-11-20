package domains;

import domains.Domains;
import set.CalculatedFuzzySet;
import set.IFuzzySet;
import set.StandardFuzzySet;

public class LinguisticVariables {

    public static final IFuzzySet VerySmallDistanceToShore = new CalculatedFuzzySet(Domains.DistanceDomain, StandardFuzzySet.lFunction(30, 50));

    public static final IFuzzySet SmallDistanceToShore = new CalculatedFuzzySet(Domains.DistanceDomain, StandardFuzzySet.lFunction(50, 70));


    public static final IFuzzySet TurnRight = new CalculatedFuzzySet(Domains.AngleDomain, StandardFuzzySet.lFunction(10, 45));

    public static final IFuzzySet TurnLeft = new CalculatedFuzzySet(Domains.AngleDomain, StandardFuzzySet.gammaFunction(155, 170));

    public static final IFuzzySet SharpRight = new CalculatedFuzzySet(Domains.AngleDomain, StandardFuzzySet.lFunction(0, 10));

    public static final IFuzzySet SharpLeft = new CalculatedFuzzySet(Domains.AngleDomain, StandardFuzzySet.gammaFunction(170, 180 ));


    public static final IFuzzySet WrongDirection = new CalculatedFuzzySet(Domains.AngleDomain, StandardFuzzySet.lFunction(0, 1));

    public static final IFuzzySet GoodDirection = new CalculatedFuzzySet(Domains.AngleDomain, StandardFuzzySet.lFunction(1, 0));


    public static final IFuzzySet TooFast = new CalculatedFuzzySet(Domains.VelocityDomain, StandardFuzzySet.gammaFunction(80, 100));

    public static final IFuzzySet TooSlow = new CalculatedFuzzySet(Domains.VelocityDomain, StandardFuzzySet.lFunction(20, 40));

    public static final IFuzzySet Fast = new CalculatedFuzzySet(Domains.VelocityDomain, StandardFuzzySet.gammaFunction(60, 80));

    public static final IFuzzySet Slow = new CalculatedFuzzySet(Domains.VelocityDomain, StandardFuzzySet.lFunction(40, 60));


    public static final IFuzzySet Accelerate = new CalculatedFuzzySet(Domains.AccelerationDomain, StandardFuzzySet.gammaFunction( 5, 15));

    public static final IFuzzySet Decelerate = new CalculatedFuzzySet(Domains.AccelerationDomain, StandardFuzzySet.lFunction(-15 , -5));

    public static final IFuzzySet StrongAccelerate = new CalculatedFuzzySet(Domains.AccelerationDomain, StandardFuzzySet.gammaFunction(15, 30));

    public static final IFuzzySet StrongDecelerate = new CalculatedFuzzySet(Domains.AccelerationDomain, StandardFuzzySet.lFunction(-30, -15));


}
