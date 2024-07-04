import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        CustomScanner input = new CustomScanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCaseCount = input.nextInt();
        int A = input.nextInt();
        int B = input.nextInt();
        
        for (int testNumber = 1; testNumber <= testCaseCount; testNumber++) {
            pw.print("Case #" + testNumber + ": ");
            solve(input, pw, A, B);
            pw.println();
        }
        
        pw.close();
    }

    public static void solve(CustomScanner input, PrintWriter pw, int A, int B) throws IOException {
        for (int i = -50; i <= 50; i++) {
            for (int j = -50; j <= 50; j++) {
                System.out.println(i + " " + j);
                System.out.flush();
                String response = input.next();
                if ("CENTER".equals(response)) {
                    return;
                }
            }
        }
    }

    public static int[] toBinary(long number) {
        int[] binaryRepresentation = new int[34];
        int index = 33;
        
        while (number > 0) {
            binaryRepresentation[index--] = (int) (number % 2);
            number /= 2;
        }
        
        return binaryRepresentation;
    }

    public static class CustomScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer tokenizer;

        public CustomScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            ensureTokenizer();
            return Integer.parseInt(tokenizer.nextToken());
        }

        public long nextLong() throws IOException {
            ensureTokenizer();
            return Long.parseLong(tokenizer.nextToken());
        }

        public String next() throws IOException {
            ensureTokenizer();
            return tokenizer.nextToken();
        }

        private void ensureTokenizer() throws IOException {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
            }
        }
    }
}