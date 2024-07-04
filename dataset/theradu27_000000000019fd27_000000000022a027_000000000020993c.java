

import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int test  = scn.nextInt(), n, sum, slin, elem, cnt1, cnt2, ok;
        int lin[] = new int[101];
        int mat[][] = new int[101][101];
        Arrays.fill(lin, 0);
        for(int k = 0; k < test; k++) {
            n= scn.nextInt();
            cnt1 = 0;
            cnt2 = 0;
            sum = 0;
            for(int i = 0; i < n; i++) {
                ok = 0;
                for(int j = 0; j < n; j++) {
                    mat[i][j] = scn.nextInt();
                    if (i == j) {
                        sum += mat[i][j];
                    }
                    lin[mat[i][j]]++;
                }
                for(int j = 1; j <= n; j++) {
                    if(lin[j] > 1) {
                        ok = 1;
                    }
                    lin[j] = 0;
                }
                if(ok == 1) {
                    cnt1++;
                }
            }
            for(int j = 0; j < n; j++) {
                ok = 0;
                for(int i = 0; i < n ; i++) {
                    lin[mat[i][j]]++;
                }
                for(int i = 1; i <= n; i++) {
                    if(lin[i] > 1) {
                        ok = 1;
                    }
                    lin[i] = 0;
                }
                if(ok == 1) {
                    cnt2++;
                }

            }
            System.out.println("Case #" + (k + 1) + ": " + sum + " " + cnt1 + " " + cnt2);
        }
    }
}