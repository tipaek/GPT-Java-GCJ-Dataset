import javax.swing.*;
import java.io.*;
import java.util.*;
import java.math.*;

import static java.util.Comparator.*;


public class Main {
    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int t=s.nextInt();

        for(int c=1;c<=t;c++)
        {
            int n=s.nextInt();
            int[][] arr=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=s.nextInt();
                }
            }
            int trace=0;
            for(int i=0;i<n;i++)
            {
                trace+=arr[i][i];
            }

            int r=0,co=0;
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> set=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(set.contains(arr[i][j]))
                    {
                        r++;
                        break;
                    }
                    else
                    {
                        set.add(arr[i][j]);
                    }
                }
            }

            for(int i=0;i<n;i++)
            {
                HashSet<Integer> set=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(set.contains(arr[j][i]))
                    {
                        co++;
                        break;
                    }
                    else
                    {
                        set.add(arr[j][i]);
                    }
                }
            }
            System.out.println("Case #"+c+": "+trace+" "+r+" "+co);
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
            catch (IOException  e)
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