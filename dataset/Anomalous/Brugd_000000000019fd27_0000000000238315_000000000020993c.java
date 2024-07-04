import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in); PrintWriter output = new PrintWriter(System.out)) {
            int testCases = input.nextInt();
            
            for (int i = 0; i < testCases; i++) {
                int[][] matrix = readMatrix(input);
                int[] result = analyzeMatrix(matrix);
                output.printf("Case #%d: %d %d %d%n", (i + 1), result[0], result[1], result[2]);
                output.flush();
            }
        }
    }
    
    private static int[][] readMatrix(Scanner input) {
        int size = input.nextInt();
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        
        return matrix;
    }
    
    private static int[] analyzeMatrix(int[][] matrix) {
        int size = matrix.length;
        int[] result = new int[3];
        
        boolean[][] rowSeen = new boolean[size][size + 1];
        boolean[][] colSeen = new boolean[size][size + 1];
        
        boolean[] invalidRows = new boolean[size];
        boolean[] invalidCols = new boolean[size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    result[0] += matrix[i][j];
                }
                
                if (rowSeen[i][matrix[i][j]] && !invalidRows[i]) {
                    invalidRows[i] = true;
                    result[1]++;
                }
                
                if (colSeen[j][matrix[i][j]] && !invalidCols[j]) {
                    invalidCols[j] = true;
                    result[2]++;
                }
                
                rowSeen[i][matrix[i][j]] = true;
                colSeen[j][matrix[i][j]] = true;
            }
        }
        
        return result;
    }
}