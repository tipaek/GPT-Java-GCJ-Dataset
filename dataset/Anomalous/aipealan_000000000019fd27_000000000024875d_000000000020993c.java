import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[100][100];
        boolean[] hasOccurred = new boolean[102];

        for (int i = 0; i < t; i++) {
            int sum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int n = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                    if (j == k) {
                        sum += matrix[j][k];
                    }
                }
                scanner.nextLine();
            }

            for (int j = 0; j < n; j++) {
                resetArray(hasOccurred);
                for (int k = 0; k < n; k++) {
                    if (hasOccurred[matrix[j][k]]) {
                        rowDuplicates++;
                        break;
                    } else {
                        hasOccurred[matrix[j][k]] = true;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                resetArray(hasOccurred);
                for (int k = 0; k < n; k++) {
                    if (hasOccurred[matrix[k][j]]) {
                        colDuplicates++;
                        break;
                    } else {
                        hasOccurred[matrix[k][j]] = true;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + sum + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static void resetArray(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = false;
        }
    }
}