import java.util.Scanner;
import java.util.HashSet;

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

            for (int i = 0; i < n; i++) {
                matrix[i][i] = quotient;
                if (remainder > 0) {
                    matrix[i][i]++;
                    remainder--;
                }
            }

            fillMatrix(matrix, n);

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
            if (containsDuplicates(matrix[i])) {
                return true;
            }

            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            if (containsDuplicates(column)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsDuplicates(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static void fillMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            int value = 1;
            for (int j = i + 1; j < size; j++) {
                if (value == matrix[i][i]) value++;
                matrix[i][j] = value++;
            }
            for (int j = 0; j < i; j++) {
                if (value == matrix[i][i]) value++;
                matrix[i][j] = value++;
            }
        }
    }
}