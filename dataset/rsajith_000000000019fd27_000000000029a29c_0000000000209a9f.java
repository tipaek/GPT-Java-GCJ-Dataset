
import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String [] args)
    {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        for (int p = 1; p <= t; p++) {
            String s = sc.next();
            int [] a = new int [s.length()]; int n = s.length();
            for (int i = 0; i <s.length(); i++) {
                a[i] = Integer.parseInt(s.substring(i, i+1));
            }
            String res = "" + a[0];
            for (int i = 0; i < a[0]; i++) {
                res = "(" + res;
            }
            int cur = a[0]; int pos = 1;
            while (pos < n) {
                int dif = a[pos] - cur;
                if (dif < 0) {
                    for (int i = 0; i < -dif; i++) {
                        res += ")";
                    }
                } else if (dif > 0) {
                    for (int i = 0; i < dif; i++) {
                        res += "(";
                    }
                }
                res += a[pos];
                cur = a[pos];
                pos++;
            }
            for (int i = 0; i < cur; i++) {
                res += ")";
            }
            out.println("Case #" + p + ": " + res);
        }

        out.close();
    }

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }



    }

}