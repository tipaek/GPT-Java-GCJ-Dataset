import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution
{
    static class FastReader
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
    public static void main(String[] args)
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int cases = 1;
        StringBuffer op = new StringBuffer();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            for (int i=0; i<n; i++)         // input matrix
            {
                for (int j=0; j<n; j++)
                {
                    mat[i][j] = sc.nextInt();
                }
            }

            int k = 0;

            for (int i=0,j=0; i<n && j<n; i++,j++ )
            {
                k+=mat[i][j];
            }

            int r=0,c=0;

            for (int i=0; i<n; i++)
            {
                Map<Integer,Integer> map = new HashMap<>();
                for (int j=0; j<n; j++)
                {
                    int key = mat[i][j];
                    if(map.containsKey(key))
                    {
                        int count = map.get(key);
                        map.put(key,++count);
                    }
                    else
                    {
                        map.put(key,1);
                    }
                }
                for (int v: map.values())
                {
                    if (v > 1)
                    {
                        r++;
                        break;
                    }

                }
            }

            for (int i=0; i<n; i++)
            {
                Map<Integer,Integer> map = new HashMap<>();
                for (int j=0; j<n; j++)
                {
                    int key = mat[j][i];
                    if(map.containsKey(key))
                    {
                        int count = map.get(key);
                        map.put(key,++count);
                    }
                    else
                    {
                        map.put(key,1);
                    }
                }
                for (int v: map.values())
                {
                    if (v > 1)
                    {
                        c++;
                        break;
                    }

                }
            }



            op.append("Case #"+cases+": "+k+" "+r+" "+c);
            cases++;
            op.append('\n');

        }
        System.out.println(op);

    }
}
