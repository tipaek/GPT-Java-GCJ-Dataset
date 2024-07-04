import java.io.*;
import java.util.*;

/**
 *
 * @author User
 */
public class Solution
{

    public static String solve(Scanner in)
    {
        String answer = "";
        String possible = "POSSIBLE";
        String impossible = "IMPOSSIBLE";
        int N = in.nextInt(), K = in.nextInt();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                int pos = (i + j < N) ? i + j : i + j - N;
                matrix[i][pos] = (j + 1);
            }
        }
//        System.out.println(printArray(matrix));
//        System.out.println("Trace - " + getTrace(matrix));

        for (int i = 0; i < N - 1; i++)
        {
            for (int j = 0; j < N - 1; j++)
            {
                swap(matrix, j, j + 1);
                swapColumn(matrix, i, j);
                if (getTrace(matrix)==K)
                {
                    return possible+"\n"+printArray(matrix);
                }
//                System.out.println(printArray(matrix));
//                System.out.println("Trace - " + getTrace(matrix));
            }
        }

        //stop writing from here
        return impossible;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int rep = 0; rep < T; rep++)
        {
            String answer = solve(in);
            System.out.println("Case #" + (rep + 1) + ": " + answer);

        }
    }

    private static String printArray(int[][] matrix)
    {
        String a = "";
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                a += matrix[i][j] + " ";
            }
            a += (i != matrix.length - 1) ? "\n" : "";
        }
        return a;
    }

    private static int getTrace(int[][] matrix)
    {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static void swap(int[][] matrix, int row1, int row2)
    {
        for (int j = 0; j < matrix.length; j++)
        {
            int t = matrix[row1][j];
            matrix[row1][j] = matrix[row2][j];
            matrix[row2][j] = t;
        }
    }

    private static void swapColumn(int[][] matrix, int col1, int col2)
    {
        for (int j = 0; j < matrix.length; j++)
        {
            int t = matrix[j][col1];
            matrix[j][col1] = matrix[j][col2];
            matrix[j][col2] = t;
        }
    }
}