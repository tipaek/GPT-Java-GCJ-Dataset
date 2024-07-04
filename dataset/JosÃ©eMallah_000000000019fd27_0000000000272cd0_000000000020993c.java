import java.util.Scanner;

public class Solution
{
    public static void main (String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int x = 1;
        int n;
        int k = 0;
        int r = 0;
        int c = 0;
        while(x <= t)
        {
            n = in.nextInt();
            k = 0;
            int m[][] = new int[n][n];
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    m[i][j] = in.nextInt();
                }
                k = k + m[i][i];
            }
            for (int i = 0; i < n; i++)
            {
                int j = 0;
                while (j < n)
                {
                    for (int y = -j; y <= n - j; y++)
                    {
                        if (m[i][j] == m[i][j+y])
                        {
                            r++;
                            break;
                        }
                    }
                    j++;
                }
                j = 0;
                while (j < n)
                {
                    for (int y = -j; y <= n - j; y++)
                    {
                        if (m[i][j] == m[i+y][j])
                        {
                            c++;
                            break;
                        }
                    }
                    j++;
                }
            }
                
            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
            x++;
        }
    }
}