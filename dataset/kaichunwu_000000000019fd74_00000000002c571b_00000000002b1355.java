import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.valueOf(in.readLine());
        for(int i = 0;i < time;++i) {
            String[] firstMultipleInput = in.readLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstMultipleInput[0]);
            int m = Integer.parseInt(firstMultipleInput[1]);
            int[][] comp = new int[n][m];
            for(int j = 0;j < n;++j) {
                String[] line = in.readLine().replaceAll("\\s+$", "").split(" ");
                for(int k = 0;k < m;++k) {
                    comp[j][k] = Integer.parseInt(line[k]);
                }
            }
            
            System.out.println("Case #"+(i+1)+": "+solve(n,m,comp));
        }
    }
    private static int solve(int n,int m,int[][] cmp) {
        int inst = 0;
        while(true) {
            // int tsinst = 0;
            boolean next = false;
            int[][] nr = new int[n][m];
            for(int i = 0;i < n;++i) {
                int sum = 0;
                int cnt = 0;
                boolean tnext = false;
                for(int j = 0;j < m;++j) {
                    if(cmp[i][j]==-1) continue;
                    sum+=cmp[i][j];
                    cnt++;
                }
                // tsinst+=sum;
                if(cnt==0) continue;
                int avg = sum/cnt;
                for(int j = 0;j < m;++j) {
                    if(cmp[i][j]==-1) continue;
                    if(cmp[i][j]<avg) {
                        if(!next) next = true;
                        nr[i][j] = -1;
                    }
                }
            }
            for(int i = 0;i < m;++i) {
                int sum = 0;
                int cnt = 0;
                for(int j = 0;j < n;++j) {
                    if(cmp[j][i]==-1) continue;
                    sum+=cmp[j][i];
                    cnt++;
                }
                // tsinst+=sum;
                if(cnt==0) continue;
                int avg = sum/cnt;
                for(int j = 0;j < n;++j) {
                    if(cmp[j][i]==-1) continue;
                    if(cmp[j][i]<avg) {
                        if(!next) next = true;
                        nr[j][i] = -1;
                    }
                }
            }
            for(int i = 0;i < n;++i) {
                for(int j = 0;j < m;++j) {
                    if(nr[i][j]!=-1) {
                        nr[i][j] = cmp[i][j];
                    }
                    if(cmp[i][j]!=-1) inst+=cmp[i][j];
                }
            }
            cmp = nr;
            // inst+=tsinst/2;
            if(!next) break;
        }
        return inst;
    }
    
}