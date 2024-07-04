import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int trace=0,rows=0,cols=0;
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    a[j][k] = sc.nextInt();
                }
            }
            for(int j=0;j<n;j++)
                trace=trace+a[j][j];
            for(int j=0;j<n;j++)
            {
                HashSet<Integer> hs1 = new HashSet<Integer>();
                HashSet<Integer> hs2 = new HashSet<Integer>();
                for(int k=0;k<n;k++)
                {
                    int value = a[j][k];
                    hs2.add(value);
                    int valu1 = a[k][j];
                    hs1.add(valu1);
                }
                if(hs2.size()!=n)
                    rows++;
                if(hs1.size()!=n)
                    cols++;
            }
            System.out.println("Case #"+i+": "+trace+" "+rows+" "+cols);
        }
    }
}