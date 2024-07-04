import java.util.*;

class Solution {
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 0;
        while (t-- > 0) {
            caseNumber++;
            found = false;
            int n = sc.nextInt();
            int trace = sc.nextInt();
            solveCase(n, trace, caseNumber);

            if (!found) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    static void solveCase(int n, int trace, int caseNumber) {
        int[][] matrix = new int[n][n];
        ArrayList<HashSet<Integer>> columns = new ArrayList<>();
        HashSet<Integer> currentRow = new HashSet<>();

        for (int i = 0; i < n; i++) {
            columns.add(new HashSet<>());
        }

        fillMatrix(matrix, 0, 0, currentRow, columns, trace, caseNumber);
    }

    static void fillMatrix(int[][] matrix, int row, int col, HashSet<Integer> currentRow, ArrayList<HashSet<Integer>> columns, int trace, int caseNumber) {
        if (col >= matrix.length) {
            row++;
            col = 0;
            currentRow.clear();
        }
        if (row >= matrix.length) {
            if (calculateTrace(matrix) == trace) {
                found = true;
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int[] rowArray : matrix) {
                    for (int value : rowArray) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }

        for (int num = 1; num <= matrix.length; num++) {
            if (!columns.get(col).contains(num) && !currentRow.contains(num)) {
                matrix[row][col] = num;
                currentRow.add(num);
                columns.get(col).add(num);
                fillMatrix(matrix, row, col + 1, currentRow, columns, trace, caseNumber);
                if (found) return;
                currentRow.remove(num);
                columns.get(col).remove(num);
            }
        }
    }

    static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
}