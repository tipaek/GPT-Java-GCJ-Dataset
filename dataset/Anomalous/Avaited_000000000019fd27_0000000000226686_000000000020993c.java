import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                int size = scanner.nextInt();
                int diagonalSum = 0;
                int rowDupCount = 0;
                int colDupCount = 0;
                int[][] latinSquare = new int[size][size];

                // Read matrix and check for row duplicates
                for (int i = 0; i < size; i++) {
                    HashMap<Integer, Boolean> rowMap = new HashMap<>();
                    boolean isRowDup = false;
                    for (int j = 0; j < size; j++) {
                        latinSquare[i][j] = scanner.nextInt();
                        if (i == j) {
                            diagonalSum += latinSquare[i][j];
                        }
                        if (rowMap.getOrDefault(latinSquare[i][j], false)) {
                            isRowDup = true;
                        } else {
                            rowMap.put(latinSquare[i][j], true);
                        }
                    }
                    if (isRowDup) {
                        rowDupCount++;
                    }
                }

                // Check for column duplicates
                for (int j = 0; j < size; j++) {
                    HashMap<Integer, Boolean> colMap = new HashMap<>();
                    boolean isColDup = false;
                    for (int i = 0; i < size; i++) {
                        if (colMap.getOrDefault(latinSquare[i][j], false)) {
                            isColDup = true;
                        } else {
                            colMap.put(latinSquare[i][j], true);
                        }
                    }
                    if (isColDup) {
                        colDupCount++;
                    }
                }

                System.out.println("Case #" + t + ": " + diagonalSum + " " + rowDupCount + " " + colDupCount);
                // Uncomment the following lines if you need to process or print the matrix
                // processMatrix(latinSquare, size);
                // printMatrix(latinSquare, size);
            }
        }
    }
}