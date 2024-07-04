import java.util.Scanner;
import java.util.Arrays;

public class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < dimension; i++) {
                boolean[] rowCheck = new boolean[dimension + 1];
                boolean[] colCheck = new boolean[dimension + 1];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < dimension; j++) {
                    if (rowCheck[matrix[i][j]]) rowHasDuplicate = true;
                    else rowCheck[matrix[i][j]] = true;

                    if (colCheck[matrix[j][i]]) colHasDuplicate = true;
                    else colCheck[matrix[j][i]] = true;
                }

                trace += matrix[i][i];
                if (rowHasDuplicate) rowRepeats++;
                if (colHasDuplicate) colRepeats++;
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}