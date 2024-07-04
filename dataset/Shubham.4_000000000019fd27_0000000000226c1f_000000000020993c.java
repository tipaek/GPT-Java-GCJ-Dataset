import java.util.Scanner;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] arr;
        for(int k=1;k<=t;k++)
        {
            int n = sc.nextInt();
            arr = new int[n][n];
            boolean r[][] = new boolean[n][101];
            boolean c[][] = new boolean[n][101];
            int dsum = 0, rows = 0, cols = 0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j] = sc.nextInt();
                    if(i==j)
                    {
                        dsum += arr[i][j]; 
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                int j;
                for(j=0;j<n;j++)
                {
                    if(!r[i][arr[i][j]])
                    {
                        r[i][arr[i][j]] = true;   
                    }
                    else
                    {
                        break;
                    }
                }
                if(j != n)
                    rows++;
            }
            for(int j=0;j<n;j++)
            {
                int i;
                for(i=0;i<n;i++)
                {
                    if(!c[j][arr[i][j]])
                    {
                        c[j][arr[i][j]] = true;   
                    }
                    else
                    {
                        break;
                    }
                }
                if(i != n)
                    cols++;
            }
            System.out.println("Case #"+ k +": "+dsum+" "+rows+" "+cols);
        }
    }
}