import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int c = 0, j = 0, f = 0;
            int[][] C = new int[2][n];
            int[][] J = new int[2][n];
            StringBuilder s = new StringBuilder();
            
            for (int l = 0; l < n; l++) {
                int k = sc.nextInt();
                int v = sc.nextInt();
                
                if (l == 0) {
                    C[0][c] = k;
                    C[1][c++] = v;
                    s.append("C");
                } else if (k >= C[1][c - 1] || v <= C[0][c - 1]) {
                    C[0][c] = k;
                    C[1][c++] = v;
                    s.append("C");
                } else if ((k <= C[1][c - 1] && k >= C[0][c - 1]) || (v <= C[1][c - 1] && v >= C[0][c - 1])) {
                    if (j == 0) {
                        J[0][j] = k;
                        J[1][j++] = v;
                        s.append("J");
                    } else if (k >= J[1][j - 1] || v <= J[0][j - 1]) {
                        J[0][j] = k;
                        J[1][j++] = v;
                        s.append("J");
                    } else {
                        f = 1;
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        break;
                    }
                }
            }
            
            if (f == 0) {
                System.out.println("Case #" + i + ": " + s.toString());
            }
        }
        
        sc.close();
    }
}