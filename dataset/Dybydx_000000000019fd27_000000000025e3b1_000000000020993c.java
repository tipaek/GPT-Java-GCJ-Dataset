import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int x=1;
        while(t-->0)
        {
            int n=sc.nextInt();
            int ar[][]=new int[n][n];
            long sum=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    ar[i][j]=sc.nextInt();
                    if(i==j)
                    {
                        sum=sum+ar[i][j];
                    }
                }
            }
            long row=0;
            long col=0;
            int r[]=new int[n];
            int c[]=new int[n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    r[ar[i][j]-1]++;
                    if(r[ar[i][j]-1]>1)
                    {
                        row++;
                        break;
                    }
                }
                Arrays.fill(r,0);
            }
            
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    c[ar[j][i]-1]++;
                    if(c[ar[j][i]-1]>1)
                    {
                        col++;
                        break;
                    }
                }
                Arrays.fill(c,0);
            }
            System.out.println("Case #"+x+": "+sum+" "+row+" "+col);
            x++;
        }
    }
}