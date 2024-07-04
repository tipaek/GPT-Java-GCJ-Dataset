import java.util.Scanner;

public class LatinSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int n = scanner.nextInt();
            String[][] square = new String[n][n];

            // Reading the square matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    square[i][j] = scanner.next();
                }
            }

            // Calculating the diagonal sum
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += Integer.parseInt(square[i][i]);
            }

            // Checking for repeated elements in columns
            int repeatedColumns = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(square[j][i]);
                    if (seen[value]) {
                        repeatedColumns++;
                        break;
                    }
                    seen[value] = true;
                }
            }

            // Checking for repeated elements in rows
            int repeatedRows = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(square[i][j]);
                    if (seen[value]) {
                        repeatedRows++;
                        break;
                    }
                    seen[value] = true;
                }
            }

            // Output the result for the current case
            System.out.println("Case #" + (caseIndex + 1) + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }

        scanner.close();
    }
}