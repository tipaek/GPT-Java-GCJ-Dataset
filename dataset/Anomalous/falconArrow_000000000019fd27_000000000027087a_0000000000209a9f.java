import java.io.*;
import java.util.StringTokenizer;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NDepth solver = new NDepth();
        solver.solve(1, in, out);
        out.close();
    }

    static class NDepth {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for(int i = 0; i < t; i++) {
                String str = in.next();
                int brackets = 0;
                StringBuilder res = new StringBuilder();
                for(int j = 0; j < str.length(); j++) {
                    int val = str.charAt(j) - '0';
                    if(val == brackets) {
                        res.append(str.charAt(j));
                    } else if(val > brackets) {
                        res.append(repeatChar('(', val - brackets));
                        res.append(str.charAt(j));
                        brackets = val;
                    } else {
                        res.append(repeatChar(')', brackets - val));
                        res.append(str.charAt(j));
                        brackets = val;
                    }
                }
                if(brackets > 0) res.append(repeatChar(')', brackets));
                out.println("Case #" + (i + 1) + ": " + res.toString());
            }
        }

        private String repeatChar(char ch, int count) {
            return String.join("", Collections.nCopies(count, String.valueOf(ch)));
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}