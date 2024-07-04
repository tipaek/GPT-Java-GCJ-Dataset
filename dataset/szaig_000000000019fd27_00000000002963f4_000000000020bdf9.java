import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int qdx = 1; qdx <= t; ++qdx) {
            int n = in.nextInt();
            List<Integer> starts = new ArrayList<Integer>();
            List<Integer> ends = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                starts.add(in.nextInt());
                ends.add(in.nextInt());
            }

            String ans = null;
            char[] res = new char[n];

            int f = 0;
            int s = 0;
            int index = 0;
            for (int i = 0; i < n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    if ((starts.get(j) <= min) && (res[j] == 0)) {
                        min = starts.get(j);
                        index = j;
                    }
                }
                if (f <= starts.get(index)) {
                    res[index] = 'C';
                    f = ends.get(index);
                } else if (s <= starts.get(index)) {
                    res[index] = 'J';
                    s = ends.get(index);
                } else {
                    ans = "IMPOSSIBLE";
                    break;
                }
            }
            if (ans == null) {
                ans = new String(res);
            }
            System.out.println("Case #" + qdx + ": " + ans);
        }
    }
}