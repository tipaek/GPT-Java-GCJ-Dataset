import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;
            
            // Read the matrix and calculate the trace
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += arr[j][k];
                    }
                }
            }
            
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            // Check for duplicate values in rows
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(arr[j][k])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }
            
            // Check for duplicate values in columns
            for (int k = 0; k < n; k++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(arr[j][k])) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        sc.close();
    }
}