import java.io.*;
import java.util.*;
class Solution
{
    static int fact(int n)
    {
        int f = 1;
        while (n > 0)
        {
            f *= n;
            n--;
        }
        return f;
    }

    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tt = Integer.parseInt(br.readLine());

        for (int ii = 0; ii < tt; ++ii)
        {
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];           
            int col[] = new int[n];
            int colf[] = new int[n];
            int r = 0, t = 0, c = 0;
            int fact = fact(n);
            int nsum = (n * (n + 1)) / 2;

            for (int i = 0; i < n; ++i)
            {
                String str[] = br.readLine().split(" ");
                int row = 0,  rowf= 1;
                for (int j = 0; j < n; ++j)
                {
                    if (i == 0)
                        colf[j] = 1;
                    arr[i][j] = Integer.parseInt(str[j]);
                    col[j] += arr[i][j];
                    colf[j] *= arr[i][j];
                    row += arr[i][j];
                    rowf *= arr[i][j];
                }
                if (nsum == row && fact == rowf)
                {
                   ; 
                }
                else r++;
                
                
                t += arr[i][i];
            }

            for (int i = 0; i < n; ++i)
            {
                
                if (col[i] == nsum && colf[i] == fact)
                {
                    ;
                }
                else c++;
            }

            System.out.println("Case #" + (ii + 1) + ": " + t + " " + r + " " + c);
        }
    }
}

