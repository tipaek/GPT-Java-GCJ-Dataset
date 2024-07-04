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
            int colRepeats = 0;
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
                resetOccurrences(hasOccurred);
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
                resetOccurrences(hasOccurred);
                for (int i = 0; i < n; i++) {
                    if (hasOccurred[matrix[i][j]]) {
                        colRepeats++;
                        break;
                    } else {
                        hasOccurred[matrix[i][j]] = true;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static void resetOccurrences(boolean[] hasOccurred) {
        for (int i = 0; i < hasOccurred.length; i++) {
            hasOccurred[i] = false;
        }
    }
}