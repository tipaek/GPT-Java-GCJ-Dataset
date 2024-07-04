import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc = t;

        while (t > 0) {
            int n = scn.nextInt();
            int minC = 0, maxC = 0, minJ = Integer.MAX_VALUE, maxJ = Integer.MIN_VALUE;
            StringBuilder schedule = new StringBuilder();

            boolean isImpossible = false;

            for (int i = 1; i <= n; i++) {
                int s = scn.nextInt();
                int e = scn.nextInt();

                if (i == 1) {
                    schedule.append("C");
                    minC = s;
                    maxC = e;
                } else if ((minC < s && maxC > s) || (minC < e && maxC > e)) {
                    if ((minJ < s && maxJ > s) || (minJ < e && maxJ > e)) {
                        System.out.println("Case #" + (tc - t + 1) + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    } else {
                        schedule.append("J");
                        minJ = Math.min(minJ, s);
                        maxJ = Math.max(maxJ, e);
                    }
                } else {
                    schedule.append("C");
                    minC = Math.min(minC, s);
                    maxC = Math.max(maxC, e);
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + (tc - t + 1) + ": " + schedule.toString());
            }

            t--;
        }

        scn.close();
    }
}