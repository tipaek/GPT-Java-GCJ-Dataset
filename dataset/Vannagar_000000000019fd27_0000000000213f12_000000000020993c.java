import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=1;x<=t;x++)
        {
            int n=sc.nextInt();
            int[][] a=new int[n][n];
            for(int r=0;r<n;r++)
            {
                for(int c=0;c<n;c++)
                {a[r][c]=sc.nextInt();}
            }
            int k=0;
            for(int rc=0;rc<n;rc++)
            {k+=a[rc][rc];}
            int ro=0;
            for(int r=0;r<n;r++)
            {
                boolean[]ar=new boolean[n+1];
                for(int c=0;c<n;c++)
                {
                    if(ar[a[r][c]]){ro++;break;}
                    else{ar[a[r][c]]=true;}
                }
            }
            int co=0;
            for(int r=0;r<n;r++)
            {
                boolean[]ar=new boolean[n+1];
                for(int c=0;c<n;c++)
                {
                    if(ar[a[c][r]]){co++;break;}
                    else{ar[a[c][r]]=true;}
                }
            }
            System.out.println("Case #"+x+": "+k+" "+ro+" "+co);
        }
    }
}