import java.util.*;

class Solution
{
    public static void main(String args[])
    {
    Scanner v=new Scanner(System.in);
        int t=v.nextInt();
        for(int z=0;z<t;z++)
        {
          int n=v.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=v.nextInt();
                }
            }
            int trace=0;
            int row=0,col=0;
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> hs=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(i==j)
                        trace=trace+a[i][j];
                    hs.add(a[i][j]);
                }
                if(hs.size()<n)
                    row++;
            }
             for(int i=0;i<n;i++)
            {
                HashSet<Integer> hs=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    
                    hs.add(a[j][i]);
                }
                if(hs.size()<n)
                    col++;
            }
            
            System.out.println("Case"+" #"+t+": "+trace+" "+row+" "+col);
        }
    }
}