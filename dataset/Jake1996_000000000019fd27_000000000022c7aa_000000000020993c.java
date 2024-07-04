import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int tc = in.nextInt();
        int temp = tc;
        while (tc-- != 0) {
            int n = in.nextInt();
            int latin = 0;
            int row = 0;
            int column = 0;
            ArrayList<HashSet<Integer>> columnSet = new ArrayList<HashSet<Integer>>();
            for (int i = 0; i < n; i++) {
                columnSet.add(new HashSet<Integer>());
            }
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<Integer>();
                for (int j = 0; j < n; j++) {
                    int number = in.nextInt();
                    rowSet.add(number);
                    if (i == j) {
                        latin += number;
                    }
                    columnSet.get(j).add(number);
                }
                if (rowSet.size() != n) {
                    row++;
                }
            }
            for (int i = 0; i < n; i++) {
                if (columnSet.get(i).size() != n) {
                    column++;
                }
            }
            System.out.println("Case #" + (temp - tc) + ": " + latin + " " + row + " " + column);
        }
        in.close();
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

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
