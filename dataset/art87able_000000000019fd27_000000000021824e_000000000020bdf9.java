import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            Interval[] arr = new Interval[n];
            for (int j = 0; j < n; j++) {
                arr[j] = new Interval(in.nextInt(), in.nextInt(), j);
            }
            Arrays.sort(arr);
            boolean isJ = false;
            boolean[] res = new boolean[n];
            int prev = 0;
            res[arr[0].pos] = isJ;
            boolean next = false;
            for (int j = 1; j < n; j++) {
                if (arr[j].start >= arr[j-1].end) {
                    res[arr[j].pos] = isJ;
                } else {
                    if (arr[j].start<prev) {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        next = true;
                        break;
                    } else {
                        isJ=!isJ;
                        res[arr[j].pos] = isJ;
                        prev = arr[j-1].end;
                    }
                }
            }
            if (next) {
                continue;
            }
            StringBuilder sb = new StringBuilder(n);
            for (boolean b : res) {
                if (b) {
                    sb.append("J");
                } else {
                    sb.append("C");
                }
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }

    static class Interval implements Comparable<Interval>{
        int pos;
        int start;
        int end;

        Interval(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }

        @Override
        public int compareTo(Interval o) {
            return start - o.start;
        }
    }
}
