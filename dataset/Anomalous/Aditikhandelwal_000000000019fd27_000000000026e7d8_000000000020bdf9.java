import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc = t;

        while (t > 0) {
            int n = scn.nextInt();
            int minC = 0, maxC = 0;
            int minJ = Integer.MAX_VALUE, maxJ = Integer.MIN_VALUE;
            StringBuilder schedule = new StringBuilder();

            boolean possible = true;

            for (int i = 1; i <= n; i++) {
                int s = scn.nextInt(), e = scn.nextInt();

                if (i == 1) {
                    schedule.append("C");
                    minC = s;
                    maxC = e;
                } else if ((s < maxC && e > minC) || (s < minC && e > maxC)) {
                    if ((s < maxJ && e > minJ) || (s < minJ && e > maxJ) || (minJ != Integer.MAX_VALUE && maxJ != Integer.MIN_VALUE && (s < minJ && e > maxJ))) {
                        System.out.println("Case #" + (tc - t + 1) + ": IMPOSSIBLE");
                        possible = false;
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

            if (possible) {
                System.out.println("Case #" + (tc - t + 1) + ": " + schedule.toString());
            }

            t--;
        }
    }
}