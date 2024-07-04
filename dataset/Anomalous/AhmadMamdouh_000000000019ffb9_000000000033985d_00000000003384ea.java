import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        int testCases = inputReader.nextInt();
        int testCaseNumber = 1;
        
        while (testCases-- > 0) {
            long left = inputReader.nextLong();
            long right = inputReader.nextLong();
            int customer = 1;

            while (true) {
                boolean canServe = false;
                
                if (left >= right && left >= customer) {
                    left -= customer;
                    canServe = true;
                } else if (right > left && right >= customer) {
                    right -= customer;
                    canServe = true;
                }
                
                if (!canServe) {
                    break;
                }
                
                customer++;
            }
            
            System.out.printf("Case #%d: %d %d %d\n", testCaseNumber++, customer - 1, left, right);
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}