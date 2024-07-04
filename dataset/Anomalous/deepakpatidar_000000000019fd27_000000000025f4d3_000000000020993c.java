import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int a = 0; a < t; a++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int dia = 0;
            
            // Reading input and calculating the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
                dia += arr[i][i];
            }
            
            int c = 0, r = 0;
            
            // Checking for duplicate elements in rows and columns
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];
                
                for (int j = 0; j < n; j++) {
                    // Check row
                    if (rowCheck[arr[i][j]]) {
                        c++;
                        break;
                    }
                    rowCheck[arr[i][j]] = true;
                    
                    // Check column
                    if (colCheck[arr[j][i]]) {
                        r++;
                        break;
                    }
                    colCheck[arr[j][i]] = true;
                }
            }
            
            System.out.println("Case #" + (a + 1) + ": " + dia + " " + r + " " + c);
        }
        
        sc.close();
    }
}