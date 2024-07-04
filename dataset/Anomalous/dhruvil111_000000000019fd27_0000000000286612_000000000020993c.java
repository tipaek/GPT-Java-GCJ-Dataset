import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int a = 0; a < t; a++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0, rowRepeat = 0, colRepeat = 0;
            
            // Read the matrix and compute the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += arr[i][j];
                    }
                }
            }
            
            // Check for repeated elements in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(arr[i][j]) && !rowHasDuplicate) {
                        rowRepeat++;
                        rowHasDuplicate = true;
                    }
                }
            }
            
            // Check for repeated elements in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(arr[i][j]) && !colHasDuplicate) {
                        colRepeat++;
                        colHasDuplicate = true;
                    }
                }
            }
            
            System.out.println("Case #" + (a + 1) + ": " + trace + " " + rowRepeat + " " + colRepeat);
        }
    }
}