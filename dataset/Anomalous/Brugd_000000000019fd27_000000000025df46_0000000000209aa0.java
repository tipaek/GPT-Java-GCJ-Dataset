import java.io.PrintWriter;
import java.util.*;

public class Solution {

    private static final String POSSIBLE = "POSSIBLE";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int T = input.nextInt();
        Map<Integer, List<int[]>> dyn = new HashMap<>();

        for (int i = 0; i < T; i++) {
            int N = input.nextInt();
            int K = input.nextInt();
            String res = solve(dyn, N, K);
            output.printf("Case #%d: %s%n", (i + 1), res);
            output.flush();
        }
    }

    private static String createMatrixString(int[][] mat) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                builder.append(mat[i][j]);
                if (j < mat[0].length - 1) {
                    builder.append(' ');
                }
            }
            if (i < mat.length - 1) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    private static String solve(Map<Integer, List<int[]>> dyn, int N, int K) {
        StringBuilder builder = new StringBuilder();
        List<int[]> vec = performFullSearch(dyn, K, N);

        if (vec.isEmpty()) {
            return IMPOSSIBLE;
        }

        builder.append(POSSIBLE).append("\n");

        for (int[] l : vec) {
            int[][] mat = buildMatrix(l, N);
            if (mat != null) {
                builder.append(createMatrixString(mat));
                return builder.toString();
            }
        }

        return IMPOSSIBLE;
    }

    private static int[][] buildMatrix(int[] diag, int N) {
        int size = diag.length;
        boolean[][] rowStatus = new boolean[size + 1][size + 1];
        boolean[][] colStatus = new boolean[size + 1][size + 1];
        int[][] matrix = new int[size][size];

        for (int i = 0; i < diag.length; i++) {
            rowStatus[i][diag[i]] = true;
            colStatus[i][diag[i]] = true;
            matrix[i][i] = diag[i];
        }

        if (!fillMatrix(matrix, rowStatus, colStatus, 0, 0, N)) {
            return null;
        }

        return matrix;
    }

    private static boolean fillMatrix(int[][] matrix, boolean[][] rowStatus, boolean[][] colStatus, int row, int col, int N) {
        int currentRow = row;
        int currentCol = col;

        if (currentCol == matrix[0].length) {
            currentCol = 0;
            currentRow++;
        }

        if (currentRow == matrix.length) {
            return true;
        }

        if (currentCol == currentRow) {
            return fillMatrix(matrix, rowStatus, colStatus, currentRow, currentCol + 1, N);
        }

        for (int i = 1; i <= N; i++) {
            if (rowStatus[currentRow][i] || colStatus[currentCol][i]) {
                continue;
            }

            rowStatus[currentRow][i] = true;
            colStatus[currentCol][i] = true;
            matrix[currentRow][currentCol] = i;

            if (fillMatrix(matrix, rowStatus, colStatus, currentRow, currentCol + 1, N)) {
                return true;
            }

            rowStatus[currentRow][i] = false;
            colStatus[currentCol][i] = false;
            matrix[currentRow][currentCol] = 0;
        }

        return false;
    }

    private static List<int[]> performFullSearch(Map<Integer, List<int[]>> dyn, int target, int N) {
        List<int[]> result = new ArrayList<>();

        if (dyn.containsKey(target)) {
            for (int[] arr : dyn.get(target)) {
                if (arr.length == N) {
                    result.add(arr);
                }
            }
            return result;
        }

        int[] currentArray = new int[N];
        search(dyn, result, currentArray, target, 0, 0, N);

        return result;
    }

    private static void search(Map<Integer, List<int[]>> dyn, List<int[]> container, int[] currentArray, int target, int currentSum, int currentIndex, int N) {
        if (currentSum == target && currentIndex == currentArray.length) {
            container.add(Arrays.copyOf(currentArray, currentIndex));
            return;
        }

        if (currentIndex == currentArray.length || target - currentSum == 0) {
            return;
        }

        if (dyn.containsKey(target - currentSum)) {
            for (int[] arr : dyn.get(target - currentSum)) {
                System.arraycopy(arr, 0, currentArray, currentIndex, arr.length);
                container.add(Arrays.copyOf(currentArray, currentIndex));
            }
        }

        for (int i = 1; i <= N; i++) {
            int newSum = currentSum + i;
            if (newSum > target) {
                break;
            }

            currentArray[currentIndex] = i;
            search(dyn, container, currentArray, target, newSum, currentIndex + 1, N);
        }
    }
}