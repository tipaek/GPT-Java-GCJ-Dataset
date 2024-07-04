import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
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
            } else if (b == n - 1) {
                if ((2 * a + b) / 2 < n) {
                    diagonals[0] = a;
                    diagonals[1] = (2 * a + b) / 2;
                    if (2 * a + b - diagonals[1] != diagonals[1]) {
                        type = 3;
                        diagonals[2] = 2 * a + b - diagonals[1];
                    }
                } else {
                    diagonals[0] = a + 2;
                    diagonals[1] = (k - (a + 2) * (n - 2)) / 2;
                    if (k - (a + 2) * (n - 2) - diagonals[1] != diagonals[1]) {
                        type = 3;
                        diagonals[2] = k - (a + 2) * (n - 2) - diagonals[1];
                    }
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

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (Integer diagonal : diagonals) {
            if (diagonal != null) {
                list.add(diagonal);
                set.add(diagonal == n ? 0 : diagonal);
            }
        }

        int current = list.get(list.size() - 1);
        while (list.size() < n) {
            while (set.contains(current % n)) current++;
            if (current % n == 0) {
                set.add(0);
                list.add(n);
            } else {
                set.add(current % n);
                list.add(current % n);
            }
        }

        Collections.swap(list, 0, 1);

        switch (type) {
            case 1:
                fillMatrixType1(matrix, n, list);
                break;
            case 2:
                fillMatrixType2(matrix, n, list);
                break;
            case 3:
                fillMatrixType1(matrix, n, list);
                swapRows(matrix, n - 2, n - 1);
                break;
        }

        return formatMatrix(matrix);
    }

    private static void fillMatrixType1(int[][] matrix, int n, List<Integer> list) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = list.get((n + 1 + j - i) % n);
            }
        }
    }

    private static void fillMatrixType2(int[][] matrix, int n, List<Integer> list) {
        for (int i = 0; i < n - 2; i++) {
            matrix[i][i] = list.get(1);
            matrix[i][(i + 1) % (n - 2)] = list.get(0);
            int currentColumn = i + 2;
            for (int count = 0; count < n - 2; count++) {
                while (matrix[i][currentColumn % n] != 0) currentColumn++;
                matrix[i][currentColumn % n] = list.get(count + 2);
            }
        }

        for (int i = n - 2; i < n; i++) {
            matrix[i][i] = list.get(0);
        }
        matrix[n - 1][n - 2] = list.get(1);
        matrix[n - 2][n - 1] = list.get(1);

        fillRemainingColumns(matrix, n, list);
    }

    private static void fillRemainingColumns(int[][] matrix, int n, List<Integer> list) {
        Set<Integer> row2 = new HashSet<>(list.subList(2, n));
        Set<Integer> row1 = new HashSet<>(list.subList(2, n));

        for (int j = 0; j < n - 2; j++) {
            Set<Integer> col = new HashSet<>(list.subList(2, n));
            for (int m = 0; m < n - 2; m++) col.remove(matrix[m][j]);
            List<Integer> colList = new ArrayList<>(col);

            if (j == 0) {
                matrix[n - 2][0] = colList.get(0);
                row2.remove(colList.get(0));
                matrix[n - 1][0] = colList.get(1);
                row1.remove(colList.get(1));
            } else {
                int[] count = new int[2];
                for (int i = 0; i < 2; i++) {
                    if (row1.contains(colList.get(i))) count[i]++;
                    if (row2.contains(colList.get(i))) count[i]++;
                }
                if (count[0] == 1) {
                    if (row1.contains(colList.get(0))) {
                        matrix[n - 1][j] = colList.get(0);
                        matrix[n - 2][j] = colList.get(1);
                        row1.remove(colList.get(0));
                        row2.remove(colList.get(1));
                    } else {
                        matrix[n - 2][j] = colList.get(0);
                        matrix[n - 1][j] = colList.get(1);
                        row2.remove(colList.get(0));
                        row1.remove(colList.get(1));
                    }
                } else {
                    if (row1.contains(colList.get(1))) {
                        matrix[n - 1][j] = colList.get(1);
                        matrix[n - 2][j] = colList.get(0);
                        row2.remove(colList.get(0));
                        row1.remove(colList.get(1));
                    } else {
                        matrix[n - 2][j] = colList.get(1);
                        matrix[n - 1][j] = colList.get(0);
                        row1.remove(colList.get(0));
                        row2.remove(colList.get(1));
                    }
                }
            }
        }
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
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