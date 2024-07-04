import java.util.Scanner;
import java.util.Arrays;

public class CodeJam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowRepetitions = 0;
            int colRepetitions = 0;

            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowCheck = new boolean[matrixSize + 1];
                boolean[] colCheck = new boolean[matrixSize + 1];
                boolean rowHasRepetition = false;
                boolean colHasRepetition = false;

                for (int j = 0; j < matrixSize; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowHasRepetition = true;
                    } else {
                        rowCheck[matrix[i][j]] = true;
                    }

                    if (colCheck[matrix[j][i]]) {
                        colHasRepetition = true;
                    } else {
                        colCheck[matrix[j][i]] = true;
                    }
                }

                trace += matrix[i][i];
                if (rowHasRepetition) rowRepetitions++;
                if (colHasRepetition) colRepetitions++;
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepetitions + " " + colRepetitions);
        }

        scanner.close();
    }
}