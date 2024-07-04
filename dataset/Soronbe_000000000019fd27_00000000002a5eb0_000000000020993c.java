import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            System.out.print(String.format("Case #%d: ", i));
            solve(in);
        }


    }

    private static void solve(Scanner sc) {

        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[][] rowUsed = new boolean[N][N];
        boolean[][] colused = new boolean[N][N];
        int[][] matrix = new int[N][N];
        if(N <= 5) {
            if (!backtrack(N, K, 0, 0, rowUsed, colused, matrix)) {
                System.out.println("IMPOSSIBLE");
            }
        } else {
            if(K == N+1 || K == N*N - 1) {
                System.out.println("IMPOSSIBLE");
            } else {
                int base = K / N;
                int added = K%N;
                if(added == 1) {
                    for (int i = 0; i < N - 2; ++i) {
                        assign(matrix, rowUsed, colused, i, i, base);
                    }

                    for (int i = 0; i < N; ++i) {
                        assign(matrix, rowUsed, colused, 0, i, i+1);
                    }
                    assign(matrix, rowUsed, colused, N-2, N-2, 2);
                    assign(matrix, rowUsed, colused, N-1, N-1, N-1);
                    assign(matrix, rowUsed, colused, N-1, N-2, 1);
                    assign(matrix, rowUsed, colused, N-2, N-1, 1);

                } else {
                    for (int i = 0; i < N; ++i) {
                        assign(matrix, rowUsed, colused, i, i, base);
                    }

                    for(int i = 0; i < added; ++i) {
                        assign(matrix, rowUsed, colused, i, i, base+1);

                    }
                }
            }
            if(fill(matrix, rowUsed, colused)) {
                System.out.println("POSSIBLE");
                for (int i = 0; i < N; ++i) {
                    String[] row = new String[N];
                    for (int j = 0; j < N; ++j) {
                        row[j] = Integer.toString(matrix[i][j]);
                    }
                    System.out.println(String.join(" ", row));
                }
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }

    }

    private static boolean backtrack(int N, int K, int x, int y, boolean[][] rowUsed, boolean[][] colused, int[][] matrix) {
        if (x >= N) {
            x = 0;
            ++y;
        }

        if (y >= N) {
            if (K != 0) {
                return false;
            }
            // System.out.println("POSSIBLE");
            for (int i = 0; i < N; ++i) {
                String[] row = new String[N];
                for (int j = 0; j < N; ++j) {
                    row[j] = Integer.toString(matrix[i][j]);
                }
                System.out.println(String.join(" ", row));

            }
            //System.out.println("new");
            return true;
        }

        for (int i = 0; i < N; ++i) {
            if (rowUsed[i][x]) {
                continue;
            }
            if (colused[i][y]) {
                continue;
            }
            colused[i][y] = true;
            rowUsed[i][x] = true;

            matrix[x][y] = i + 1;
            int tempK = K;
            if (x == y) {
                tempK -= i + 1;
            }

            if (backtrack(N, tempK, x + 1, y, rowUsed, colused, matrix)) {
                return true;
            }


            colused[i][y] = false;
            rowUsed[i][x] = false;
        }
        return false;

    }

    private static boolean fill(int[][] matrix, boolean[][] rowUsed, boolean[][] colUsed) {
        int best = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                if (matrix[i][j] != -1) {
                    continue;
                }

                int possibilities = 0;
                for (int k = 0; k < rowUsed[i].length; ++k) {
                    if (!rowUsed[i][k] && !colUsed[j][k]) {
                        ++possibilities;
                    }
                }

                if (possibilities <= 0) {
                    return false;
                }

                if (possibilities < best) {
                    best = possibilities;
                    x = i;
                    y = j;
                }
            }
        }

        if (best == Integer.MAX_VALUE) {
            return true;
        }

        for (int k = 0; k < rowUsed[x].length; ++k) {
            if (!rowUsed[x][k] && !colUsed[y][k]) {
                assign(matrix, rowUsed, colUsed, x, y, k+1);
                if (fill(matrix, rowUsed, colUsed)) {
                    return true;
                }

                reset(matrix, rowUsed, colUsed, x, y);
            }
        }

        return false;
    }

    private static void assign(int[][] matrix, boolean[][] rowUsed, boolean[][] colUsed, int x, int y, int value) {
        reset(matrix, rowUsed, colUsed, x, y);
        matrix[x][y] = value;
        rowUsed[x][value-1] = true;
        colUsed[y][value-1] = true;
    }

    private static void reset(int[][] matrix, boolean[][] rowUsed, boolean[][] colUsed, int x, int y) {
        if(matrix[x][y] == 0) {
            return;
        }
        rowUsed[x][matrix[x][y]-1] = false;
        colUsed[y][matrix[x][y]-1] = false;
        matrix[x][y] = 0;
    }
}
  