import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = Integer.parseInt(br.readLine());
            int trace = 0;
            int[][] matrix = new int[N][N];
            
            for (int row = 0; row < N; row++) {
                String[] line = br.readLine().split(" ");
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = Integer.parseInt(line[col]);
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }
            
            int repeatedRows = countRepeatedRows(matrix);
            int repeatedColumns = countRepeatedColumns(matrix);
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }

    private static int countRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    repeatedRows++;
                    break;
                }
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix) {
        int repeatedColumns = 0;
        int N = matrix.length;
        
        for (int col = 0; col < N; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < N; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatedColumns++;
                    break;
                }
            }
        }
        return repeatedColumns;
    }
}