import java.util.Scanner;

class TraceMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            // Reading the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Printing the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }

            // Calculating the trace
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Checking for duplicate rows
            for (int i = 0; i < size; i++) {
                boolean[] seen = new boolean[size + 1];
                boolean hasDuplicates = false;
                for (int j = 0; j < size; j++) {
                    if (seen[matrix[i][j]]) {
                        hasDuplicates = true;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
                if (hasDuplicates) {
                    duplicateRows++;
                }
            }

            // Checking for duplicate columns
            for (int j = 0; j < size; j++) {
                boolean[] seen = new boolean[size + 1];
                boolean hasDuplicates = false;
                for (int i = 0; i < size; i++) {
                    if (seen[matrix[i][j]]) {
                        hasDuplicates = true;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
                if (hasDuplicates) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}