import java.util.*;

public class Solution {
    static Scanner in = new Scanner(System.in);
    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static final String POSSIBLE = "POSSIBLE";
    static List<String> savedResults = new LinkedList<>();
    static final char FIRST_COLOR = '0';
    static Map<Integer, String> pairToMatrixSolution = new HashMap<>();
    static final int MIN_N = 2;
    static final int MAX_N = 50;

    public static void main(String[] args) {
        solve();
    }

    private static int calculateKey(int N, int K) {
        return 10000 * N + K;
    }

    private static void solve() {
        int[][] matrix = new int[MAX_N][MAX_N];
        int T = in.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int K = in.nextInt();

            for (int r = 0; r < N; r++) {
                Arrays.fill(matrix[r], 0);
            }

            boolean didSucceed = generateMatrix(matrix, N, K);
            String result = didSucceed ? POSSIBLE : IMPOSSIBLE;

            System.out.println("Case #" + i + ": " + result);

            if (didSucceed) {
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        System.out.print(matrix[r][c]);
                        if (c < N - 1) System.out.print(" ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static boolean generateMatrix(int[][] matrix, int N, int K) {
        int baseValue = K / N;
        for (int i = 0; i < N - 1; i++) {
            matrix[i][i] = baseValue;
        }

        int lastValue = K - (N - 1) * baseValue;
        matrix[N - 1][N - 1] = lastValue;

        if (baseValue - lastValue != 0) {
            if (!adjustDiagonal(matrix, N, baseValue, lastValue)) {
                return false;
            }

            Set<Integer> remainingValues = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                remainingValues.add(i);
            }
            remainingValues.remove(baseValue);
            remainingValues.remove(matrix[N - 1][N - 1]);
            remainingValues.remove(matrix[N - 2][N - 2]);

            fillMatrix(matrix, N, matrix[N - 1][N - 1], matrix[N - 2][N - 2], remainingValues);
        } else {
            fillMatrix(matrix, N, baseValue, lastValue, new HashSet<>());
        }

        return true;
    }

    private static boolean adjustDiagonal(int[][] matrix, int N, int baseValue, int lastValue) {
        if (baseValue + 1 <= N && lastValue - 1 >= 1) {
            matrix[N - 2][N - 2] = baseValue + 1;
            matrix[N - 1][N - 1] = lastValue - 1;
        } else if (baseValue - 1 >= 1 && lastValue + 1 <= N) {
            matrix[N - 2][N - 2] = baseValue - 1;
            matrix[N - 1][N - 1] = lastValue + 1;
        } else {
            return false;
        }
        return true;
    }

    private static void fillMatrix(int[][] matrix, int N, int valueZ, int valueY, Set<Integer> remainingValues) {
        fillWithValue(matrix, N, valueZ, 1);
        fillWithValue(matrix, N, valueY, N - 1);

        int startIndex = 2;
        for (int value : remainingValues) {
            fillWithValue(matrix, N, value, startIndex);
            startIndex++;
        }

        swapRows(matrix, N - 1, N - 2);
    }

    private static void fillWithValue(int[][] matrix, int N, int value, int startIndex) {
        int index = startIndex;
        for (int r = 0; r < N; r++) {
            index = startIndex;
            for (int c = 0; c < N; c++) {
                matrix[r][index % N] = value;
                index++;
            }
        }
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }
}