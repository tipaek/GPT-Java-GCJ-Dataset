 import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < t; ++i) {
            int n = in.nextInt();
            int[][] activities = new int[n][2];
            String outStr = "";

            for (int j = 0; j < n; j++) {
                activities[j][0] = in.nextInt();
                activities[j][1] = in.nextInt();
            }

            for (int x = 1; x < n; ++x) {
                int key = activities[x][0];
                int key2 = activities[x][1];
                int j = x - 1;

                while (j >= 0 && activities[j][0] > key) {
                    activities[j + 1][0] = activities[j][0];
                    activities[j + 1][1] = activities[j][1];
                    j = j - 1;
                }
                activities[j + 1][0] = key;
                activities[j + 1][1] = key2;
            }

            boolean jAvailable, cAvailable;
            int jNextAvailable, cNextAvailable;
            jNextAvailable = cNextAvailable = 0;
            jAvailable = cAvailable = false;
            for (int j = 0; j < n; j++) {
                if (activities[j][0] >= cNextAvailable) {
                    cAvailable = true;
                }
                if (activities[j][0] >= jNextAvailable) {
                    jAvailable = true;
                }

                if (jAvailable) {
                    jNextAvailable = activities[j][1];
                    jAvailable = false;
                    outStr += "J";
                } else if (cAvailable) {
                    cNextAvailable = activities[j][1];
                    cAvailable = false;
                    outStr += "C";
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + (outStr.length() < n ? "IMPOSSIBLE" : outStr));
        }
    }
}
