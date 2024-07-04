import java.util.*;

class Solution {
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            found = false;
            int n = sc.nextInt();
            int trace = sc.nextInt();
            processCase(n, trace, caseNumber);

            if (!found) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
        }
    }

    static void processCase(int n, int trace, int caseNumber) {
        int[][] matrix = new int[n][n];
        List<Set<Integer>> columns = new ArrayList<>();
        Set<Integer> rowSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            columns.add(new HashSet<>());
        }

        fillMatrix(matrix, 0, 0, rowSet, columns, trace, caseNumber, 0);
    }

    static void fillMatrix(int[][] matrix, int i, int j, Set<Integer> rowSet, List<Set<Integer>> columns, int trace, int caseNumber, int currentSum) {
        if (currentSum > trace) {
            return;
        }

        if (j >= matrix.length) {
            i++;
            j = 0;
            rowSet.clear();
        }

        if (i >= matrix.length) {
            if (currentSum == trace) {
                found = true;
                printMatrix(matrix, caseNumber);
            }
            return;
        }

        for (int num = 1; num <= matrix.length; num++) {
            if (!columns.get(j).contains(num) && !rowSet.contains(num)) {
                matrix[i][j] = num;
                if (i == j) {
                    currentSum += num;
                }

                rowSet.add(num);
                columns.get(j).add(num);
                fillMatrix(matrix, i, j + 1, rowSet, columns, trace, caseNumber, currentSum);

                if (found) {
                    return;
                }

                rowSet.remove(num);
                columns.get(j).remove(num);
                if (i == j) {
                    currentSum -= num;
                }
            }
        }
    }

    static void printMatrix(int[][] matrix, int caseNumber) {
        System.out.println("Case #" + caseNumber + ": POSSIBLE");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}