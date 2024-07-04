import java.util.Scanner;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < cases; caseIndex++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int[][] matrix = new int[n][n];

            if (k < n) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
                continue;
            }

            int quotient = k / n;
            int remainder = k % n;

            for (int i = n - 1; i >= 0; i--) {
                matrix[i][i] = quotient;
                if (remainder > 0) {
                    matrix[i][i]++;
                    remainder--;
                }
            }

            int initialDiagonalValue = matrix[0][0];
            for (int row = 0; row < n; row++) {
                if (matrix[row][row] == initialDiagonalValue) {
                    int col = row + 1;
                    while (col < n) {
                        int temp = matrix[row][col - 1] + 1;
                        if (temp > n) temp %= n;
                        matrix[row][col] = temp;
                        col++;
                    }
                    int temp = matrix[row][col - 1] + 1;
                    if (temp > n) temp %= n;
                    matrix[row][0] = temp;
                    col = 1;
                    while (col < row) {
                        int temp1 = matrix[row][col - 1] + 1;
                        if (temp1 > n) temp1 %= n;
                        matrix[row][col] = temp1;
                        col++;
                    }
                }
            }

            if (hasDuplicates(matrix, n)) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static boolean hasDuplicates(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            if (containsDuplicates(matrix[i])) return true;
        }

        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (containsDuplicates(column)) return true;
        }

        return false;
    }

    private static boolean containsDuplicates(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : array) {
            if (map.containsKey(value)) return true;
            map.put(value, 1);
        }
        return false;
    }
}