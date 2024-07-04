import java.util.Scanner;

class Solution { 
    static int[][] generateLatinSquare(int n, int d) { 
        int[][] a = new int[n][n];
        int k = n + 1;
        
        for (int i = 0; i < n; i++) { 
            int temp = k; 
            int r = 0;
            
            // Fill the first part of the row
            while (temp <= n) {
                if (temp == 1) {
                    a[i][r] = d;
                } else if (temp == d) {
                    a[i][r] = 1;
                } else {
                    a[i][r] = temp;
                }
                temp++;
                r++;
            }
            
            // Fill the remaining part of the row
            for (int j = r; j < n; j++) {
                int x = j + 1 - i;
                if (x == 1) {
                    a[i][j] = d;
                } else if (x == d) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = x;
                }
            }
            
            k--;    
        }
        
        return a;
    }  

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int p = 0; p < t; p++) {
            boolean possible = false;
            int n = sc.nextInt();
            int trace = sc.nextInt();
            
            for (int d = 1; d <= n; d++) {
                if (n * d == trace) {
                    possible = true;
                    System.out.println("Case #" + (p + 1) + ": POSSIBLE");
                    int[][] latinSquare = generateLatinSquare(n, d); 
                    
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            System.out.print(latinSquare[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                }
            }
            
            if (!possible) {
                System.out.println("Case #" + (p + 1) + ": IMPOSSIBLE");
            }
        }
        
        sc.close();
    }
}