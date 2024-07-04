import java.util.HashMap;
import java.util.Scanner;

public class Vestigium {

    private static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int size = scanner.nextInt();
            int diagonalSum = 0;
            int rowDupCount = 0;
            int colDupCount = 0;
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                boolean isRowDuplicate = false;

                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                    if (rowMap.containsKey(matrix[i][j])) {
                        isRowDuplicate = true;
                    } else {
                        rowMap.put(matrix[i][j], 1);
                    }
                }
                if (isRowDuplicate) {
                    rowDupCount++;
                }
            }

            for (int j = 0; j < size; j++) {
                HashMap<Integer, Integer> colMap = new HashMap<>();
                boolean isColDuplicate = false;

                for (int i = 0; i < size; i++) {
                    if (colMap.containsKey(matrix[i][j])) {
                        isColDuplicate = true;
                    } else {
                        colMap.put(matrix[i][j], 1);
                    }
                }
                if (isColDuplicate) {
                    colDupCount++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + diagonalSum + " " + rowDupCount + " " + colDupCount);
        }

        scanner.close();
    }
}