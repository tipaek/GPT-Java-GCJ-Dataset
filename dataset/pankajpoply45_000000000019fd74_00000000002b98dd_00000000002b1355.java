import java.util.*;
public class Solution {
    public static long findInterest(int[][] a)
    {
        long ans = 0L;
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                ans = ans +(long) a[i][j];
            }
        }
        return ans;
    }
    public static void update(int[][] a)
    {
        int row = a.length;
        int col = a[0].length;
        long[] rowAvg = new long[row];
        long[] colAvg = new long[col];
        int[] countRow = new int[row];
        int[] countCol = new int[col];
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                rowAvg[i] = rowAvg[i] + a[i][j];
                colAvg[j] = colAvg[j] + a[i][j];
                if(a[i][j]!=0)
                {
                    countRow[i]++;
                    countCol[j]++;
                }
            }
        }
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                if(countRow[i]!=0)
                {
                    int rowAv =(int) (rowAvg[i]/countRow[i]);
                    int x = a[i][j];
                    if(x<rowAv || (x==rowAv && (rowAvg[i]%countRow[i])!=0) )
                    {
                        a[i][j] = 0;
                    }
                }
                 if(countCol[j]!=0)
                 {
                    int colAv =(int) (colAvg[j]/countCol[j] );
                    int x = a[i][j];
                    if(x<colAv || (x==colAv && (colAvg[j]%countCol[j])!=0) )
                    {
                        a[i][j] = 0;
                    }
                 }
            }
        }
    }
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int tt=1;tt<=t;tt++)
        {
            int n = s.nextInt();
            int m = s.nextInt();
            int[][] a = new int[n][m];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    a[i][j] = s.nextInt();
                }
            }
            long ans = 0L;
            long prev = 0L;
            while(true)
            {
                long curr = findInterest(a);
                //System.out.print(curr+" ");
                if(prev==curr)
                break;
                ans = ans + curr;
                update(a);
                prev = curr;
            }
            System.out.println("Case #" +tt+": "+ ans);
        }
    }
}