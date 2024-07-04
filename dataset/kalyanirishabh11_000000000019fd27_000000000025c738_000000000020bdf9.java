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
            int n=Integer.valueOf(s.trim());
            int[][] a=new int[n][3];
            for(int i=0;i<n;i++) {
                s=br.readLine();
                String[] c=s.split(" ");
                a[i][0]=Integer.valueOf(c[0]);
                a[i][1]=Integer.valueOf(c[1]);
                a[i][2]=i;
            }
            Arrays.sort(a, new Comparator<int[]>(){
                public int compare(int[] x, int[] y) {
                    return ((x[0]==y[0]) ? (x[1]-y[1]) : (x[0]-y[0]));
                }
            });
            char[] c=new char[n];
            c[a[0][2]]='C';
            int c1=0,j1=-1;
            boolean possible=true;
            for(int i=1;i<n;i++) {
                if(a[c1][1]<=a[i][0]) {
                    c[a[i][2]]='C';
                    c1=i;
                }
                else if(j1<0) {
                    c[a[i][2]]='J';
                    j1=i;
                }
                else if(a[j1][1]<=a[i][0]) {
                    c[a[i][2]]='J';
                    j1=i;
                }
                else {
                    possible=false;
                    break;
                }
            }
            String ans=new String(c);
            if(!possible)
                ans="IMPOSSIBLE";
            pw.println("Case #"+t1+": "+ans);
        }
        pw.close();
        br.close();
    }
}