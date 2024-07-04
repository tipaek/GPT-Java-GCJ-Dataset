import java.util.Arrays;
import java.util.Scanner;

class LatinMatrix {
    public static void main(String[] args) {
        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);
            int testCaseCount = scanner.nextInt();

            for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
                int matrixSize = scanner.nextInt();
                int[][] matrix = new int[matrixSize][matrixSize];
                int trace = 0, rowDuplicates = 0, colDuplicates = 0;

                for (int i = 0; i < matrixSize; i++) {
                    int[] rowSet = new int[matrixSize + 1];
                    boolean rowHasDuplicate = false;

                    for (int j = 0; j < matrixSize; j++) {
                        int value = scanner.nextInt();
                        matrix[i][j] = value;

                        if (i == j) {
                            trace += value;
                        }

                        if (rowSet[value] != 0 && !rowHasDuplicate) {
                            rowDuplicates++;
                            rowHasDuplicate = true;
                        }
                        rowSet[value] = value;
                    }
                }

                for (int i = 0; i < matrixSize; i++) {
                    int[] colSet = new int[matrixSize + 1];

                    for (int j = 0; j < matrixSize; j++) {
                        int value = matrix[j][i];

                        if (colSet[value] != 0) {
                            colDuplicates++;
                            break;
                        }
                        colSet[value] = value;
                    }
                }

                System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}