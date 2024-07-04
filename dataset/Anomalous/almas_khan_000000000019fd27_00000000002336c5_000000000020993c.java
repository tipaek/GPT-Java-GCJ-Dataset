import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int cnt = 1; cnt <= t; cnt++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0, rowcount = 0, colcount = 0;
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
            }
            
            // Calculate rowcount
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[i][j]]) {
                        rowcount++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }
            
            // Calculate colcount
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[j][i]]) {
                        colcount++;
                        break;
                    }
                    seen[arr[j][i]] = true;
                }
            }
            
            // Print result for the current test case
            System.out.println("Case #" + cnt + ": " + trace + " " + rowcount + " " + colcount);
        }
        
        sc.close();
    }
}