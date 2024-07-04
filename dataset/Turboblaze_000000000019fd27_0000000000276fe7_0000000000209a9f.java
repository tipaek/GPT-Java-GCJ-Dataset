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
            String s = sc.next();
            int num = 0;
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<s.length(); i++) {
                int cur = Integer.parseInt(s.substring(i, i+1));
                if (num < cur) {
                    for (int j=num; j<cur; j++) {
                        sb.append("(");
                    }
                } else if (num > cur) {
                    for (int j=cur; j<num; j++) {
                        sb.append(")");
                    }
                }
                sb.append(cur);
                num = cur;
            }
            for (int i=0; i<num; i++) {
                sb.append(")");
            }
            pw.println("Case #" + t + ": " + sb.toString());
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
