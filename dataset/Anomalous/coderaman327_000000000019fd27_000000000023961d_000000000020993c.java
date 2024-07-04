import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize + 1][matrixSize + 1];
            int[][] rowCheck = new int[matrixSize + 1][matrixSize + 1];
            int[][] colCheck = new int[matrixSize + 1][matrixSize + 1];
            int trace = 0;

            for (int i = 1; i <= matrixSize; i++) {
                for (int j = 1; j <= matrixSize; j++) {
                    int element = scanner.nextInt();
                    matrix[i][j] = element;

                    if (i == j) {
                        trace += element;
                    }

                    if (rowCheck[i][element] == 1) {
                        rowCheck[i][0] = 1;
                    }
                    rowCheck[i][element]++;

                    if (colCheck[j][element] == 1) {
                        colCheck[j][0] = 1;
                    }
                    colCheck[j][element]++;
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 1; i <= matrixSize; i++) {
                if (rowCheck[i][0] == 1) {
                    duplicateRows++;
                }
                if (colCheck[i][0] == 1) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}