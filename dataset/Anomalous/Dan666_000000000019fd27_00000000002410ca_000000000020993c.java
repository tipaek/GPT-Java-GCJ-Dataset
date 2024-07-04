import java.util.Scanner;

public class Solution {
    
    public void ref(int[][] ar, int n, int q) {
        int trace = 0, rowCount = 0, colCount = 0;
        int[] rowFrequency = new int[10];
        int[] colFrequency = new int[10];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(rowFrequency, 0);
            Arrays.fill(colFrequency, 0);
            boolean rowDuplicate = false;
            boolean colDuplicate = false;
            
            for (int j = 0; j < n; j++) {
                int rowValue = ar[i][j];
                int colValue = ar[j][i];
                
                // Check row for duplicates
                if (rowFrequency[rowValue]++ > 0) {
                    rowDuplicate = true;
                }
                
                // Check column for duplicates
                if (colFrequency[colValue]++ > 0) {
                    colDuplicate = true;
                }
                
                // Calculate the trace
                if (i == j) {
                    trace += rowValue;
                }
            }
            
            if (rowDuplicate) {
                rowCount++;
            }
            if (colDuplicate) {
                colCount++;
            }
        }
        
        System.out.format("Case #%d: %d %d %d\n", q, trace, rowCount, colCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    arr[row][col] = sc.nextInt();
                }
            }
            
            new Solution().ref(arr, n, i);
        }
        sc.close();
    }
}