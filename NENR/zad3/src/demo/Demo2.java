package demo;

import defuzzifier.COADefuzzifier;
import defuzzifier.Defuzzifier;
import rule.IRule;
import set.IFuzzySet;
import system.AkcelFuzzySystemMin;
import system.KormiloFuzzySystemMin;

import java.util.List;
import java.util.Scanner;

public class Demo2 {

    public static void main(String[] args) {
        Defuzzifier def = new COADefuzzifier();
        AkcelFuzzySystemMin akcel = new AkcelFuzzySystemMin(def);
        KormiloFuzzySystemMin korm = new KormiloFuzzySystemMin(def);

        int L = 0, D = 0, LK = 0, DK = 0, V = 0, S = 0;

        List<IRule> akcRules = akcel.getRules();
        List<IRule> kormRules = korm.getRules();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter L: ");
        L = sc.nextInt();
        System.out.println("Enter D: ");
        D = sc.nextInt();
        System.out.println("Enter LK: ");
        LK = sc.nextInt();
        System.out.println("Enter DK: ");
        DK = sc.nextInt();
        System.out.println("Enter V: ");
        V = sc.nextInt();
        System.out.println("Enter S: ");
        S = sc.nextInt();
        sc.close();

        IFuzzySet set1 = akcel.conclude(L, D, LK, DK, V, S);
        IFuzzySet set2 = korm.conclude(L, D, LK, DK, V, S);

        System.out.println(def.defuzzyfie(set1));
        System.out.println(def.defuzzyfie(set2));
    }
}
