import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
import java.math.BigDecimal;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int c = 1; c <= t; c++) {

            String[] ND = in.nextLine().split("\\s+");
            int N = Integer.parseInt(ND[0]);
            int D = Integer.parseInt(ND[1]);

            String[] strCuts = in.nextLine().split("\\s+");
            BigDecimal[] cuts = new BigDecimal[N];

            HashMap<BigDecimal, Integer> map = new HashMap<BigDecimal, Integer>();
            for (int i = 0; i < N; i++) {
                cuts[i] = new BigDecimal(strCuts[i]);
                int count = map.getOrDefault(cuts[i], 0);
                map.put(cuts[i], count + 1);
            }

            int max = -1;
            BigDecimal currentCut = BigDecimal.ZERO;
            for (Map.Entry<BigDecimal, Integer> entry : map.entrySet()) {
                int currentCount = entry.getValue();
                if (currentCount > max) {
                    max = currentCount;
                    currentCut = entry.getKey();
                }
            }

            boolean found = false;
            BigDecimal error = new BigDecimal(1e-5);
            if (max >= D) {
                System.out.println("Case #" + c + ": " + 0);
                found = true;
            } else {
                for (int i = 0; i < cuts.length; i++) {
                    BigDecimal newCut = cuts[i].divide(new BigDecimal(2));
                    for (int j = 0; j < cuts.length; j++) {
                        if (newCut.subtract(cuts[j]).abs().compareTo(error) < 0) {
                            System.out.println("Case #" + c + ": " + 1);
                            found = true;
                        }
                    }
                }
            }

            if (!found) {
                System.out.println("Case #" + c + ": " + 2);
            }
        }

    }

}
