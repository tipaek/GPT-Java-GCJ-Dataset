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
            int rows = sc.nextInt();
            int columns = sc.nextInt();
            int[][] matrix = new int[rows][columns];
            int totalSum = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            ArrayList<Pair> cellsToRemove;
            boolean continueProcessing = true;

            while (continueProcessing) {
                cellsToRemove = new ArrayList<>();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (matrix[i][j] != -1) {
                            totalSum += matrix[i][j];
                            int neighborSum = 0;
                            int neighborCount = 0;

                            // Check downwards
                            for (int k = i + 1; k < rows; k++) {
                                if (matrix[k][j] != -1) {
                                    neighborSum += matrix[k][j];
                                    neighborCount++;
                                    break;
                                }
                            }

                            // Check upwards
                            for (int k = i - 1; k >= 0; k--) {
                                if (matrix[k][j] != -1) {
                                    neighborSum += matrix[k][j];
                                    neighborCount++;
                                    break;
                                }
                            }

                            // Check rightwards
                            for (int k = j + 1; k < columns; k++) {
                                if (matrix[i][k] != -1) {
                                    neighborSum += matrix[i][k];
                                    neighborCount++;
                                    break;
                                }
                            }

                            // Check leftwards
                            for (int k = j - 1; k >= 0; k--) {
                                if (matrix[i][k] != -1) {
                                    neighborSum += matrix[i][k];
                                    neighborCount++;
                                    break;
                                }
                            }

                            if (matrix[i][j] * neighborCount < neighborSum) {
                                cellsToRemove.add(new Pair(i, j));
                            }
                        }
                    }
                }

                if (cellsToRemove.isEmpty()) {
                    continueProcessing = false;
                } else {
                    for (Pair p : cellsToRemove) {
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