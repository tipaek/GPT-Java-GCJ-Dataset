import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static HashSet<Integer>[] row;
    static HashSet<Integer>[] col;
    static int[][] matrix;
    static int traceTotal = 0;
    static boolean[][] visited;
    static int totalVisited = 0;
    static final int[] X = {0, 1, 0, -1};
    static final int[] Y = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            initialize(N);
            if (buildMatrix(0, 0, N, K)) {
                System.out.println("Case #" + t + ": POSSIBLE");
                printMatrix(N);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
            reset();
        }
        sc.close();
    }

    static void initialize(int N) {
        row = new HashSet[N];
        col = new HashSet[N];
        matrix = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
        }
    }

    static void reset() {
        traceTotal = 0;
        totalVisited = 0;
    }

    static void printMatrix(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    static boolean buildMatrix(int x, int y, int N, int K) {
        visited[x][y] = true;
        totalVisited++;
        for (int i = 1; i <= N; i++) {
            if (!row[x].contains(i) && !col[y].contains(i)) {
                if (x == y) {
                    if (traceTotal + i > K) {
                        visited[x][y] = false;
                        totalVisited--;
                        return false;
                    } else {
                        traceTotal += i;
                    }
                }
                row[x].add(i);
                col[y].add(i);
                matrix[x][y] = i;

                if (isMatrixComplete(N, K)) {
                    return true;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int newX = x + X[dir];
                    int newY = y + Y[dir];
                    if (isValidMove(newX, newY, N) && buildMatrix(newX, newY, N, K)) {
                        return true;
                    }
                }

                backtrack(x, y, i);
            }
        }
        visited[x][y] = false;
        totalVisited--;
        return false;
    }

    static boolean isMatrixComplete(int N, int K) {
        boolean allClear = true;
        for (int j = 0; j < N; j++) {
            if (row[j].size() < N || col[j].size() < N) {
                allClear = false;
                break;
            }
        }
        return allClear && totalVisited == N * N && traceTotal == K;
    }

    static boolean isValidMove(int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N && !visited[x][y];
    }

    static void backtrack(int x, int y, int value) {
        row[x].remove(value);
        col[y].remove(value);
        matrix[x][y] = 0;
        if (x == y) {
            traceTotal -= value;
        }
    }
}