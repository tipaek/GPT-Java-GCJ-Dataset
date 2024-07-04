import java.io.IOException;
import java.util.Scanner;

public class vestigium
{
    public static void main (String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());

        for (int i = 0; i < t; i++)
        {
            int n = in.nextInt();
            int [][] matrix = new int[n][n];
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    matrix [j][k] = in.nextInt();
            compute(matrix, i+1);
        }
    }

    private static void compute(int[][] matrix, int caseNum)
    {
       int k = 0, r = 0, c = 0;
       int n = matrix.length;

       for (int i = 0; i < n; i++)
       {
           boolean [] seen = new boolean[n+1];
           for (int j = 0; j < n; j++)
           {
               int num = matrix[i][j];
               if (seen[num])
               {
                   r++;
                   break;
               }

               seen[num] = true;
           }
       }

        for (int i = 0; i < n; i++)
        {
            boolean [] seen = new boolean[n+1];
            for (int j = 0; j < n; j++)
            {
                int num = matrix[j][i];
                if (seen[num])
                {
                    c++;
                    break;
                }

                seen[num] = true;
            }
        }

        for (int i = 0; i < n; i++)
            k += matrix[i][i];

       System.out.println("Case #" + caseNum + ": " + k + " " + r + " " + c);
    }
}
