import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            // Reading the matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            
            // Calculating the trace
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += arr[j][j];
            }
            
            // Counting rows with repeated elements
            int rowsWithDuplicates = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(arr[j][k])) {
                        rowsWithDuplicates++;
                        break;
                    }
                }
            }
            
            // Counting columns with repeated elements
            int columnsWithDuplicates = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!colSet.add(arr[k][j])) {
                        columnsWithDuplicates++;
                        break;
                    }
                }
            }
            
            // Printing the result
            System.out.println("Case #" + i + ": " + trace + " " + rowsWithDuplicates + " " + columnsWithDuplicates);
        }
        sc.close();
    }
}