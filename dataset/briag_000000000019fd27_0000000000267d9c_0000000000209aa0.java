import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read Number of Test Case
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {

            // Read size of data
            int n = in.nextInt();
            int k = in.nextInt();


            boolean isPossible = false;




            double valueIfSamePossible = (double)k / (double)n;

            int minimalPossibleValue = n * (n + 1) / 2;

            String result = "";

            System.err.println(valueIfSamePossible);
            System.err.println(minimalPossibleValue);
            if ((valueIfSamePossible == Math.floor(valueIfSamePossible)) && !Double.isInfinite(valueIfSamePossible)) {
                isPossible = true;

                System.out.println("Case #" + i + ": POSSIBLE");
                for(int j = 0; j < n; j++) {
                    for(int l = 0; l < n; l++) {
                        System.out.print((int) ((valueIfSamePossible - 1 - j + l + n) % (n) + 1) + " ");
                    }
                    System.out.println();
                }

            }

            if(!isPossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }




        }
    }


}
  