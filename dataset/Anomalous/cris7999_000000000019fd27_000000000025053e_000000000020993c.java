import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTest = sc.nextInt();
        int[][] solution = new int[numTest][3];

        for (int test = 0; test < numTest; ++test) {
            int numRows = sc.nextInt();
            int[][] matrix = new int[numRows][numRows];

            // Read matrix data
            sc.nextLine();
            for (int i = 0; i < numRows; ++i) {
                String[] input = sc.nextLine().split(" ");
                for (int j = 0; j < numRows; ++j) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                }
            }

            // Calculate the trace
            solution[test][0] = 0;
            for (int i = 0; i < numRows; ++i) {
                solution[test][0] += matrix[i][i];
            }

            // Calculate the number of rows with duplicate elements
            solution[test][1] = countDuplicateRows(matrix, numRows);

            // Calculate the number of columns with duplicate elements
            solution[test][2] = countDuplicateColumns(matrix, numRows);

            System.out.println("Case #" + (test + 1) + ": " + solution[test][0] + " " + solution[test][1] + " " + solution[test][2]);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int numRows) {
        int duplicateRows = 0;
        for (int i = 0; i < numRows; ++i) {
            boolean hasDuplicate = false;
            for (int j = 0; j < numRows; ++j) {
                for (int k = j + 1; k < numRows; ++k) {
                    if (matrix[i][j] == matrix[i][k]) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int numRows) {
        int duplicateColumns = 0;
        for (int i = 0; i < numRows; ++i) {
            boolean hasDuplicate = false;
            for (int j = 0; j < numRows; ++j) {
                for (int k = j + 1; k < numRows; ++k) {
                    if (matrix[j][i] == matrix[k][i]) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }
}