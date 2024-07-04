/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class compiler {
    public static void main(String args[]) {
      //  System.out.println("entre the number of test cases");
        int t = 0;
        FastReader sc = new FastReader();
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            //System.out.println("enter the value of n");
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            //System.out.println("enter the values of array");
            int trace = 0;
            int county = 0;
            int countx = 0;
            boolean x1[]=new boolean[n];
            for (int x = 0; x < n; x++) {
                boolean j[] = new boolean[n];
                for (int y = 0; y < n; y++) {
                    a[x][y] = sc.nextInt();
                    if (j[a[x][y]-1]) {
                        if(!x1[x]) {
                            x1[x]=true;
                            countx++;
                        }
                        //System.out.println("countx:"+countx);
                    } else {
                        j[a[x][y]-1] = true;
                    }
                    if (x == y) {
                        trace += a[x][y];
                    }
                }
            }
            boolean y1[]=new boolean[n];
            for (int x = 0; x < n; x++) {
                boolean j[] = new boolean[n];
                for (int y = 0; y < n; y++) {
                    if (j[a[y][x]-1]) {
                        if(!y1[x]) {
                            county++;
                            y1[x]=true;
                        }
                        //System.out.println("county="+county);
                    } else {
                        j[a[y][x]-1] = true;
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + countx + " " + county);
        }
    }
}
class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}

