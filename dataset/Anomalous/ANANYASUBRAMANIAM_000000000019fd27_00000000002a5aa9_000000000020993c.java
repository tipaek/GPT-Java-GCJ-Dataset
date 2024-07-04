import java.util.Scanner;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();

        for (int cases = 0; cases < times; cases++) {
            int n = scanner.nextInt();
            String[][] square = new String[n][n];

            // Reading the square matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    square[i][j] = scanner.next();
                }
            }

            // Calculating diagonal sum
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += Integer.parseInt(square[i][i]);
            }

            // Checking for repeated elements in columns
            int repeatCol = 0;
            for (int j = 0; j < n; j++) {
                HashSet<String> columnSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!columnSet.add(square[i][j])) {
                        repeatCol++;
                        break;
                    }
                }
            }

            // Checking for repeated elements in rows
            int repeatRow = 0;
            for (int i = 0; i < n; i++) {
                HashSet<String> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(square[i][j])) {
                        repeatRow++;
                        break;
                    }
                }
            }

            // Printing the result for the current case
            System.out.println("Case #" + (cases + 1) + ": " + diagonalSum + " " + repeatRow + " " + repeatCol);
        }

        scanner.close();
    }
}