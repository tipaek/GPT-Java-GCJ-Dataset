import java.util.Scanner;

public class Solution {
    public static Scanner in = new Scanner(System.in);
    static int[][] m;

    public static int nbRows() {
        int x =0;
        for(int i=0; i < m.length;i++){
            boolean b = true;
            int j= 0;
            while (b && j < m.length) {
                int k=j-1;
                while(b && k >=0 ) {
                    if ( m[i][j] == m[i][k]) {
                        b= false;
                    } else {
                        k--;
                    }
                }
                if(!b) {
                    x++;
                }
                j++;
            }
        }
        return x;
    }

    public static int nbCols() {
        int x =0;
        for(int i=0; i < m.length;i++){
            boolean b = true;
            int j= 0;
            while (b && j < m.length) {
                int k=j-1;
                while(b && k >=0 ) {
                    if ( m[j][i] == m[k][i]) {
                        b= false;
                    } else {
                        k--;
                    }
                }
                if(!b) {
                    x++;
                }
                j++;
            }
        }
        return x;
    }


    public static void main(String[] args) {
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = in.nextInt(), k = 0, r = 0, c = 0;
            m = new int[n][n];
            // fulfilling the matrix
            for (int j = 0; j < n; j++) {
                for (int x = 0; x < n; x++) {
                    m[j][x] = in.nextInt();
                    if (j == x) {
                        k += m[j][x];
                    }
                }
            }

            r = nbRows();
            c = nbCols();

            System.out.println("Case #" + i +": " + k + " " + r + " " + c);

        }
    }
}
