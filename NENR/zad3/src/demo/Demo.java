package demo;

import defuzzifier.COADefuzzifier;
import defuzzifier.Defuzzifier;
import system.AkcelFuzzySystemMin;
import system.FuzzySystem;
import system.KormiloFuzzySystemMin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws IOException {

        Defuzzifier def = new COADefuzzifier();

        FuzzySystem fsAkcel = new AkcelFuzzySystemMin(def);
        FuzzySystem fsKormilo = new KormiloFuzzySystemMin(def);

        int L = 0, D = 0, LK = 0, DK = 0, V = 0, S = 0;
        int A, K;
        String line;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            line = bf.readLine();
            if(line == null) break;
            if (line.trim().equals("KRAJ")) break;

            String[] parts = line.split("\\s+");

            L = Integer.valueOf(parts[0]);
            D = Integer.valueOf(parts[1]);
            LK = Integer.valueOf(parts[2]);
            DK = Integer.valueOf(parts[3]);
            V = Integer.valueOf(parts[4]);
            S = Integer.valueOf(parts[5]);

            A = fsAkcel.defuzzy(L, D, LK, DK, V, S);
            K = fsKormilo.defuzzy(L, D, LK, DK, V, S);

            System.out.println(String.format("%d %d", A, K));

            System.out.flush();

            //142 64 153 72 20 1
            //System.err.println(L + " "+ " "+D+ " "+LK+ " "+DK+ " "+V+ " "+S+ " "+A+ " "+K);
        }
        bf.close();

    }

}
