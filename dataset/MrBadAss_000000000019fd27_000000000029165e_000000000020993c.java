import java.util.*;

public class Solution {
    private static Scanner sc;
    static int tn = 1;
    static int sqr[][] = new int[60][60];
    static int n, k, t;
    static Boolean row_safe[][] = new Boolean[60][60], col_safe[][] = new Boolean[60][60], solved;
        
    public static void main(String[] args) {
        
        sc = new Scanner(System.in);

        int T= sc.nextInt();
        sc.nextLine();

        while(T-- > 0){
            n = sc.nextInt();
            k = sc.nextInt();
            result(1,1,0);
            if(!solved) {
                System.out.println("Case #" + (tn++) + ": IMPOSSIBLE");
            }
            solved = false;
        }
    }

    private static void result(int row, int col, int m) {
        if(row == n && col == n+1 && m==k && !solved) {
            solved = true;
            System.out.println("Case #" + (tn++) + ": POSSIBLE");
            for (int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    System.out.print(sqr[i][j]);
                }
                System.out.println("");
            }
            return;
        } else if(row > n) {
            return;
        } else if (col > n) {
            result(row + 1, 1, m);
        }
        for (int q = 0; q < n && !solved; q++) {
            if (!row_safe[row][q] && !col_safe[col][q]) {
            row_safe[row][q] = col_safe[col][q] = true;
            if (row == col) {
                m += q;
            }
            sqr[row][col] = q;

            result(row, col+1, m);

            row_safe[row][q] = col_safe[col][q] = false;

            if(row == col){
                m -= q;
            }
            sqr[row][col] = 0;
        }
    }
}
}