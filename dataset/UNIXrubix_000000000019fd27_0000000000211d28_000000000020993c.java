import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner file = new Scanner(System.in);
        int testCases = file.nextInt();
        
        for (int i = 0; i < testCases; i++)
        {
            int n = file.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    matrix[j][k] = file.nextInt();
                }
            }
            
            int trace = 0;
            for (int j = 0; j < n; j++)
            {
                trace += matrix[j][j];
            }
            
            int rows = 0;
            for (int j = 0; j < n; j++)
            {
                boolean[] row = new boolean[n];
                for (int k = 0; k < n; k++)
                {
                    if (row[matrix[j][k] - 1])
                    {
                        rows++;
                        break;
                    }
                    row[matrix[j][k] - 1] = true;
                }
            }
            
            int cols = 0;
            for (int j = 0; j < n; j++)
            {
                boolean[] col = new boolean[n];
                for (int k = 0; k < n; k++)
                {
                    if (col[matrix[k][j] - 1])
                    {
                        cols++;
                        break;
                    }
                    col[matrix[k][j] - 1] = true;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d\n", i + 1, trace, rows, cols);
        }
    }
}
