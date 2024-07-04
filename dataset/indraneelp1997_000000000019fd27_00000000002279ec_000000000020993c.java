import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i1 = 1;
        while(i1<=t)
        {
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j] = sc.nextInt();
                }
            }
            int row = 0;
            int col = 0;
            int sum = 0;
            Set<Integer> r = new HashSet<Integer>();
            Set<Integer> c = new HashSet<Integer>();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(i==j)
                        sum+= mat[i][j];
                    r.add(mat[i][j]);
                }
                if(r.size()!=n)
                    row+=1;
                r.clear();
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    c.add(mat[j][i]);
                }
                if(c.size()!=n)
                    col+=1;
                c.clear();
            }
            System.out.println("Case #"+i1+": "+sum+" "+row+" "+col);
            i1++;
        }
    }
}