import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = Integer.parseInt(sc.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                String[] rowData = sc.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowData[col]);
                }
            }
            
            int repeatedColumns = 0;
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    if (!columnSet.add(matrix[row][col])) {
                        repeatedColumns++;
                        break;
                    }
                }
            }
            
            int repeatedRows = 0;
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        repeatedRows++;
                        break;
                    }
                }
            }
            
            int diagonalSum = 0;
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }
            
            System.out.println("Case #" + (t + 1) + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }
        
        sc.close();
    }
}