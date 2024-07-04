import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        int[][] resultArray = new int[caseCount][3];
        for (int i = 0; i < caseCount; i++) {
            int index = scanner.nextInt();
            int[][] matrix = new int[index][index];
            for (int j = 0; j < index; j++) {
                for (int k = 0; k < index; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            resultArray[i][0] = calculateSum(matrix);
            resultArray[i][1] = printDuplicateRowCount(matrix);
            resultArray[i][2] = printDuplicateColumnCount(matrix);
        }

        //Print the output
        for (int i = 0; i < caseCount; i++) {
            System.out.println("Case #" + (i + 1) + ": " + resultArray[i][0] + " " + resultArray[i][1] + " " + resultArray[i][2]);
        }
    }

    //Calculate the sum and return the result
    private static int calculateSum(int[][] matrix) {
        int index = matrix[0].length;
        int sum = 0;
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                if (i == j)
                    sum = sum + matrix[i][j];
            }
        }
        return sum;
    }

    //Calculate the no. of rows containing duplicate values
    private static int printDuplicateRowCount(int[][] matrix) {
        int index = matrix[0].length;
        int duplicateRowCount = 0;
        for (int i = 0; i < index; i++) {
            boolean duplicateFlag = false;
            for (int j = 0; j < index; j++) {
                for (int k = (j + 1); k < index; k++) {
                    if (matrix[i][j] == matrix[i][k]) {
                        duplicateFlag = true;
                        break;
                    }
                }
                if (duplicateFlag) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        return duplicateRowCount;
    }

    //Calculate the no. of columns containing duplicate values
    private static int printDuplicateColumnCount(int[][] matrix) {
        int index = matrix[0].length;
        int duplicateColCount = 0;
        for (int i = 0; i < index; i++) {
            boolean duplicateFlag = false;
            for (int j = 0; j < index; j++) {
                for (int k = (j + 1); k < index; k++) {
                    if (matrix[j][i] == matrix[k][i]) {
                        duplicateFlag = true;
                        break;
                    }
                }
                if (duplicateFlag) {
                    duplicateColCount++;
                    break;
                }
            }
        }
        return duplicateColCount;
    }
}
