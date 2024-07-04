import java.util.*;

class Solution {

    static boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();
        int caseNumber = 1;

        while (testCaseCount-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int rowCount = 0;
            int colCount = 0;
            int diagonalSum = 0;
            Set<Integer> uniqueRowElements = new HashSet<>();
            Set<Integer> uniqueColElements = new HashSet<>();

            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];

                for (int j = 0; j < n; j++) {
                    uniqueRowElements.clear();
                    uniqueColElements.clear();

                    for (int k = 0; k < n; k++) {
                        if (isValid(i + k, j, n)) uniqueRowElements.add(matrix[i + k][j]);
                        if (isValid(i - k, j, n)) uniqueRowElements.add(matrix[i - k][j]);
                        if (isValid(i, j - k, n)) uniqueColElements.add(matrix[i][j - k]);
                        if (isValid(i, j + k, n)) uniqueColElements.add(matrix[i][j + k]);
                    }

                    if (uniqueRowElements.size() < n) rowCount++;
                    if (uniqueColElements.size() < n) colCount++;
                }
            }

            resultBuilder.append("Case #").append(caseNumber++).append(": ")
                         .append(diagonalSum).append(" ")
                         .append(colCount).append(" ")
                         .append(rowCount).append("\n");
        }

        System.out.println(resultBuilder);
    }
}