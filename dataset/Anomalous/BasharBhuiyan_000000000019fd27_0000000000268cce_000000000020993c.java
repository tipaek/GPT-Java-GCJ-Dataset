import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] rowTracker = new int[matrixSize][matrixSize];
            int[][] colTracker = new int[matrixSize][matrixSize];

            int trace = 0, maxRowRepeats = 0, maxColRepeats = 0;

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();

                    if (row == col) {
                        trace += value;
                    }

                    rowTracker[row][value - 1]++;
                    colTracker[col][value - 1]++;

                    if (rowTracker[row][value - 1] > maxRowRepeats) {
                        maxRowRepeats = rowTracker[row][value - 1];
                    }

                    if (colTracker[col][value - 1] > maxColRepeats) {
                        maxColRepeats = colTracker[col][value - 1];
                    }
                }
            }

            if (maxRowRepeats == 1) {
                maxRowRepeats = 0;
            }
            if (maxColRepeats == 1) {
                maxColRepeats = 0;
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + maxRowRepeats + " " + maxColRepeats);
        }
    }
}