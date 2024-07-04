import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();

        for (int i = 0; i < t; i++) {
            int N = fr.nextInt();
            Map<Integer, Set<Integer>> colWise = new HashMap<>();
            Set<Integer> duplicateRows = new HashSet<>();
            Set<Integer> duplicateCols = new HashSet<>();
            int trace = 0;

            for (int row = 0; row < N; row++) {
                Set<Integer> rowElements = new HashSet<>();
                for (int col = 0; col < N; col++) {
                    if (row == 0) {
                        colWise.put(col, new HashSet<>());
                    }

                    int value = fr.nextInt();
                    if (row == col) {
                        trace += value;
                    }
                    if (!rowElements.add(value)) {
                        duplicateRows.add(row);
                    }
                    if (!colWise.get(col).add(value)) {
                        duplicateCols.add(col);
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows.size() + " " + duplicateCols.size());
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