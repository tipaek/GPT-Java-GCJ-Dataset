import java.util.Scanner;

public class Solution {

    public static void trace(int caseNumber) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] matrix = new int[N][N];
        int[][] transposedMatrix = new int[N][N];
        int[] rowCheck = new int[N];
        int[] colCheck = new int[N];
        int repeatedRows = 0, repeatedCols = 0, matrixTrace = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            boolean rowHasDuplicates = false;
            boolean colHasDuplicates = false;

            for (int j = 0; j < N; j++) {
                rowCheck[matrix[i][j] - 1]++;
                colCheck[transposedMatrix[i][j] - 1]++;
                
                if (i == j) {
                    matrixTrace += matrix[i][j];
                }
            }

            for (int k = 0; k < N; k++) {
                if (rowCheck[k] > 1 && !rowHasDuplicates) {
                    repeatedRows++;
                    rowHasDuplicates = true;
                }
                if (colCheck[k] > 1 && !colHasDuplicates) {
                    repeatedCols++;
                    colHasDuplicates = true;
                }
                rowCheck[k] = 0;
                colCheck[k] = 0;
            }
        }

        System.out.println("Case #" + (caseNumber + 1) + ": " + matrixTrace + " " + repeatedRows + " " + repeatedCols);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            trace(i);
        }
    }
}