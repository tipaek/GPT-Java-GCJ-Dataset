import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        MyScanner scan = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int tc = scan.nextInt();
        for (int ttc = 1; ttc <= tc; ttc++) {
            String input = scan.next();
            out.println("Case #" + ttc + ": " + solve(input));
        }


        out.close();
    }

    private static String solve(String input) {
        int stack = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i) - '0';
            while (stack < val) {
                sb.append('(');
                stack++;
            }
            while (stack > val) {
                sb.append(')');
                stack--;
            }
            sb.append(input.charAt(i));
        }
        while (stack > 0) {
            sb.append(')');
            stack--;
        }
        return sb.toString();
    }


    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

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
    //--------------------------------------------------------

}