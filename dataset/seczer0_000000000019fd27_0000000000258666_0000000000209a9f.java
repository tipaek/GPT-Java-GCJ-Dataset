import java.io.*;
import java.util.*;

public class Solution {
    void solve(FastReader reader, PrintStream out) {
        int t = reader.nextInt();
        for(int tc=1; tc<=t; tc++) {
            String s = reader.nextLine();
            StringBuilder sb = new StringBuilder();
            int open = 0;
            for(char c : s.toCharArray()) {
                int num = c-'0';
                while(open < num) {
                    sb.append('(');
                    open++;
                }
                while(num < open) {
                    sb.append(')');
                    open--;
                }
                sb.append(num);
            }
            while(open--> 0)
                sb.append(')');

            out.println(String.format("Case #%d: %s", tc, sb.toString()));
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();

        new Solution().solve(reader, System.out);

        reader.close();
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    public FastReader(String filename) {
        try {
            br = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FastReader(File outFile) {
        try {
            br = new BufferedReader(new FileReader(outFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String next()
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

    public int nextInt()
    {
        return Integer.parseInt(next());
    }

    public long nextLong()
    {
        return Long.parseLong(next());
    }

    public double nextDouble()
    {
        return Double.parseDouble(next());
    }

    public String nextLine()
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

    public void close() {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}