import java.io.*;
import java.util.*;

public class Solution {
    void solve(FastReader reader, PrintStream out) {
        int t = reader.nextInt();
        for(int tc=1; tc<=t; tc++) {
            int n = reader.nextInt();
            int[][] times = new int[n][2];
            Integer[] conv = new Integer[n];
            for(int i=0; i<n; i++) {
                times[i] = new int[]{reader.nextInt(), reader.nextInt()};
                conv[i] = i;
            }
            Arrays.sort(conv, (a, b) -> {
                int diff = times[a][0]-times[b][0];
                return diff == 0 ? times[a][1]-times[b][1] : diff;
            });

            char[] res = new char[n];
            int endC=0,endJ=0;
            boolean impossible = false;
            for(int timeIdx : conv) {
                if(endC <= times[timeIdx][0]) {
                    res[timeIdx] = 'C';
                    endC = times[timeIdx][1];
                } else if(endJ <= times[timeIdx][0]) {
                    res[timeIdx] = 'J';
                    endJ = times[timeIdx][1];
                } else {
                    impossible = true;
                    break;
                }
            }
            out.println(String.format("Case #%d: %s", tc, impossible ? "IMPOSSIBLE" : new String(res)));
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
