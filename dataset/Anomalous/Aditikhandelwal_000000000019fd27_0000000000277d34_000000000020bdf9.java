import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc = t;

        while (t > 0) {
            int n = scn.nextInt();
            int minC = 0, maxC = 0, minJ = Integer.MAX_VALUE, maxJ = Integer.MIN_VALUE;
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;

            for (int i = 1; i <= n; i++) {
                int s = scn.nextInt();
                int e = scn.nextInt();

                if (i == 1) {
                    schedule.append("C");
                    minC = s;
                    maxC = e;
                } else if ((minC < s && maxC > s) || (minC < e && maxC > e) || (s <= minC && e >= maxC)) {
                    if ((minJ < s && maxJ > s) || (minJ < e && maxJ > e) || (minJ != Integer.MAX_VALUE && maxJ != Integer.MIN_VALUE && s <= minJ && e >= maxJ)) {
                        System.out.println("Case #" + (tc - t + 1) + ": IMPOSSIBLE");
                        impossible = true;
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

            if (!impossible) {
                if (minC <= minJ) {
                    System.out.println("Case #" + (tc - t + 1) + ": " + schedule);
                } else {
                    for (int i = 0; i < schedule.length(); i++) {
                        schedule.setCharAt(i, schedule.charAt(i) == 'C' ? 'J' : 'C');
                    }
                    System.out.println("Case #" + (tc - t + 1) + ": " + schedule);
                }
            }
            t--;
        }
        scn.close();
    }
}