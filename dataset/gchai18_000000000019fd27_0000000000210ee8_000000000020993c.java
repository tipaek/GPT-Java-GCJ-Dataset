import java.util.*;
import java.io.*;


public class Solution
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(f.readLine());
        for (int j=1; j<=t; j++) {
            int n = Integer.parseInt(f.readLine());
            int[][] m = new int[n][n];
            int r = 0;
            for (int i=0; i<n; i++)
            {
                StringTokenizer st = new StringTokenizer(f.readLine());
                boolean[] b = new boolean[n+1];
                boolean bo = false;
                for (int k=0; k<n; k++)
                {
                    m[i][k] = Integer.parseInt(st.nextToken());
                    if (b[m[i][k]])
                    {
                        bo = true;
                    }
                    b[m[i][k]]= true;
                }
                if (bo) r++;
            }

            int c = 0;
            for (int i=0; i<n; i++)
            {
                boolean[] b = new boolean[n+1];
                boolean bo = false;
                for (int k=0; k<n; k++)
                {
                    if (b[m[k][i]])
                    {
                        bo = true;
                    }
                    b[m[k][i]]= true;
                }
                if (bo) c++;
            }
            int trace = 0;
            for (int i=0; i<n; i++)
            {
                trace+=m[i][i];
            }


            System.out.println("Case #" + j + ": " + trace + " " + r + " " + c);
        }
    }
}