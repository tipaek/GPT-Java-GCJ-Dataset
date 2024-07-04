import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for(int p=1;p<=t;p++) {
            int n = Integer.parseInt(br.readLine());
            int[][] a = new int[n][n];
            int trace = 0, rows = 0, cols = 0;
            for(int i=0;i<n;i++) {
                String[] str = br.readLine().split(" ");
                boolean[] x = new boolean[n];
                boolean flag = true;
                for(int j=0;j<n;j++) {
                    a[i][j] = Integer.parseInt(str[j])-1;
                    if(flag && x[a[i][j]]) {
                        flag = false;
                        rows++;
                    }
                    x[a[i][j]] = true;
                }
                trace += a[i][i];
            }
            trace += n;
            for(int i=0;i<n;i++) {
                boolean[] x = new boolean[n];
                boolean flag = true;
                for(int j=0;j<n;j++) {
                    if(flag && x[a[j][i]]) {
                        flag = false;
                        cols++;
                    }
                    x[a[j][i]] = true;
                }
            }
            pw.println("Case #"+p+" "+trace+" "+rows+" "+cols);
        }
        pw.close();
        br.close();
    }
}