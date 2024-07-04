import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
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
            
            int traceValue = calculateTrace(size, matrix);
            int duplicateRows = countDuplicateRows(size, matrix);
            int duplicateColumns = countDuplicateColumns(size, matrix);
            
            System.out.printf("Case #%d: %d %d %d\n", t, traceValue, duplicateRows, duplicateColumns);
        }
    }

    private int calculateTrace(int size, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countDuplicateRows(int size, int[][] matrix) {
        int duplicateRowCount = 0;
        
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            boolean hasDuplicate = false;
            
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j]]) {
                    hasDuplicate = true;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
            
            if (hasDuplicate) {
                duplicateRowCount++;
            }
        }
        
        return duplicateRowCount;
    }

    private int countDuplicateColumns(int size, int[][] matrix) {
        int duplicateColumnCount = 0;
        
        for (int j = 0; j < size; j++) {
            boolean[] seen = new boolean[size + 1];
            boolean hasDuplicate = false;
            
            for (int i = 0; i < size; i++) {
                if (seen[matrix[i][j]]) {
                    hasDuplicate = true;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
            
            if (hasDuplicate) {
                duplicateColumnCount++;
            }
        }
        
        return duplicateColumnCount;
    }
}