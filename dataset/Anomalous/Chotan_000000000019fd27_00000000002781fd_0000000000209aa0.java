import java.util.*;

class Solution {
    static HashSet<Integer>[] rows;
    static HashSet<Integer>[] cols;
    static int[][] matrix;
    static int traceTotal = 0;
    static boolean[][] visited;
    static final int[] DX = {0, 1, 0, -1};
    static final int[] DY = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            initialize(N);
            if (fillMatrix(0, 0, N, K)) {
                System.out.println("Case #" + t + ": POSSIBLE");
                printMatrix(N);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    static void initialize(int N) {
        rows = new HashSet[N];
        cols = new HashSet[N];
        matrix = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
    }

    static boolean fillMatrix(int x, int y, int N, int K) {
        for (int i = 1; i <= N; i++) {
            if (!rows[x].contains(i) && !cols[y].contains(i)) {
                rows[x].add(i);
                cols[y].add(i);
                matrix[x][y] = i;
                if (x == y) {
                    if (traceTotal + i <= K) {
                        traceTotal += i;
                    } else {
                        removeValueFromMatrix(x, y, i);
                        continue;
                    }
                }
                if (exploreNextCell(x, y, N, K)) {
                    return true;
                }
                removeValueFromMatrix(x, y, i);
            }
        }
        return isMatrixFilled(N) && traceTotal == K;
    }

    static boolean exploreNextCell(int x, int y, int N, int K) {
        for (int dir = 0; dir < 4; dir++) {
            int newX = x + DX[dir];
            int newY = y + DY[dir];
            if (isValidCell(newX, newY, N) && !visited[newX][newY] && fillMatrix(newX, newY, N, K)) {
                return true;
            }
        }
        return false;
    }

    static boolean isValidCell(int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static void removeValueFromMatrix(int x, int y, int value) {
        rows[x].remove(value);
        cols[y].remove(value);
        matrix[x][y] = 0;
        if (x == y) {
            traceTotal -= value;
        }
    }

    static boolean isMatrixFilled(int N) {
        for (int i = 0; i < N; i++) {
            if (rows[i].size() != N || cols[i].size() != N) {
                return false;
            }
        }
        return true;
    }

    static void printMatrix(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + (j < N - 1 ? " " : ""));
            }
            System.out.println();
        }
    }
}