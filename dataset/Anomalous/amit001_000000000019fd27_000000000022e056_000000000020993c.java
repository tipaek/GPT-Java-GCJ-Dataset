import java.util.Scanner;

public class MatrixAnalysis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            // Reading matrix and calculating diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            // Checking for repeated elements in rows
            for (int i = 0; i < n; i++) {
                boolean hasRepetition = false;
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (matrix[i][j] == matrix[i][k]) {
                            repeatedRows++;
                            hasRepetition = true;
                            break;
                        }
                    }
                    if (hasRepetition) break;
                }
            }

            // Checking for repeated elements in columns
            for (int i = 0; i < n; i++) {
                boolean hasRepetition = false;
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (matrix[j][i] == matrix[k][i]) {
                            repeatedColumns++;
                            hasRepetition = true;
                            break;
                        }
                    }
                    if (hasRepetition) break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);

            t--;
            caseNumber++;
        }

        sc.close();
    }
}