import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        for (int test = 1; test <= testCount; test++)
        {
            System.out.print("Case #" + test + ": ");
            
            int n = in.nextInt();
            int k = in.nextInt();
            boolean done = false;
            for (int i = 1; i <=n; i++)
            {
                if (k == i * n)
                {
                    done = true;
                    System.out.println("POSSIBLE");
                    int[][] square = new int[n][n];
                    for (int j = n; j > 0; j--)
                        square[0][j-1] = j;
                    while(square[0][0] != i)
                        square[0] = shiftL(square[0]);
                    
                    for (int j = 1; j < n; j++)
                        square[j] = shiftR(square[j-1]);
                    
                    print(square);
                    break;
                }
            }
            
            int sum = 0;
            for (int i = 1; i <= n; i++)
                sum += i;
            if (done)
                sum = sum;
            else if (k == sum && n != 2)
            {
                System.out.println("POSSIBLE");
                int[][] square = new int[n][n];
                for (int i = 1; i <= n; i++)
                    square[0][i-1] = i;
                for (int i = 1; i < n; i++)
                {
                    square[i] = shiftL(square[i-1]);
                }
                print(square);
            }
            else
                System.out.println("IMPOSSIBLE");
        }
        
        in.close();
    }
    
    public static int[] shiftR(int[] row)
    {
        int[] shifted = new int[row.length];
        shifted[0] = row[shifted.length-1];
        for (int i = 1; i < row.length; i++)
        {
            shifted[i] = row[i-1];
        }
        return shifted;
    }
    
    public static int[] shiftL(int[] row)
    {
        int[] shifted = new int[row.length];
        shifted[shifted.length-1] = row[0];
        for (int i = 0; i < row.length-1; i++)
        {
            shifted[i] = row[i+1];
        }
        return shifted;
    }
    
    public static void print(int[][] square)
    {
        for (int i = 0; i < square.length; i++)
        {
            for (int j = 0; j < square.length; j++)
                System.out.print(square[i][j] + " ");
            System.out.println();
        }
    }
}