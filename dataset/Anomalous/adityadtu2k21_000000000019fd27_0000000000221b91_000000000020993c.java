import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastReader scn = new FastReader();
        int testCases = scn.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scn.nextInt();
            boolean[] rows = new boolean[n];
            boolean[] cols = new boolean[n];
            Set<Integer>[] rowSets = new HashSet[n];
            Set<Integer>[] colSets = new HashSet[n];
            long trace = 0;

            for (int i = 0; i < n; i++) {
                rowSets[i] = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (colSets[j] == null) {
                        colSets[j] = new HashSet<>();
                    }
                    int value = scn.nextInt();
                    if (i == j) {
                        trace += value;
                    }
                    if (!rowSets[i].add(value)) {
                        rows[i] = true;
                    }
                    if (!colSets[j].add(value)) {
                        cols[j] = true;
                    }
                }
            }

            long rowCount = Arrays.stream(rows).filter(b -> b).count();
            long colCount = Arrays.stream(cols).filter(b -> b).count();

            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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