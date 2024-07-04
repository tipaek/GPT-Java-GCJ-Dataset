import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();
            HashSet<Integer> r[] = new HashSet[n];
            for (int xi = 0; xi < n; xi++) {
                r[xi]=new HashSet<>();
            }
            HashSet<Integer> c[] = new HashSet[n];
            for (int xi = 0; xi < n; xi++) {
                c[xi]=new HashSet<>();
            }

            boolean[] cflag = new boolean[n];
            boolean[] rflag = new boolean[n];
            int rcount = 0;
            int ccount = 0;
            int trace = 0;
            for (int xi = 0; xi < n; xi++) {

                for (int yi = 0; yi < n; yi++) {
                    int temp = in.nextInt();
                    if (xi == yi) {
                        trace += temp;
                    }
                    if (r[xi].contains(temp)) {
                        if (!rflag[xi]) {
                            rcount++;
                            rflag[xi] = true;
                        }
                    }
                    if (c[yi].contains(temp)) {
                        if (!cflag[yi]) {
                            ccount++;
                            cflag[yi] = true;
                        }
                    }
                    r[xi].add(temp);
                    c[yi].add(temp);
                }
            }
            System.out.println("Case #" + tt + ": " + trace + " " + rcount + " " + ccount);
        }
  }
}