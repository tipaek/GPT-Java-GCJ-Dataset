import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (k % n != 0) {
                result.append("Case #").append(caseNumber).append(": IMPOSSIBLE\n");
            } else {
                int[][] matrix = new int[n][n];
                int startValue = k / n;

                // Initialize diagonal elements
                for (int i = 0; i < n; i++) {
                    matrix[i][i] = startValue;
                }

                // Fill matrix to the right of the diagonal
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        int value = matrix[i][j - 1] + 1;
                        if (value > n) {
                            value = 1;
                        }
                        matrix[i][j] = value;
                    }
                }

                // Fill matrix to the left of the diagonal
                for (int i = 0; i < n; i++) {
                    for (int j = i - 1; j >= 0; j--) {
                        int value = matrix[i][j + 1] - 1;
                        if (value < 1) {
                            value = n;
                        }
                        matrix[i][j] = value;
                    }
                }

                result.append("Case #").append(caseNumber).append(": POSSIBLE\n");
                for (int[] row : matrix) {
                    for (int elem : row) {
                        result.append(elem).append(" ");
                    }
                    result.append("\n");
                }
            }
            caseNumber++;
        }
        System.out.println(result);
    }
}