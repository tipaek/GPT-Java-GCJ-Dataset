
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        int t,test=0;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        while (test++ <t) {
            int n, trace = 0, row = 0, col = 0;
            n = in.nextInt();


            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++) {
                int[] r = new int[n+1];
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.nextInt();
                    if (i == j) trace += a[i][j];
                    //hash ele in r and c
                    ++r[a[i][j]];
                }
                for (int x = 1; x <= n; x++) {
                    if (r[x] > 1) {row++;break;}
                }
            }


            for (int i = 0; i < n; i++) {
                int[] c = new int[n+1];
                for (int j = 0; j < n; j++)  ++c[a[j][i]];

                for (int x = 1; x <= n; x++) {
                    if (c[x] > 1) {col++;break;}
                }
            }
 
            System.out.println("Case #"+test+":"+" "+trace+" "+row+" "+col);
        }
    }
}
