package domains;

import domain.IDomain;
import domain.SimpleDomain;

public class Domains {

    public static final IDomain AngleDomain = new SimpleDomain(-90, 91);
    public static final IDomain DistanceDomain = new SimpleDomain(0, 1301);
    public static final IDomain VelocityDomain = new SimpleDomain(0, 300);
    public static final IDomain AccelerationDomain = new SimpleDomain(-40, 40);
   // public static final IDomain OrientationDomain = new SimpleDomain(0,2);

}
