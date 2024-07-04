import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int caseNumber = 1;
        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] matrix = new int[r][c];
            int totalSum = 0;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            ArrayList<Pair> pairs;
            boolean continueLoop = true;

            while (continueLoop) {
                pairs = new ArrayList<>();
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (matrix[i][j] != -1) {
                            totalSum += matrix[i][j];
                            int neighborCount = 0;
                            int neighborSum = 0;

                            int[] directions = {1, -1};
                            for (int dir : directions) {
                                int ni = i + dir;
                                while (ni >= 0 && ni < r && matrix[ni][j] == -1) {
                                    ni += dir;
                                }
                                if (ni >= 0 && ni < r) {
                                    neighborSum += matrix[ni][j];
                                    neighborCount++;
                                }

                                int nj = j + dir;
                                while (nj >= 0 && nj < c && matrix[i][nj] == -1) {
                                    nj += dir;
                                }
                                if (nj >= 0 && nj < c) {
                                    neighborSum += matrix[i][nj];
                                    neighborCount++;
                                }
                            }

                            if (matrix[i][j] * neighborCount < neighborSum) {
                                pairs.add(new Pair(i, j));
                            }
                        }
                    }
                }

                if (pairs.isEmpty()) {
                    continueLoop = false;
                } else {
                    for (Pair p : pairs) {
                        matrix[p.x][p.y] = -1;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + totalSum);
            caseNumber++;
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}