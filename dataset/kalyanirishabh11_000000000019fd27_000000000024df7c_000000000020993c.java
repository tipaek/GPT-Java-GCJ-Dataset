import java.util.*;
import java.math.*;
import java.lang.*;
import java.io.*;
public class Main {
    static int[][] transpose(int[][] a) {
        int n=a.length;
        int[][] ans=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                ans[i][j]=a[j][i];
        return ans;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++) {
            int n=sc.nextInt();
            int[][] a=new int[n][n];
            int k=0,r1=0,c1=0;
            for(int r=0;r<n;r++)
                for(int c=0;c<n;c++)
                    a[r][c]=sc.nextInt();
            for(int r=0;r<n;r++)
                k+=a[r][r];
            for(int r=0;r<n;r++) {
                HashSet<Integer> hs=new HashSet<>();
                for(int c=0;c<n;c++)
                    hs.add(a[r][c]);
                if(hs.size()!=n)
                    r1++;
            }
            a=transpose(a);
            for(int r=0;r<n;r++) {
                HashSet<Integer> hs=new HashSet<>();
                for(int c=0;c<n;c++)
                    hs.add(a[r][c]);
                if(hs.size()!=n)
                    c1++;
            }
            pw.println("Case #"+i+": "+k+" "+r1+" "+c1);
        }
        pw.close();
    }
}