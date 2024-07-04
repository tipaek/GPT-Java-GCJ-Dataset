import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;


        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        /*
         360 480
         420 540
         600 660

         j-1>i-1 &&j-1==i -> c

         */
        int t=sc.nextInt();
        int m=0;
        while (t-->0)
        {
            String s=sc.next();
            int dep=0;
            String ans="";
            for (char c:s.toCharArray())
            {
                int newdep=c-'0';
                while (newdep>dep)
                {
                    dep++;
                    ans+='(';
                }
                while (newdep<dep)
                {
                    dep--;
                    ans+=')';
                }
                ans+=c;
            }
            while (dep>0)
            {
                dep--;
                ans+=')';
            }
            m++;
            System.out.println("Case #" + m+": " +ans );

        }

    }
}