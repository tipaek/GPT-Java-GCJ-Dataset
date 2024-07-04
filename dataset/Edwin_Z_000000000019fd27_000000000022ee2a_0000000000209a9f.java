import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            solver.solve(i + 1, in, out);
        }
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String s = in.next();
            StringBuilder res = new StringBuilder();
            int count = 0;
            for(int i = 0; i < s.length(); i++){
                int n = s.charAt(i) - '0';
                while(n < count){
                    res.append(')');
                    count--;
                }

                while(n > count){
                    res.append('(');
                    count++;
                }

                res.append(n);
            }

            while(count > 0){
                res.append(')');
                count--;
            }

            out.println("Case #" + testNumber + ": " + res.toString());
        }
    }

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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}