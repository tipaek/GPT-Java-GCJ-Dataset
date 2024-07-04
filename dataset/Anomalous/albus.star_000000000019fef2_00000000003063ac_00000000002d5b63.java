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
            solve(input, pw, A, B);
        }
        
        pw.close();
    }

    public static void solve(CustomScanner input, PrintWriter pw, int A, int B) throws IOException {
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                System.out.println(i + " " + j);
                System.out.flush();
                String response = input.next();
                if (response.equals("CENTER")) {
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
        private StringTokenizer stringTokenizer;

        public CustomScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            ensureTokenizer();
            return Integer.parseInt(stringTokenizer.nextToken());
        }

        public long nextLong() throws IOException {
            ensureTokenizer();
            return Long.parseLong(stringTokenizer.nextToken());
        }

        public String next() throws IOException {
            ensureTokenizer();
            return stringTokenizer.nextToken();
        }

        private void ensureTokenizer() throws IOException {
            if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            }
        }
    }
}