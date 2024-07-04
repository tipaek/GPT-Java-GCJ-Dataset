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
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            if (x == 0 && y == 0) {
                pw.println("Case #" + t + ": " + 0);
            } else {
                boolean possible = false;
                for (int i=1; i<=s.length(); i++) {
                    char cur = s.charAt(i-1);
                    if (cur == 'N') {
                        y++;
                    } else if (cur == 'S') {
                        y--;
                    } else if (cur == 'E') {
                        x++;
                    } else {
                        x--;
                    }
                    if (Math.abs(x) + Math.abs(y) <= i) {
                        pw.println("Case #" + t + ": " + i);
                        possible = true;
                        break;
                    }
                }
                if (!possible) {
                    pw.println("Case #" + t + ": IMPOSSIBLE");
                }
            }
        }
    }

    static void addX(StringBuilder sb, boolean xNeg) {
        if (xNeg) {
            sb.append("W");
        } else {
            sb.append("E");
        }
    }

    static void addY(StringBuilder sb, boolean yNeg) {
        if (yNeg) {
            sb.append("S");
        } else {
            sb.append("N");
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
