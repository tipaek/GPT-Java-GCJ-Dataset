import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input;
        int test = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= test; t++)
        {
            int n = Integer.parseInt(br.readLine());
            int [][] arr = new int [n][n];
            int k = 0;
            int r = 0;
            int c = 0;
            for (int i = 0; i < n; i++)
            {
                input = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                {
                    arr[i][j] = Integer.parseInt(input.nextToken());
                    if (i == j)
                    {
                        k += arr[i][j];
                    }
                }
            }
            for (int i = 0; i < n; i++)
            {
                Set<Integer> s = new HashSet<>();
                for (int j = 0; j < n; j++)
                {
                    s.add(arr[i][j]);
                }
                if (n != s.size())
                {
                    r++;
                }
            }
            for (int i = 0; i < n; i++)
            {
                Set<Integer> s = new HashSet<>();
                for (int j = 0; j < n; j++)
                {
                    s.add(arr[j][i]);
                }
                if (n != s.size())
                {
                    c++;
                }
            }

            System.out.println("Case #" + t + ": "+ k + " " + r + " " + c);
        }
    }
}