import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nbTest = sc.nextInt();

        for (int i = 0; i < nbTest; i++) {
            int trace = 0;
            int row = 0;
            int col = 0;
            int nbCase = sc.nextInt();
            int expectedSum = (nbCase * (nbCase + 1)) / 2;

            int[][] matrix = new int[nbCase][nbCase];

            // Read the matrix and calculate the trace
            for (int j = 0; j < nbCase; j++) {
                for (int k = 0; k < nbCase; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int j = 0; j < nbCase; j++) {
                if (hasDuplicate(matrix[j])) {
                    row++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < nbCase; j++) {
                int[] column = new int[nbCase];
                for (int k = 0; k < nbCase; k++) {
                    column[k] = matrix[k][j];
                }
                if (hasDuplicate(column)) {
                    col++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + row + " " + col);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}