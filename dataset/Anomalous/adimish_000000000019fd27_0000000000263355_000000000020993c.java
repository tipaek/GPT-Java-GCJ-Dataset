import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += arr[j][k];
                    }
                }
            }
            
            int r = 0;
            int c = 0;
            
            for (int row = 0; row < n; row++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];
                
                for (int col = 0; col < n; col++) {
                    // Check row for duplicates
                    if (rowCheck[arr[row][col]]) {
                        r++;
                        break;
                    }
                    rowCheck[arr[row][col]] = true;
                }
                
                for (int col = 0; col < n; col++) {
                    // Check column for duplicates
                    if (colCheck[arr[col][row]]) {
                        c++;
                        break;
                    }
                    colCheck[arr[col][row]] = true;
                }
            }
            
            System.out.println(trace + " " + r + " " + c);
        }
        
        sc.close();
    }
}