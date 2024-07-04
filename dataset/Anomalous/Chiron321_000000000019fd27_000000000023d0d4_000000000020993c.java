import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

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
                outerLoop:
                for (int i = 0; i < size; i++) {
                    for (int k = i + 1; k < size; k++) {
                        if (matrix[i][j] == matrix[k][j]) {
                            duplicateColumns++;
                            columnHasDuplicate = true;
                            break outerLoop;
                        }
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
            caseNumber++;
        }
        scanner.close();
    }

    private static boolean contains(int[] array, int value, int length) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
}