import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            boolean[] colsDup = new boolean[n+1];
            List<HashSet<Integer>> sets = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                sets.add(new HashSet<>());
            }
            for (int j = 1; j <= n; j++) {
                boolean accounted = false;
                Set<Integer> set = new HashSet<>();
                for (int l = 1; l <= n; l++) {
                    int val = in.nextInt();
                    if (j==l) {
                        k+=val;
                    }
                    if (!accounted) {
                        if (set.contains(val)){
                            r++;
                            accounted = true;
                        } else {
                            set.add(val);
                        }
                    }
                    if (!colsDup[l]) {
                        if (sets.get(val).contains(l)) {
                            colsDup[l] = true;
                            sets.get(val).remove(l);
                            c++;
                        } else {
                            sets.get(val).add(l);
                        }
                    }
                }
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}