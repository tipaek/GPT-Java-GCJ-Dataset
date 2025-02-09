import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // in.nextLine();
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int actNum = in.nextInt();
            int[][] actTimes = new int[actNum][2];
            for (int j = 0; j < actNum; j++) {
                actTimes[j][0] = in.nextInt();
                actTimes[j][1] = in.nextInt();
            }
            Arrays.sort(actTimes, (a, b) -> {
                return Integer.compare(a[0], b[0]);
            });

            int endC = 0, endJ = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < actNum; j++) {
                System.out.println(Arrays.toString(actTimes[j]));
                if (endC <= actTimes[j][0]) {
                    sb.append('C');
                    endC = actTimes[j][1];
                } else if (endJ <= actTimes[j][0]) {
                    sb.append('J');
                    endJ = actTimes[j][1];
                } else {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}