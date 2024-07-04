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
            if((k%n)!=0)
                pw.println("Case #"+t1+": IMPOSSIBLE");
            else {
                HashSet<Integer>[] row=new HashSet[n];
                HashSet<Integer>[] col=new HashSet[n];
                for(int i=0;i<n;i++) {
                    row[i]=new HashSet<>();
                    col[i]=new HashSet<>();
                }
                int[][] a=new int[n][n];
                k/=n;
                for(int i=0;i<n;i++) {
                    a[i][i]=k;
                    row[i].add(k);
                    col[i].add(k);
                }
                int ct=1;
                for(int r=0;r<n;r++) {
                    for(int x=1;x<=n;x++) {
                        if(row[r].contains(x))
                            continue;
                        for(int c=0;c<n;c++) {
                            if(r==c)
                                continue;
                            if(col[c].contains(x))
                                continue;
                            if(a[r][c]!=0)
                                continue;
                            a[r][c]=x;
                            col[c].add(x);
                            break;
                        }
                        row[r].add(x);
                    }
                }
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