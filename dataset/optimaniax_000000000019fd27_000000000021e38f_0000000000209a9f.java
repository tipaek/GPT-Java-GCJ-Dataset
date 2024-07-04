//package CodeJam.Qualification2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        int t = in.NI();
        for (int z=1;z<=t;z++) {
            String q = in.next();
            int open =0;
            StringBuilder ans = new StringBuilder();
            for (int i=0;i<q.length();i++) {
                int pval = q.charAt(i)-'0';
                while(pval>open) {
                    ans.append('('); open++;
                }
                while(pval<open) {
                    ans.append(')'); open--;
                }
                ans.append(q.charAt(i));
            }
            while(open>0) {
                ans.append(')'); open--;
            }
            out.println("Case #" + z + ": " + ans.toString());
        }


        out.close();
    }

    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static InputReader in = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int NI() {
            return Integer.parseInt(next());
        }

        public long NL() {
            return Long.parseLong(next());
        }

    }
}
