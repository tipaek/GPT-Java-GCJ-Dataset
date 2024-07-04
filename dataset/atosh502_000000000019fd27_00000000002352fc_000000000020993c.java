import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Vestigium {

    public static void main(String[] args) {
        FastReader cin = new FastReader();
        int tc = cin.nextInt();
        int n;
        int[][] mat = new int[100][100];
        for (int t = 1; t <= tc; ++t) {
            n = cin.nextInt();

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    mat[i][j] = cin.nextInt();
                }
            }
            // find trace of the matix
            int k = 0;
            for (int i = 0; i < n; ++i) {
                k += mat[i][i];
            }

            int xor = 0;
            for (int i = 1; i <= n; ++i) {
                xor ^= i;
            }

            // count duplicate rows
            int r = 0, tmp;
            for (int i = 0; i < n; ++i) {
                tmp = 0;
                for (int j = 0; j < n; ++j) {
                    tmp ^= mat[i][j];
                }
                if (tmp != xor) {
                    r++;
                }
            }

            // count duplicate columns
            int c= 0;
            for (int i = 0; i < n; ++i) {
                tmp = 0;
                for (int j = 0; j < n; ++j) {
                    tmp ^= mat[j][i];
                }
                if (tmp != xor) {
                    c++;
                }
            }

            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }
    }

    // FastReader class
    // credit goes to GeeksForGeeks
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
}
