package demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Util {

    public static List<double[]> parseFile(String str) throws Exception

    {
        File file = new File(str);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<double[]> inputs = new ArrayList<>();
        while((st = br.readLine()) != null) {
            String[] parts = st.split("\\s+");
            double[] values = new double[] {Double.valueOf(parts[0]), Double.valueOf(parts[1]), Double.valueOf(parts[2]) };
            inputs.add(values);
        }

        return inputs;
    }


}
