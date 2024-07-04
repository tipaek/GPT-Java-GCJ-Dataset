import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[100][100];
        boolean[] hasOccurred = new boolean[100];

        for (int t = 0; t < testCases; t++) {
            int trace = 0;
            int rowRepeats = 0;
            int columnRepeats = 0;
            int n = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                scanner.nextLine();
            }

            for (int i = 0; i < n; i++) {
                resetArray(hasOccurred);
                for (int j = 0; j < n; j++) {
                    if (hasOccurred[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    } else {
                        hasOccurred[matrix[i][j]] = true;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                resetArray(hasOccurred);
                for (int i = 0; i < n; i++) {
                    if (hasOccurred[matrix[i][j]]) {
                        columnRepeats++;
                        break;
                    } else {
                        hasOccurred[matrix[i][j]] = true;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }
    }

    private static void resetArray(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = false;
        }
    }
}