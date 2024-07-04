import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            int rCount = 0;
            int cCount = 0;
            int sum = 0;

            // Check rows for duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(arr[i][j])) {
                        rowHasDuplicate = true;
                    }
                }
                if (rowHasDuplicate) {
                    rCount++;
                }
            }

            // Check columns for duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(arr[j][i])) {
                        colHasDuplicate = true;
                    }
                }
                if (colHasDuplicate) {
                    cCount++;
                }
            }

            // Calculate the sum of the diagonal
            for (int i = 0; i < n; i++) {
                sum += arr[i][i];
            }

            System.out.println("Case #" + (k + 1) + ": " + sum + " " + rCount + " " + cCount);
        }
        
        sc.close();
    }
}