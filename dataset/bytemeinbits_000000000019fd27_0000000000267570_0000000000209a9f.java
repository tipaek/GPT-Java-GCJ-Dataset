import java.io.*;
import java.util.*;

public class Solution {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException  e) {
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
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        int test = 0;
        while(++test <= t) {
            String s = fr.nextLine();
            String res = "";
            boolean isleft = false;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '1' && !isleft) {
                        res += '(';
                        isleft = true;
                } else if(c == '0' && isleft ) {
                    res += ')';
                    isleft = false;
                }
                res += c;
            }

            if(s.charAt(s.length()-1) == '1' && isleft) res += ')';

            System.out.println("Case #" + test + ": " + res);
        }


    }
}