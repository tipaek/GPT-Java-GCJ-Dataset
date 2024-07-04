import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int i = 0; i < numberOfTests; i++) {
            int n = scanner.nextInt();
            int trace = scanner.nextInt();
            new Solution().createMatrix(i + 1, n, trace);
        }
    }

    public void createMatrix(int testNumber, int n, int trace) {
        if (trace % n == 0) {
            System.out.println("Case #" + testNumber + ": POSSIBLE");
        } else {
            System.out.println("Case #" + testNumber + ": IMPOSSIBLE");
            return;
        }

        int diagonalValue = trace / n;
        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i != diagonalValue) {
                values.add(i);
            }
        }

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = diagonalValue;
                } else {
                    matrix[i][j] = values.get(index);
                    index++;
                }
                System.out.print(matrix[i][j] + " ");
            }
            // Shift values by one position
            int firstValue = values.remove(0);
            values.add(firstValue);
            System.out.println();
        }
    }
}