import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println("Case #" + i + ": " + solve(n, k));
        }
    }

    public static String solve(int n, int k) {
        int[][] matrix = new int[n][n];
        Integer[] diagonals = new Integer[3];
        int type = 1;

        if (k % n == 0) {
            diagonals[0] = k / n;
        } else {
            type = 2;
            if (n == 2 || n == 3 || k == n + 1 || k == n * n - 1) return "IMPOSSIBLE";
            int a = k / n;
            int b = k % n;
            if (k < 2 * n - 2) {
                diagonals[0] = 1;
                diagonals[1] = (k - n + 2) / 2;
                if (k - n + 2 - diagonals[1] != diagonals[1]) {
                    type = 3;
                    diagonals[2] = k - n + 2 - diagonals[1];
                }
            } else {
                diagonals[0] = a + 1;
                diagonals[1] = (k - (a + 1) * (n - 2)) / 2;
                if (k - (a + 1) * (n - 2) - diagonals[1] != diagonals[1]) {
                    type = 3;
                    diagonals[2] = k - (a + 1) * (n - 2) - diagonals[1];
                }
            }
        }

        List<Integer> diagonalList = new ArrayList<>();
        Set<Integer> diagonalSet = new HashSet<>();
        for (Integer diagonal : diagonals) {
            if (diagonal != null) {
                diagonalList.add(diagonal);
                diagonalSet.add(diagonal == n ? 0 : diagonal);
            }
        }

        int current = diagonalList.get(diagonalList.size() - 1);
        while (diagonalList.size() < n) {
            while (diagonalSet.contains(current % n)) current++;
            diagonalSet.add(current % n == 0 ? 0 : current % n);
            diagonalList.add(current % n == 0 ? n : current % n);
        }

        Collections.swap(diagonalList, 0, 1);

        switch (type) {
            case 1:
                fillMatrixType1(matrix, n, diagonalList);
                break;
            case 2:
                fillMatrixType2(matrix, n, diagonalList);
                break;
            case 3:
                fillMatrixType1(matrix, n, diagonalList);
                swapLastTwoRows(matrix, n);
                break;
        }

        return formatMatrix(matrix);
    }

    private static void fillMatrixType1(int[][] matrix, int n, List<Integer> diagonalList) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = diagonalList.get((n + 1 + j - i) % n);
            }
        }
    }

    private static void fillMatrixType2(int[][] matrix, int n, List<Integer> diagonalList) {
        for (int i = 0; i < n - 2; i++) {
            matrix[i][i] = diagonalList.get(1);
            matrix[i][(i + 1) % (n - 2)] = diagonalList.get(0);
            int currentColumn = i + 2;
            for (int count = 0; count < n - 2; count++) {
                while (matrix[i][currentColumn % n] != 0) currentColumn++;
                matrix[i][currentColumn % n] = diagonalList.get(count + 2);
            }
        }

        for (int i = n - 2; i < n; i++) matrix[i][i] = diagonalList.get(0);
        matrix[n - 1][n - 2] = diagonalList.get(1);
        matrix[n - 2][n - 1] = diagonalList.get(1);

        Set<Integer> row2 = new HashSet<>(diagonalList.subList(2, n));
        Set<Integer> row1 = new HashSet<>(diagonalList.subList(2, n));

        for (int j = 0; j < n - 2; j++) {
            Set<Integer> columnSet = new HashSet<>(diagonalList.subList(2, n));
            for (int m = 0; m < n - 2; m++) columnSet.remove(matrix[m][j]);
            List<Integer> columnList = new ArrayList<>(columnSet);

            if (j == 0) {
                matrix[n - 2][0] = columnList.get(0);
                row2.remove(columnList.get(0));
                matrix[n - 1][0] = columnList.get(1);
                row1.remove(columnList.get(1));
            } else {
                int[] counts = new int[2];
                for (int i = 0; i < 2; i++) {
                    if (row1.contains(columnList.get(i))) counts[i]++;
                    if (row2.contains(columnList.get(i))) counts[i]++;
                }
                if (counts[0] == 1) {
                    if (row1.contains(columnList.get(0))) {
                        matrix[n - 1][j] = columnList.get(0);
                        matrix[n - 2][j] = columnList.get(1);
                        row1.remove(columnList.get(0));
                        row2.remove(columnList.get(1));
                    } else {
                        matrix[n - 2][j] = columnList.get(0);
                        matrix[n - 1][j] = columnList.get(1);
                        row2.remove(columnList.get(0));
                        row1.remove(columnList.get(1));
                    }
                } else {
                    if (row1.contains(columnList.get(1))) {
                        matrix[n - 1][j] = columnList.get(1);
                        matrix[n - 2][j] = columnList.get(0);
                        row2.remove(columnList.get(0));
                        row1.remove(columnList.get(1));
                    } else {
                        matrix[n - 2][j] = columnList.get(1);
                        matrix[n - 1][j] = columnList.get(0);
                        row1.remove(columnList.get(0));
                        row2.remove(columnList.get(1));
                    }
                }
            }
        }
    }

    private static void swapLastTwoRows(int[][] matrix, int n) {
        int[] temp = matrix[n - 2];
        matrix[n - 2] = matrix[n - 1];
        matrix[n - 1] = temp;
    }

    private static String formatMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder("POSSIBLE\n");
        for (int[] row : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                sb.append(row[j]);
                if (j != matrix.length - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}