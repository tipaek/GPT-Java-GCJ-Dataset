package jam;

import java.util.Scanner;

public class Jam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < size; i++) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for repeated elements in rows
            for (int i = 0; i < size; i++) {
                boolean[] seen = new boolean[size + 1];
                for (int j = 0; j < size; j++) {
                    if (seen[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Check for repeated elements in columns
            for (int j = 0; j < size; j++) {
                boolean[] seen = new boolean[size + 1];
                for (int i = 0; i < size; i++) {
                    if (seen[matrix[i][j]]) {
                        colRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseIndex, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}