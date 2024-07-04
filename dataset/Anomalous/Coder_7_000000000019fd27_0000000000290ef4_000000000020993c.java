import java.util.Scanner;

class Essayas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        int caseNumber = 1;

        for (int i = 0; i < numberOfCases; i++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int[][] colCounts = new int[matrixSize][matrixSize];
            boolean[] colChecked = new boolean[matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                int[] rowCounts = new int[matrixSize];
                String[] rowValues = scanner.nextLine().split(" ");
                boolean rowDuplicateFound = false;

                for (int k = 0; k < matrixSize; k++) {
                    int value = Integer.parseInt(rowValues[k]);
                    rowCounts[value - 1]++;

                    if (rowCounts[value - 1] > 1 && !rowDuplicateFound) {
                        rowRepeats++;
                        rowDuplicateFound = true;
                    }

                    colCounts[k][value - 1]++;
                    if (!colChecked[k] && colCounts[k][value - 1] > 1) {
                        colRepeats++;
                        colChecked[k] = true;
                    }

                    if (k == j) {
                        trace += value;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
            caseNumber++;
        }
    }
}