import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Codejam1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputs = sc.nextInt();
        
        for (int i = 0; i < inputs; i++) {
            int arraySize = sc.nextInt();
            int[][] matrix = new int[arraySize][arraySize];
            
            for (int x = 0; x < arraySize; x++) {
                for (int y = 0; y < arraySize; y++) {
                    matrix[x][y] = sc.nextInt();
                }
            }
            
            processMatrix(matrix, arraySize, i + 1);
        }
        
        sc.close();
    }

    private static void processMatrix(int[][] matrix, int size, int caseNumber) {
        int diagonalSum = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;
        
        // Calculate diagonal sum
        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
        }
        
        // Check for repeated elements in rows
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    repeatedRows++;
                    break;
                }
            }
        }
        
        // Check for repeated elements in columns
        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!colSet.add(matrix[j][i])) {
                    repeatedCols++;
                    break;
                }
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
    }
}