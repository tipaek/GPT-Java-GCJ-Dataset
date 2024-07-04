import java.util.*;
public class Codejam
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =1;i<=t;i++)
        {
            int n = sc.nextInt();
            int ar[][] = new int[n][n];
            int s = 0;
            int co = 0;
            int cr = 0;
            int sum = 0;
            for(int j =0;j<n;j++)
            {
                for(int k =0;k<n;k++)
                {
                    ar[j][k] = sc.nextInt();
                    if(j==k)
                    s = s + ar[j][k];
                    sum = sum + ar[j][k];
                }
                if(sum != ((n*(n+1))/2))
                cr++;
                sum = 0;
            }
            for(int j =0;j<n;j++)
            {
                for(int k =0;k<n;k++)
                {
                    sum = sum + ar[k][j];
                }
                if(sum != ((n*(n+1))/2))
                co++;
                sum = 0;
            }
            System.out.println("Case #"+i+": "+s+" "+cr+" "+co);
            
            
        }
    }
}