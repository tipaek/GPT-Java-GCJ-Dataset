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
            else if(n<=4) {
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
            else if(n==5) {
                k/=n;
                int[][] a=new int[n][n];
                a[0][0]=1; a[0][1]=2; a[0][2]=3; a[0][3]=4; a[0][4]=5;
                a[1][0]=5; a[1][1]=1; a[1][2]=2; a[1][3]=3; a[1][4]=4;
                a[2][0]=4; a[2][1]=5; a[2][2]=1; a[2][3]=2; a[2][4]=3;
                a[3][0]=3; a[3][1]=4; a[3][2]=5; a[3][3]=1; a[3][4]=2;
                a[4][0]=2; a[4][1]=3; a[4][2]=4; a[4][3]=5; a[4][4]=1;
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