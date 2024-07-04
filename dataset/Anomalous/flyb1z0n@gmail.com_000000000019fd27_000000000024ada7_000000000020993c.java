import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int[] result = analyzeMatrix(matrix);
            System.out.printf("Case #%d: %d %d %d%n", t, result[0], result[1], result[2]);
        }
    }

    public static int[] analyzeMatrix(int[][] matrix) {
        int trace = 0;
        int size = matrix.length;
        int[][] rowCount = new int[size][size];
        int[][] colCount = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                rowCount[i][matrix[i][j] - 1]++;
                colCount[j][matrix[i][j] - 1]++;
            }
        }

        int duplicateRows = 0;
        int duplicateCols = 0;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (rowCount[i][j] > 1) {
                    duplicateRows++;
                    break;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (colCount[i][j] > 1) {
                    duplicateCols++;
                    break;
                }
            }
        }

        return new int[]{trace, duplicateRows, duplicateCols};
    }
}