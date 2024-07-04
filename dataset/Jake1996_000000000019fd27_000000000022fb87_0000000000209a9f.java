
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int tc = in.nextInt();
        int temp = tc;
        while (tc-- != 0) {
            String n = in.nextLine();
            String output = "";
            int balance = 0;
            for (int i = 0; i < n.length(); i++) {
                int number = n.charAt(i) - 48;
                if (number > balance) {
                    output += new String(new char[number - balance]).replace("\0", "(");
                } else if (number < balance) {
                    output += new String(new char[balance - number]).replace("\0", ")");
                }
                balance = number;
                output += number;
            }
            if (balance > 0)
                output += new String(new char[balance]).replace("\0", ")");
            System.out.println("Case #" + (temp - tc) + ": " + output);
        }
        in.close();
    }

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

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
