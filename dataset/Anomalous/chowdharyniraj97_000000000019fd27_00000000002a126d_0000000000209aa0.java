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
            generateMatrix(n, trace, caseNumber);

            if (!found) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    static void generateMatrix(int n, int trace, int caseNumber) {
        int[][] matrix = new int[n][n];
        ArrayList<HashSet<Integer>> columns = new ArrayList<>();
        HashSet<Integer> rowSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            columns.add(new HashSet<>());
        }

        fillMatrix(matrix, 0, 0, rowSet, columns, trace, caseNumber, 0);
    }

    static void fillMatrix(int[][] matrix, int i, int j, HashSet<Integer> rowSet, ArrayList<HashSet<Integer>> columns, int trace, int caseNumber, int currentSum) {
        if (currentSum > trace) return;

        if (j >= matrix.length) {
            i++;
            j = 0;
            rowSet.clear();
        }

        if (i >= matrix.length) {
            if (calculateTrace(matrix) == trace) {
                found = true;
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }

        for (int num = 1; num <= matrix.length; num++) {
            if (!columns.get(j).contains(num) && !rowSet.contains(num)) {
                matrix[i][j] = num;
                rowSet.add(num);
                columns.get(j).add(num);
                fillMatrix(matrix, i, j + 1, rowSet, columns, trace, caseNumber, currentSum);
                if (found) return;
                rowSet.remove(num);
                columns.get(j).remove(num);
            }
        }
    }

    static int calculateTrace(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}