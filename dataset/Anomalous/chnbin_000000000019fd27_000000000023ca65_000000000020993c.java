import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[][] grid = new int[N][N];
            int trace = 0;
            int rowRepeatCount = 0;
            int colRepeatCount = 0;

            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasRepeat = false;
                for (int j = 0; j < N; j++) {
                    int num = sc.nextInt();
                    if (!rowSet.add(num)) {
                        rowHasRepeat = true;
                    }
                    grid[i][j] = num;
                    if (i == j) {
                        trace += num;
                    }
                }
                if (rowHasRepeat) {
                    rowRepeatCount++;
                }
            }

            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasRepeat = false;
                for (int i = 0; i < N; i++) {
                    int num = grid[i][j];
                    if (!colSet.add(num)) {
                        colHasRepeat = true;
                    }
                }
                if (colHasRepeat) {
                    colRepeatCount++;
                }
            }

            System.out.println(trace + " " + rowRepeatCount + " " + colRepeatCount);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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