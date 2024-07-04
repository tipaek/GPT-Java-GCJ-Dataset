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
            int[][] square = new int[n][n];
            
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    square[i][j] = in.nextInt();
            
            int k = 0;
            for (int i = 0; i < n; i++)
                k += square[i][i];
            System.out.print(k + " ");    
            
            int r = 0;
            int[] check = new int[n];
            for (int row = 0; row < n; row++)
            {
                for (int col = 0; col < n; col++)
                {
                    if (check[square[row][col]-1] == 1)
                    {
                        r++;
                        break;
                    }
                    else
                    {
                        check[square[row][col]-1] = 1;
                    }
                }
                check = new int[n];
            }
            System.out.print(r + " ");
            
            int c = 0;
            for (int col = 0; col < n; col++)
            {
                for (int row = 0; row < n; row++)
                {
                    if (check[square[row][col]-1] == 1)
                    {
                        c++;
                        break;
                    }
                    else
                    {
                        check[square[row][col]-1] = 1;
                    }
                }
                check = new int[n];
            }
            System.out.println(c);
        }
        
        in.close();
        
    }
}

