import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out), true);
        int test = sc.nextInt();
        for (int t=1; t<=test; t++) {
            pw.println("Case #" + t + ":");
            int n = sc.nextInt();
            if (n > 5) {
                int lim = n/3;
                int cur = 0;
                for (int i=1; i<=n/3; i++) {
                    pw.println(i + " 1");
                    cur++;
                }
                pw.println((lim) + " 2");
                cur += lim-1;
                pw.println((lim+1) + " 2");
                cur += lim;
                for (int i=cur; i<n; i++) {
                    pw.println((lim+1+i-cur) + " 1");
                }
            } else {
                for (int i=0; i<n; i++) {
                    pw.println((i+1) + " 1");
                }
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader(String in){
            br = new BufferedReader(
                    new InputStreamReader(new ByteArrayInputStream(in.getBytes())));
        }
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
        String next() {
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
