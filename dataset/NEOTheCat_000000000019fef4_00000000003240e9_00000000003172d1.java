import java.util.Scanner;

public class Solution {
     private static String PATTEN = "Case #%d: %s";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int p = 1; p <= t; p++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            int[][] f = new int[n][d+1];
            int[] g = new int[n];
//            for (int i = 0; i < n; i++) {
//                for (int j = d; j > 0; j--) {
//                    f[i][j] = Integer.MAX_VALUE;
//                }
//            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    int v = (int)(a[k]/a[i]);
                    g[i] = g[i]+ v;
                    for (int j = d; j> 0; j--) {
                        if (a[k] >= a[i]) {
                            if (a[k] % a[i] == 0) {
                                if (a[k]/a[i]<=j){
                                        f[i][j] = Math.max(f[i][j], f[i][j-v] +1);
                                }
                            }
                        }
                    }
                }
            }
            int ans = d-1;
            for (int i =0;i<n;i++){
                if (g[i]>=d){
                    ans =  Math.min(ans, d - f[i][d]);
                }
            }
            System.out.println(String.format(PATTEN, p, ans));
        }
    }


}