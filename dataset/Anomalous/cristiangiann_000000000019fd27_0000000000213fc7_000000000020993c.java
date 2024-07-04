import java.util.Scanner;

public class CodeJam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixDimension = scanner.nextInt();
            int[][] matrix = new int[matrixDimension][matrixDimension];

            for (int i = 0; i < matrixDimension; i++) {
                for (int j = 0; j < matrixDimension; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowRepetitions = 0;
            int colRepetitions = 0;

            for (int i = 0; i < matrixDimension; i++) {
                boolean[] rowCheck = new boolean[matrixDimension + 1];
                boolean[] colCheck = new boolean[matrixDimension + 1];
                boolean rowHasRepetition = false;
                boolean colHasRepetition = false;

                for (int j = 0; j < matrixDimension; j++) {
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

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepetitions + " " + colRepetitions);
        }
    }
}