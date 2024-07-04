import java.util.HashMap;
import java.util.Scanner;

public class Vestigium {

    public static void printMatrix(int[][] matrix, int size) {
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
        
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int diagonalSum = 0;
            int rowDupCount = 0;
            int colDupCount = 0;
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                boolean isRowDup = false;
                
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                    if (rowMap.containsKey(matrix[i][j])) {
                        isRowDup = true;
                    } else {
                        rowMap.put(matrix[i][j], 1);
                    }
                }
                
                if (isRowDup) {
                    rowDupCount++;
                }
            }

            for (int j = 0; j < matrixSize; j++) {
                HashMap<Integer, Integer> colMap = new HashMap<>();
                boolean isColDup = false;
                
                for (int i = 0; i < matrixSize; i++) {
                    if (colMap.containsKey(matrix[i][j])) {
                        isColDup = true;
                    } else {
                        colMap.put(matrix[i][j], 1);
                    }
                }
                
                if (isColDup) {
                    colDupCount++;
                }
            }

            System.out.println("Case #" + t + ": " + diagonalSum + " " + rowDupCount + " " + colDupCount);
        }
        
        scanner.close();
    }
}