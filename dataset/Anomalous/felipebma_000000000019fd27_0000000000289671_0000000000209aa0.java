import java.util.*;

class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<HashSet<Integer>> rows, cols;
    private static int targetSum, currentSum;

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            processCase(caseIndex);
        }
    }

    private static void processCase(int caseNumber) {
        int size = scanner.nextInt();
        targetSum = scanner.nextInt();
        int[][] matrix = new int[size][size];
        rows = new ArrayList<>();
        cols = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }
        currentSum = 0;

        if (fillMatrix(matrix, 0, 0)) {
            System.out.printf("Case #%d: POSSIBLE\n", caseNumber);
            for (int[] row : matrix) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } else {
            System.out.printf("Case #%d: IMPOSSIBLE\n", caseNumber);
        }
    }

    private static boolean fillMatrix(int[][] matrix, int row, int col) {
        if (currentSum > targetSum) return false;
        if (row == matrix.length) {
            return currentSum == targetSum;
        }

        if (col == matrix.length) return fillMatrix(matrix, row + 1, 0);

        for (int num = 1; num <= matrix.length; num++) {
            if (!rows.get(row).contains(num) && !cols.get(col).contains(num)) {
                if (row == col) currentSum += num;
                matrix[row][col] = num;
                rows.get(row).add(num);
                cols.get(col).add(num);

                if (fillMatrix(matrix, row, col + 1)) return true;

                rows.get(row).remove(num);
                cols.get(col).remove(num);
                if (row == col) currentSum -= num;
            }
        }
        return false;
    }
}