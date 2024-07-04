import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();
            StringBuilder result = new StringBuilder();

            int[][] jobs = new int[n][2];
            Set<Integer> cameron = new HashSet<>();
            Set<Integer> jamie = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int si = in.nextInt();
                int ei = in.nextInt();
                jobs[i][0] = si;
                jobs[i][1] = ei;

                boolean cameronCanTake = true;
                for (int j : cameron) {
                    if ((si >= jobs[j][0] && si < jobs[j][1]) ||
                            (ei > jobs[j][0] && ei <= jobs[j][1])) {
                        cameronCanTake = false;
                    }
                }
                if (cameronCanTake) {
                    cameron.add(i);
                    result.append("C");
                } else {
                    boolean jamieCanTake = true;
                    for (int j : jamie) {
                        if ((si >= jobs[j][0] && si < jobs[j][1]) ||
                                (ei > jobs[j][0] && ei <= jobs[j][1])) {
                            jamieCanTake = false;
                        }
                    }
                    if (jamieCanTake) {
                        jamie.add(i);
                        result.append("J");
                    } else {
                        break;
                    }
                }
            }
            System.out.println("Case #" + x + ": " + (result.toString().length() == n ?
                    result.toString() : "IMPOSSIBLE"));
        }
    }
}
