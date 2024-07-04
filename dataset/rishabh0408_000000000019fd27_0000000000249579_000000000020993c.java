import java.util.Scanner;
class Vestigium //class Solution
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int k = 0;
        while(k < t)
        {
            int n = input.nextInt();
            int a[][] = new int[n][n];
            int tr = 0, rc = 0, cc = 0;
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    a[i][j] = input.nextInt();
                    if ( i == j )
                    {
                        tr = tr + a[i][j];
                    }
                }
            }
            for (int i = 0; i < n; i++)
            {
                int fr = 0, fc = 0;
                int row_r [] = new int[n];
                int column_r[] = new int[n];
                for (int j = 0; j < n; j++)
                {
                    column_r[(a[j][i]-1)] = column_r[(a[j][i]-1)] + 1;
                    if (column_r[(a[j][i]-1)] == 2 && fc == 0)
                    {
                        cc++;
                        fc++;
                    }
                    row_r[(a[i][j] - 1)] = row_r[(a[i][j] - 1)]  + 1;
                    if (row_r[(a[i][j] - 1)] == 2 && fr == 0)
                    {
                        rc++;
                        fr++;
                    }
                }
            }
            k++;
            System.out.println("Case #"+k+": "+tr+" "+rc+" "+cc);
        }
    }
}