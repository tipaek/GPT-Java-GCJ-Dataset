import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int matrixSize = input.nextInt();
            input.nextLine();  // consume the remaining newline
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                String[] row = input.nextLine().split(" ");
                for (int j = 0; j < row.length; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate elements in rows
            for (int i = 0; i < matrixSize; i++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int j = 0; j < matrixSize; j++) {
                    if (seen[matrix[i][j]]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Check for duplicate elements in columns
            for (int j = 0; j < matrixSize; j++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int i = 0; i < matrixSize; i++) {
                    if (seen[matrix[i][j]]) {
                        colDuplicates++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}