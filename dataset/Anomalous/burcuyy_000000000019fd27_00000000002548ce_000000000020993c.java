import java.util.Scanner;

class Vestigium {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int row = 0; row < n; row++) {
                String[] rowValues = scanner.nextLine().split("\\s+");
                boolean[] rowSeen = new boolean[n + 1];
                boolean rowHasRepeat = false;

                for (int col = 0; col < n; col++) {
                    matrix[row][col] = Integer.parseInt(rowValues[col]);

                    if (row == col) {
                        trace += matrix[row][col];
                    }

                    if (!rowHasRepeat && rowSeen[matrix[row][col]]) {
                        rowHasRepeat = true;
                    }
                    rowSeen[matrix[row][col]] = true;
                }

                if (rowHasRepeat) {
                    rowRepeats++;
                }
            }

            for (int col = 0; col < n; col++) {
                boolean[] colSeen = new boolean[n + 1];
                boolean colHasRepeat = false;

                for (int row = 0; row < n; row++) {
                    if (!colHasRepeat && colSeen[matrix[row][col]]) {
                        colHasRepeat = true;
                    }
                    colSeen[matrix[row][col]] = true;
                }

                if (colHasRepeat) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}