


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();
            boolean hs[] = new boolean[n+1];
            int a[][] = new int[n][n];
            int ans = 0;
            int rc = 0;
            int cc = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j] = in.nextInt();
                    if(i==j){
                        ans+=a[i][j];
                    }
                }
            }
            for(int i=0;i<n;i++){
                hs = new boolean[n+1];
                for(int j=0;j<n;j++){
                    if(hs[a[i][j]]){
                        rc++;
                        break;
                    }
                    else {
                        hs[a[i][j]] = true;
                    }
                }
            }
            for(int i=0;i<n;i++){
                hs = new boolean[n+1];
                for(int j=0;j<n;j++){
                    if(hs[a[j][i]]){
                        cc++;
                        break;
                    }
                    else {
                        hs[a[j][i]] = true;
                    }
                }
            }
            System.out.println("Case #" + tt + ": " +ans + " " + rc + " " + cc);
        }
    }
}

