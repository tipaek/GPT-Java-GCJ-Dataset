import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                    if (rowCheck[value]) {
                        rowRepeats++;
                        rowCheck = new boolean[n + 1]; // Reset for the next row
                        break;
                    } else {
                        rowCheck[value] = true;
                    }
                }
            }

            // Check for column repeats
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    int value = matrix[i][j];
                    if (colCheck[value]) {
                        colRepeats++;
                        break;
                    } else {
                        colCheck[value] = true;
                    }
                }
            }

            System.out.format("Case #%d: %d %d %d\n", t, trace, rowRepeats, colRepeats);
        }
        
        scanner.close();
    }
}