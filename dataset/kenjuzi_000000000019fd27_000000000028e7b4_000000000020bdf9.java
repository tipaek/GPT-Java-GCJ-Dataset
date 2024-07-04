
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<int[]> intervals = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                int[] interval = new int[3];
                interval[0] = in.nextInt();
                interval[1] = in.nextInt();
                interval[2] = j;
                intervals.add(interval);
            }

            System.out.println("Case #" + i + ": " + solve(intervals));
        }
    }

    public static String solve(List<int[]> interval) {
        interval = interval.stream().sorted((o1, o2) -> o1[0] - o2[0]).collect(Collectors.toList());
        int c = 0, j = 0;

        char[] res = new char[interval.size()];
        for(int[] i: interval) {
            if(i[0] >= c) {
                res[i[2]]= 'C';
                c = i[1];
            }
            else if(i[0] >= j) {
                res[i[2]]= 'J';
                j = i[1];
            }
            else {
                return "IMPOSSIBLE";
            }
        }

        return String.valueOf(res);
    }
}
