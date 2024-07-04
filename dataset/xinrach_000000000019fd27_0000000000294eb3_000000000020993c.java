import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= test; t++)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int [][] arr = new int [n][n];
            double tot = (1 + n) * (n / 2);
            int total = (int) tot;
            int k = 0;
            int r = 0;
            int c = 0;
            for (int i = 0; i < arr.length; i++)
            {
                int row = 0;
                for (int j = 0; j < arr.length; j++)
                {
                    arr[i][j] = br.read();
                    row += arr[i][j];
                    if (i == j)
                    {
                        k += arr[i][j];
                    }
                }
                if (row != total)
                {
                    r++;
                }
            }
            for (int i = 0; i < arr.length; i++)
            {
                int column = 0;
                for (int j = 0; j < arr.length; j++)
                {
                    column += arr[j][i];
                }
                if (column != total)
                {
                    c++;
                }
            }
            System.out.println("Case #" + t + ": "+ k + " " + r + " " + c);
        }
    }
}