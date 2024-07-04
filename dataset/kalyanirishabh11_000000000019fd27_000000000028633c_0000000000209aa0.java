import java.util.*;
import java.math.*;
import java.lang.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        String s=br.readLine();
        int t=Integer.valueOf(s.trim());
        for(int t1=1;t1<=t;t1++) {
            s=br.readLine();
            String[] c1=s.split(" ");
            int n=Integer.valueOf(c1[0]),
                k=Integer.valueOf(c1[1]);
            if(((k%n)!=0) || ((n==2) && (k==4)))
                pw.println("Case #"+t1+": IMPOSSIBLE");
            else {
                k/=n;
                int[][] a=new int[n][n];
                for(int i=0;i<n;i++) {
                    for(int j=0;j<n;j++) {
                        if(i==0)
                            a[i][j]=j+1;
                        else
                            a[i][j]=a[i-1][(j-1+n)%n];
                    }
                }
                for(int i=0;i<n;i++)
                    for(int j=0;j<n;j++)
                        if(a[i][j]==k)
                            a[i][j]=1;
                for(int i=0;i<n;i++)
                    a[i][i]=k;
                pw.println("Case #"+t1+": POSSIBLE");
                for(int i=0;i<n;i++) {
                    for(int j=0;j<n;j++)
                        pw.print(a[i][j]+" ");
                    pw.println();
                }
            }
        }
        pw.close();
        br.close();
    }
}