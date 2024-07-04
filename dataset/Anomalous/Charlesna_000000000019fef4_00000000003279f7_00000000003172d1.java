import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = (int) in.nextLong();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = (int) in.nextLong();
            int D = (int) in.nextLong();
            long[] arr = new long[N];
            for (int j = 0; j < N; j++) {
                arr[j] = in.nextLong();
            }
            processTestCase(N, D, arr, testCase, out);
        }
        out.flush();
        out.close();
    }
    
    private static void processTestCase(int N, int D, long[] arr, int testCase, PrintWriter out) {
        int result = D - 1;
        Map<Long, Integer> frequencyMap = new HashMap<>();
        
        for (long num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        if (D == 2) {
            if (N == 1) {
                out.println("Case #" + testCase + ": 1");
                return;
            }
            for (int count : frequencyMap.values()) {
                if (count >= 2) {
                    out.println("Case #" + testCase + ": 0");
                    return;
                }
            }
        } else {
            if (N == 1) {
                out.println("Case #" + testCase + ": 2");
                return;
            }
            for (int count : frequencyMap.values()) {
                if (count >= 3) {
                    out.println("Case #" + testCase + ": 0");
                    return;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j] * 2 || arr[j] == arr[i] * 2) {
                        out.println("Case #" + testCase + ": 1");
                        return;
                    }
                }
            }
        }
        
        out.println("Case #" + testCase + ": " + result);
    }
    
    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
        
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }
        
        public String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }
        
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }
        
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }
}