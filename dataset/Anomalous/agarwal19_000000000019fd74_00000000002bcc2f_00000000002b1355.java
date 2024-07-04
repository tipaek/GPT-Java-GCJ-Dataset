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

    static class Pair {
        int x, y;

        public Pair(int a, int b) {
            x = a;
            y = b;
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
                    totalSum += matrix[i][j];
                }
            }

            ArrayList<Pair> toRemove = new ArrayList<>();
            boolean flag = false;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int sumAdjacent = 0;
                    int count = 0;

                    if (i > 0) {
                        sumAdjacent += matrix[i - 1][j];
                        count++;
                    }
                    if (i < r - 1) {
                        sumAdjacent += matrix[i + 1][j];
                        count++;
                    }
                    if (j > 0) {
                        sumAdjacent += matrix[i][j - 1];
                        count++;
                    }
                    if (j < c - 1) {
                        sumAdjacent += matrix[i][j + 1];
                        count++;
                    }

                    if ((float) matrix[i][j] < (float) sumAdjacent / count) {
                        toRemove.add(new Pair(i, j));
                    }
                }
            }

            if (toRemove.isEmpty()) {
                flag = true;
            } else {
                for (Pair p : toRemove) {
                    matrix[p.x][p.y] = -1;
                }
            }

            while (!flag) {
                toRemove = new ArrayList<>();
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (matrix[i][j] != -1) {
                            totalSum += matrix[i][j];
                            int sumAdjacent = 0;
                            int count = 0;

                            for (int[] direction : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                                int ni = i + direction[0];
                                int nj = j + direction[1];

                                while (ni >= 0 && ni < r && nj >= 0 && nj < c && matrix[ni][nj] == -1) {
                                    ni += direction[0];
                                    nj += direction[1];
                                }

                                if (ni >= 0 && ni < r && nj >= 0 && nj < c) {
                                    sumAdjacent += matrix[ni][nj];
                                    count++;
                                }
                            }

                            if ((float) matrix[i][j] < (float) sumAdjacent / count) {
                                toRemove.add(new Pair(i, j));
                            }
                        }
                    }
                }

                if (toRemove.isEmpty()) {
                    flag = true;
                } else {
                    for (Pair p : toRemove) {
                        matrix[p.x][p.y] = -1;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + totalSum);
            caseNumber++;
        }
    }
}