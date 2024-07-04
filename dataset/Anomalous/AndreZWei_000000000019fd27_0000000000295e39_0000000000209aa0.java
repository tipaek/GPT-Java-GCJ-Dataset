import java.util.*;

class Solution {
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
        int type = determineType(n, k, diagonals);
        if (type == -1) return "IMPOSSIBLE";

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        populateListAndSet(n, diagonals, list, set);

        int cur = list.get(list.size() - 1);
        while (list.size() < n) {
            while (set.contains(cur % n)) cur++;
            if (cur % n == 0) {
                set.add(0);
                list.add(n);
            } else {
                set.add(cur % n);
                list.add(cur % n);
            }
        }

        Collections.swap(list, 0, 1);

        switch (type) {
            case 1:
                fillMatrixType1(n, matrix, list);
                break;
            case 2:
                fillMatrixType2(n, matrix, list);
                break;
            case 3:
                fillMatrixType3(n, matrix, list);
                break;
        }

        return printMatrix(matrix);
    }

    private static int determineType(int n, int k, Integer[] diagonals) {
        if (k % n == 0) {
            diagonals[0] = k / n;
            return 1;
        }
        if (n == 2 || n == 3 || k == n + 1 || k == n * n - 1) return -1;
        return calculateDiagonals(n, k, diagonals);
    }

    private static int calculateDiagonals(int n, int k, Integer[] diagonals) {
        int a = k / n;
        int b = k % n;
        if (k < 2 * n - 2) {
            diagonals[0] = 1;
            diagonals[1] = (k - n + 2) / 2;
            if (k - n + 2 - diagonals[1] != diagonals[1]) {
                diagonals[2] = k - n + 2 - diagonals[1];
                return 3;
            }
        } else if (b == n - 1) {
            return handleSpecialCase(n, k, a, b, diagonals);
        } else {
            return handleGeneralCase(n, k, a, diagonals);
        }
        return 2;
    }

    private static int handleSpecialCase(int n, int k, int a, int b, Integer[] diagonals) {
        if ((2 * a + b) / 2 < n && (2 * a + b) / 2 > 0) {
            diagonals[0] = a;
            diagonals[1] = (2 * a + b) / 2;
            if (2 * a + b - diagonals[1] != diagonals[1]) {
                diagonals[2] = 2 * a + b - diagonals[1];
                return 3;
            }
        } else {
            diagonals[0] = a + 2;
            diagonals[1] = (k - (a + 2) * (n - 2)) / 2;
            if (k - (a + 2) * (n - 2) - diagonals[1] != diagonals[1]) {
                diagonals[2] = k - (a + 2) * (n - 2) - diagonals[1];
                return 3;
            }
        }
        return 2;
    }

    private static int handleGeneralCase(int n, int k, int a, Integer[] diagonals) {
        if ((k - (a + 1) * (n - 2)) / 2 > 0) {
            diagonals[0] = a + 1;
            diagonals[1] = (k - (a + 1) * (n - 2)) / 2;
            if (k - (a + 1) * (n - 2) - diagonals[1] != diagonals[1]) {
                diagonals[2] = k - (a + 1) * (n - 2) - diagonals[1];
                return 3;
            }
        } else {
            diagonals[0] = a - 1;
            diagonals[1] = (k - (a - 1) * (n - 2)) / 2;
            if (k - (a - 1) * (n - 2) - diagonals[1] != diagonals[1]) {
                diagonals[2] = k - (a - 1) * (n - 2) - diagonals[1];
                return 3;
            }
        }
        return 2;
    }

    private static void populateListAndSet(int n, Integer[] diagonals, List<Integer> list, Set<Integer> set) {
        for (Integer diagonal : diagonals) {
            if (diagonal != null) {
                list.add(diagonal);
                set.add(diagonal == n ? 0 : diagonal);
            }
        }
    }

    private static void fillMatrixType1(int n, int[][] matrix, List<Integer> list) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = list.get((n + 1 + j - i) % n);
            }
        }
    }

    private static void fillMatrixType2(int n, int[][] matrix, List<Integer> list) {
        for (int i = 0; i < n - 2; i++) {
            matrix[i][i] = list.get(1);
            matrix[i][(i + 1) % (n - 2)] = list.get(0);
            int curCol = i + 2;
            for (int cnt = 0; cnt < n - 2; cnt++) {
                while (matrix[i][curCol % n] != 0) curCol++;
                matrix[i][curCol % n] = list.get(cnt + 2);
            }
        }
        for (int i = n - 2; i < n; i++) matrix[i][i] = list.get(0);
        matrix[n - 1][n - 2] = list.get(1);
        matrix[n - 2][n - 1] = list.get(1);

        fillRemainingCells(n, matrix, list);
    }

    private static void fillRemainingCells(int n, int[][] matrix, List<Integer> list) {
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
                fillColumn(n, matrix, j, row1, row2, colList);
            }
        }
    }

    private static void fillColumn(int n, int[][] matrix, int j, Set<Integer> row1, Set<Integer> row2, List<Integer> colList) {
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

    private static void fillMatrixType3(int n, int[][] matrix, List<Integer> list) {
        fillMatrixType1(n, matrix, list);
        int[] temp = matrix[n - 2];
        matrix[n - 2] = matrix[n - 1];
        matrix[n - 1] = temp;
    }

    private static String printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("POSSIBLE\n");
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                sb.append(row[j]);
                if (j != row.length - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}