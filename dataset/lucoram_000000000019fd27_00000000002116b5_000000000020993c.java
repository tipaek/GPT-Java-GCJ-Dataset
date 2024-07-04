import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            Set<Integer>[] rOccs = new HashSet[n];
            Set<Integer>[] cOccs = new HashSet[n];

            int trace = 0;
            int[] rRep = new int[n];
            int[] cRep = new int[n];

            for (int r = 0; r < n; r++) {

                if (rOccs[r] == null) {
                    rOccs[r] = new HashSet<>();
                }

                for (int c = 0; c < n; c++) {

                    if (cOccs[c] == null) {
                        cOccs[c] = new HashSet<>();
                    }

                    int val = in.nextInt();

                    if (r == c) {
                        trace += val;
                    }

                    if (rOccs[r].contains(val)) {
                        rRep[r] = 1;
                    } else {
                        rOccs[r].add(val);
                    }

                    if (cOccs[c].contains(val)) {
                        cRep[c] = 1;
                    } else {
                        cOccs[c].add(val);
                    }

                }
            }

            System.out.println(
                    "Case #" + i + ": " + trace + " " + Arrays.stream(rRep).sum() + " " + Arrays.stream(cRep).sum());
        }
    }
}