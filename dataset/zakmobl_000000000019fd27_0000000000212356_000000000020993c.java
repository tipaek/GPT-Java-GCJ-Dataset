import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++)
        {
            int n = in.nextInt();
            int rows[][] = new int[n][n];
            int cols[][] = new int[n][n];
            int trace = 0;
            for (int j = 0; j < n ; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    int v = in.nextInt();
                    rows[j][v-1]++;
                    cols[k][v-1]++;
                    if (j == k)
                        trace += v;
                }
            }
            int repeatedRows = 0;
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    if (rows[j][k] != 1)
                    {
                        repeatedRows++;
                        break;
                    }
                }
            }
            int repeatedCols = 0;
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    if (cols[j][k] != 1)
                    {
                        repeatedCols++;
                        break;
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", i, trace,repeatedRows, repeatedCols);
        }
    }
}
