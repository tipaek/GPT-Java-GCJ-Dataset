import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean rowHasDuplicate = false;
                
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    
                    if (!rowHasDuplicate && rowCheck[matrix[i][j]]) {
                        rowHasDuplicate = true;
                        rowDuplicates++;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            // Checking for column duplicates
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean colHasDuplicate = false;
                
                for (int i = 0; i < n; i++) {
                    if (!colHasDuplicate && colCheck[matrix[i][j]]) {
                        colHasDuplicate = true;
                        colDuplicates++;
                    }
                    colCheck[matrix[i][j]] = true;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}