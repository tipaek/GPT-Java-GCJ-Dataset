import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int T = fr.nextInt();

        for (int k = 0; k < T; k++) {
            int N = fr.nextInt();
            Interval[] intervals = new Interval[N];

            for (int i = 0; i < N; i++) {
                int s = fr.nextInt();
                int e = fr.nextInt();
                intervals[i] = new Interval(s, e, i);
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a.e));

            Interval cInt = null;
            Interval jInt = null;
            char[] result = new char[N];
            Arrays.fill(result, ' ');

            cInt = intervals[0];
            result[cInt.index] = 'C';
            boolean possible = true;

            for (int i = 1; i < N; i++) {
                Interval curInt = intervals[i];
                if (curInt.s < cInt.e) {
                    if (jInt != null && curInt.s < jInt.e) {
                        possible = false;
                        break;
                    }
                    jInt = curInt;
                    result[jInt.index] = 'J';
                } else {
                    cInt = curInt;
                    result[cInt.index] = 'C';
                }
            }

            String output = possible ? new String(result) : "IMPOSSIBLE";
            System.out.println("Case #" + (k + 1) + ": " + output);
        }
    }

    static class Interval {
        int s, e, index;

        Interval(int s, int e, int index) {
            this.s = s;
            this.e = e;
            this.index = index;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}