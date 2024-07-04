import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNo = 1; caseNo <= testCases; caseNo++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            for (int i = 0; i < size; i++) {
                boolean rowHasDuplicate = false;
                for (int j = 0; j < size; j++) {
                    int value = scanner.nextInt();
                    if (!rowHasDuplicate && contains(matrix[i], value, j)) {
                        duplicateRows++;
                        rowHasDuplicate = true;
                    }
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                }
            }

            for (int j = 0; j < size; j++) {
                boolean columnHasDuplicate = false;
                for (int i = 0; i < size; i++) {
                    for (int k = i + 1; k < size; k++) {
                        if (matrix[i][j] == matrix[k][j]) {
                            duplicateColumns++;
                            columnHasDuplicate = true;
                            break;
                        }
                    }
                    if (columnHasDuplicate) {
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNo + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static boolean contains(int[] array, int value, int upToIndex) {
        for (int i = 0; i < upToIndex; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
}