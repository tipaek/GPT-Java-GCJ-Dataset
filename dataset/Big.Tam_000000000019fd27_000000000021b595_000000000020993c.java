import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] grid = new int[n][n];
            int sum = 0;

            for(int j = 1; j <= n; j++)
            {
                for(int k = 1; k <= n; k++)
                {
                    int curr = in.nextInt();
                    grid[j - 1][k - 1] = curr;
                    if(j == k)
                    {
                        sum += curr;
                    }
                }
            }
            int rowNum = 0, colNum = 0;
            for(int j = 0; j < n; j++)
            {
                Set<Integer> set = new HashSet<>();
                a:
                for(int k = 0; k < n; k++)
                {
                    if(!set.add(grid[j][k]))
                    {
                        rowNum++;
                        break a;
                    }
                }
            }
            for(int j = 0; j < n; j++)
            {
                Set<Integer> set = new HashSet<>();
                a:
                for(int k = 0; k < n; k++)
                {
                    if(!set.add(grid[k][j]))
                    {
                        colNum++;
                        break a;
                    }
                }
            }


            System.out.println("Case #" + i + ": " + sum + " " + rowNum + " " + colNum);
        }
    }
}