import java.util.Scanner;

class Main {
    public static void calculator(Scanner sc, int caseNumber) {
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        sc.nextLine(); // consume the remaining newline
        int[][] matrix = new int[n][n];
        int trace = 0;
        int repeatRow = 0, repeatCol = 0;

        for (int i = 0; i < n; i++) {
            String[] row = sc.nextLine().split("\\s+");
            boolean[] usedInRow = new boolean[n];
            boolean rowHasRepetition = false;

            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(row[j]);
                matrix[i][j] = val;

                if (i == j) {
                    trace += val;
                }

                if (usedInRow[val - 1]) {
                    rowHasRepetition = true;
                }
                usedInRow[val - 1] = true;
            }

            if (rowHasRepetition) {
                repeatRow++;
            }
        }

        for (int j = 0; j < n; j++) {
            boolean[] usedInCol = new boolean[n];
            boolean colHasRepetition = false;

            for (int i = 0; i < n; i++) {
                int val = matrix[i][j];

                if (usedInCol[val - 1]) {
                    colHasRepetition = true;
                    break;
                }
                usedInCol[val - 1] = true;
            }

            if (colHasRepetition) {
                repeatCol++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatRow + " " + repeatCol);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int i = 0; i < testCases; i++) {
            calculator(sc, i + 1);
        }
    }
}