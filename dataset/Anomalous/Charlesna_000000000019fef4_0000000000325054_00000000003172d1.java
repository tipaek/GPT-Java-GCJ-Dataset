import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = (int) in.nextLong();
        
        for (int i = 1; i <= testCases; i++) {
            int N = (int) in.nextLong();
            int D = (int) in.nextLong();
            long[] arr = new long[N];
            
            for (int j = 0; j < N; j++) {
                arr[j] = in.nextLong();
            }
            
            processTestCase(N, D, arr, i, out);
        }
        
        out.flush();
        out.close();
    }

    private void processTestCase(int N, int D, long[] arr, int testCaseNumber, PrintWriter out) {
        Map<Long, List<Long>> factorsMap = new HashMap<>();
        
        for (long num : arr) {
            boolean isPrime = true;
            
            for (long i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    factorsMap.computeIfAbsent(i, k -> new ArrayList<>()).add(num);
                }
            }
            
            if (isPrime) {
                factorsMap.computeIfAbsent(num, k -> new ArrayList<>()).add(num);
            }
        }
        
        int result = D - 1;
        
        for (long key : factorsMap.keySet()) {
            result = Math.min(result, calculateMinimumOperations(key, factorsMap.get(key), D));
        }
        
        out.println("Case #" + testCaseNumber + ": " + result);
    }

    private int calculateMinimumOperations(long factor, List<Long> numbers, int D) {
        long[] dividedNumbers = new long[numbers.size()];
        int result = D - 1;
        long sum = 0;
        
        for (int i = 0; i < dividedNumbers.length; i++) {
            dividedNumbers[i] = numbers.get(i) / factor;
            sum += dividedNumbers[i];
        }

        if (sum < D) {
            for (int i = 0; i < dividedNumbers.length; i++) {
                dividedNumbers[i] *= (D / sum + 1);
            }
        }

        int[] dp = new int[D + 1];
        
        for (long num : dividedNumbers) {
            if (num > D) continue;
            for (int j = D; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - (int) num] + 1);
            }
        }
        
        for (int k = D; k >= 1; k--) {
            result = Math.min(result, D - dp[k] + (D - k));
        }

        for (long num : numbers) {
            result = Math.min(result, calculate(num, numbers, D));
        }
        
        return result;
    }

    private int calculate(long num, List<Long> numbers, int D) {
        List<Long> dividedNumbers = new ArrayList<>();
        long sum = 0;
        
        for (long number : numbers) {
            sum += number / num;
            if (number < num || number % num != 0) continue;
            dividedNumbers.add(number / num);
        }

        if (sum < D) {
            for (int i = 0; i < dividedNumbers.size(); i++) {
                dividedNumbers.set(i, (D / sum + 1) * dividedNumbers.get(i));
            }
        }

        int result = D - 1;
        int[] dp = new int[D + 1];
        
        for (long number : dividedNumbers) {
            if (number > D) continue;
            for (int j = D; j >= number; j--) {
                dp[j] = Math.max(dp[j], dp[(int) (j - number)] + 1);
            }
        }
        
        for (int k = D; k >= 1; k--) {
            result = Math.min(result, D - dp[k] + (D - k));
        }
        
        return result;
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buffer[currentChar++];
        }

        public String nextLine() {
            String line = "";
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            double result = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') return result * Math.pow(10, nextInt());
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') return result * Math.pow(10, nextInt());
                    if (c < '0' || c > '9') throw new InputMismatchException();
                    m /= 10;
                    result += (c - '0') * m;
                    c = read();
                }
            }
            return result * sign;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }
}