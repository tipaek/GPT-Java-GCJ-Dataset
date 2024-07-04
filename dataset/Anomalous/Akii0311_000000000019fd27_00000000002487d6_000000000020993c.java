import java.util.Scanner;

class Solution {

    public static int countRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    hasDuplicate = true;
                    break;
                }
            }

            if (hasDuplicate) {
                duplicateRowCount++;
            }
        }

        return duplicateRowCount;
    }

    public static int countCols(int[][] matrix, int size) {
        int duplicateColCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    hasDuplicate = true;
                    break;
                }
            }

            if (hasDuplicate) {
                duplicateColCount++;
            }
        }

        return duplicateColCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + countRows(matrix, n) + " " + countCols(matrix, n));
            caseNumber++;
        }

        sc.close();
    }
}