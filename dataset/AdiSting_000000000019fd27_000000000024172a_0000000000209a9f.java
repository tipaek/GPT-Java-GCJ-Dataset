import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public static void main(String[] args)
    {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        int cases = 1;
        StringBuffer op = new StringBuffer();
        while (t-- > 0)
        {
            String n = fr.next();
            n = n + "$";
            char chars[] = n.toCharArray();
            int num;
            StringBuffer sb = new StringBuffer();
            int current = 0;
            for (char c: chars)
            {
                num = (int) c - 48;
                if (num == 0)
                {
                    for (int i=0;i<(current);i++)
                        sb.append(')');
                    sb.append(0);
                    current = 0;
                }
                else if (num > current)
                {
                    for (int i=0;i<(num - current);i++)
                        sb.append('(');
                    sb.append(num);
                    current = num;
                }
                else if (num < current && num > 0)
                {
                    for (int i=0;i<(current-num);i++)
                        sb.append(')');
                    sb.append(num);
                    current = num;
                }
                else if (num == current)
                {
                    sb.append(num);
                }
                else
                {
                    for (int i=0;i<current;i++)
                        sb.append(')');
                    current = 0;
                }



            }






            op.append("Case #"+cases+": "+sb);
            cases++;
            op.append('\n');
        }

        System.out.println(op);


    }
}
