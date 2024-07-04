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
            for (int i = 0; i < n; i++) {
                for (int j = d; j > 0; j--) {
                    f[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = d; j> 0; j--) {
                        if (a[k] >= a[i]) {
                            if (a[k] % a[i] == 0) {
                                if (a[k]/a[i]<=j){
                                    int v = (int)(a[k]/a[i]);
                                    if (f[i][j-v]!=Integer.MAX_VALUE){
                                        f[i][j] = Math.min(f[i][j], f[i][j-v]+ v-1);

                                    }
                                }
                            }
                        }
                    }
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int i =0;i<n;i++){
                ans =  Math.min(ans, f[i][d]);
            }
            System.out.println(String.format(PATTEN, p, Math.min(ans, d-1)));
        }
    }


}