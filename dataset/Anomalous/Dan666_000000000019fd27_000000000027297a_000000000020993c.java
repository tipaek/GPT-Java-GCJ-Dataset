import java.util.*;

public class Solution {

    public static void ref(int[][] ar, int n, int q) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;
        
        for (int i = 0; i < n; i++) {
            trace += ar[i][i]; // Calculate the trace

            // Check for duplicate elements in rows
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(ar[i][j])) {
                    rowDuplicates++;
                    break;
                }
            }

            // Check for duplicate elements in columns
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!colSet.add(ar[j][i])) {
                    colDuplicates++;
                    break;
                }
            }
        }

        System.out.format("Case #%d: %d %d %d\n", q, trace, rowDuplicates, colDuplicates);
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
            
            ref(arr, n, i);
        }
        
        sc.close();
    }
}