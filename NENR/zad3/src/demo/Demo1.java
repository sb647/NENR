package demo;

import set.IFuzzySet;
import system.AkcelFuzzySystemMin;
import defuzzifier.COADefuzzifier;
import defuzzifier.Defuzzifier;
import rule.IRule;

import java.util.List;
import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {
        Defuzzifier def = new COADefuzzifier();
        AkcelFuzzySystemMin akcel = new AkcelFuzzySystemMin(def);

        int L = 0, D = 0, LK = 0, DK = 0, V = 0, S = 0;

        List<IRule> rules = akcel.getRules();

        for(int i = 0; i < rules.size(); i++) {
            System.out.println(i+ ". " + rules.get(i).getName());
        }
        Scanner sc = new Scanner(System.in);
        Integer n;
        while(true) {
            System.out.println("Enter ordinal number of wanted rule: ");

            n = sc.nextInt();
            if(n < 0 || n >= rules.size())
                System.out.println("Inval1" +
                        "id number!");
            else break;
        }

        //142, 64, 153 ,72 ,50, 1

        IRule rule = rules.get(n);
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

        IFuzzySet A = rule.getConclusion(L, D, LK, DK, V,S);
        int defA = def.defuzzyfie(A);
        System.out.println(defA);

    }
}
