/**
 * Author: Rohan Arora(codiinggeek)
 */

import java.io.*;
import java.util.*;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        try {
            FastReader s = new FastReader();
            int t = s.nextInt();
            int m=1;
            while(t-->0){
                int n = s.nextInt();
                int ar[][]=new int[n][n];
                int sum = 0;
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        ar[i][j] = s.nextInt();
                        if(i==j){

                            sum += ar[i][j];
                        }
                    }
                }
                boolean usedx[] = new boolean[n+1];
                boolean usedy[] = new boolean[n+1];
                int x=0,y=0;
                int p1=0,p2=0;
                for(int i=0;i<n;i++){
                    Arrays.fill(usedx, false);
                    Arrays.fill(usedy, false);
                    p1=0;p2=0;
                    for(int j=0;j<n;j++){
                        if(!usedx[ar[i][j]]){
                            usedx[ar[i][j]]=true;
                        }else if(p1==0){
                            p1=1;
                            x++;
                        }

                        if(!usedy[ar[j][i]]){
                            usedy[ar[j][i]]=true;
                        }else if(p2==0){
                            p2=1;
                            y++;
                        }
                    }
                }
                System.out.println("Case #"+m+": "+sum+" "+x+" "+y);
                m++;
            }
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
