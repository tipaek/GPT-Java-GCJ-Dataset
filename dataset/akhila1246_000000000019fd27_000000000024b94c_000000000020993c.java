import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=1;q<=t;q++)
        {
            int n=sc.nextInt();
            int[][] a=new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(i==j)
                    trace=trace+a[i][j];
                }
            }
           // boolean[] b=new [n];
           int row=0,column=0;
            for(int i=0;i<n;i++)
            {
                 boolean[] b=new boolean[n];
                for(int j=0;j<n;j++)
                {
                    if(b[a[i][j]-1]==true)
                    {
                    row++;
                    break;
                    }
                    //else
                    b[a[i][j]-1]=true;
                }
            }
            for(int i=0;i<n;i++)
            {
                boolean[] b=new boolean[n];
                for(int j=0;j<n;j++)
                {
                    if(b[a[j][i]-1]==true)
                    {
                        column++;
                        break;
                    }
                    b[a[j][i]-1]=true;
                }
            }
            System.out.println("Case #"+q+": "+trace+" "+row+" "+column);
        }
    }
}