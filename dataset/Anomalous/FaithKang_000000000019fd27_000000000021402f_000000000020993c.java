import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;
            int uniformRows = 0;
            int uniformCols = 0;
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];
                boolean isRowUniform = true;
                boolean isColUniform = true;
                
                for (int j = 0; j < size - 1; j++) {
                    if (matrix[i][j] != matrix[i][j + 1]) {
                        isRowUniform = false;
                    }
                    if (matrix[j][i] != matrix[j + 1][i]) {
                        isColUniform = false;
                    }
                }
                
                if (isRowUniform) {
                    uniformRows++;
                }
                if (isColUniform) {
                    uniformCols++;
                }
            }
            
            System.out.println("#" + t + " " + diagonalSum + " " + uniformRows + " " + uniformCols);
        }
        
        scanner.close();
    }
}