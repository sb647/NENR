package operations;


import domain.DomainElement;
import set.IFuzzySet;
import set.MutableFuzzySet;

public class Operations {

    public Operations() {

    }

    public static IFuzzySet unaryOperation(IFuzzySet set, IUnaryFunction function) {
        MutableFuzzySet s = new MutableFuzzySet(set.getDomain());

        for(DomainElement element : set.getDomain()) {
            s = s.set(element, function.valueAt(set.getValueAt(element)));
        }
        return s;
    }

    public static IFuzzySet binaryOperation (IFuzzySet set1, IFuzzySet set2, IBinaryFunction function) {
        MutableFuzzySet s = new MutableFuzzySet(set1.getDomain());

        for(DomainElement element : set1.getDomain()) {
            s = s.set(element, function.valueAt(set1.getValueAt(element), set2.getValueAt(element)));
        }
        return s;
    }

    public static IUnaryFunction zadehNot() {

        return a -> 1.0 - a;

    }

    public static IBinaryFunction zadehAnd() {

        return (a, b) -> Math.min(a, b);

    }

    public static IBinaryFunction zadehOr() {
        return (a, b) -> Math.max(a, b);
    }

    public static IBinaryFunction hamacherTNorm (double n) {
        if ( n >= 0) return (a, b) -> a * b /(n + (1 - n ) * (a + b - a * b));
        else throw new IllegalArgumentException();

    }

    public static IBinaryFunction hamacherSNorm (double n) {
        if ( n >= 0)  return (a, b) -> (a + b - (2 - n)* a * b) / (1 - (1 - n) * a * b);
        else throw new IllegalArgumentException();
    }

}
