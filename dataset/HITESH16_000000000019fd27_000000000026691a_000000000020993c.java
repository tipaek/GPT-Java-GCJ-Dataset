import java.util.*;
import java.lang.*;
import java.io.*;

class Codejam
{
    public static void main(String args[]) throws java.lang.Exception
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n = s.nextInt();
            int[][] matrix = new int[n+1][n+1];
            int trace=0;
            int inp=0;
            int r=0,c=0;
            for(int j=1;j<=n;j++)
            {
                boolean[] row = new boolean[n+1];
                int check=0;
                for(int k=1;k<=n;k++)
                {
                    inp = s.nextInt();
                    matrix[j][k]=inp;
                    if(row[inp]==true && check==0)
                    {
                        r++;
                        check=1;
                    }
                    row[inp]=true;
                    if(j==k)
                    {
                        trace+=inp;
                    }
                }
            }
            
            for(int j=1;j<=n;j++)
            {
                boolean[] column = new boolean[n+1];
                int check=0;
                for(int k=1;k<=n;k++)
                {
                    int inpu = matrix[k][j];
                    if(column[inpu]==true && check==0)
                    {
                        c++;
                        check=1;
                    }
                    column[inpu]=true;
                }
                
            }
            
            System.out.println("Case #"+i+": "+trace+" "+r+" "+c);
        }
    }
}