import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int[] result = analyzeLatinSquare(matrix);
            System.out.println("Case #" + i + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    private static int[] analyzeLatinSquare(int[][] matrix) {
        int N = matrix.length;
        int[] result = new int[3];
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < N; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            
            for (int j = 0; j < N; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
                
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
            
            if (rowSet.size() != N) {
                rowRepeats++;
            }
            if (colSet.size() != N) {
                colRepeats++;
            }
        }

        result[0] = trace;
        result[1] = rowRepeats;
        result[2] = colRepeats;

        return result;
    }
}