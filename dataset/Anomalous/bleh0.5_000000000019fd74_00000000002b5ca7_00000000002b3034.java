import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        FastReader scanner = new FastReader();
        PrintWriter output = new PrintWriter(System.out);
        Task solver = new Task();
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, scanner, output);
        }
        output.close();
    }

    static class Task {
        static final int INF = Integer.MAX_VALUE;

        public void solve(int testNumber, FastReader scanner, PrintWriter output) {
            int n = scanner.nextInt();
            StringBuilder prefix = new StringBuilder();
            StringBuilder middle = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            String result = "";

            for (int i = 0; i < n; i++) {
                String str = scanner.next();
                int length = str.length();
                int left = 0;
                int right = length - 1;

                StringBuilder currentPrefix = new StringBuilder();
                while (left < length && str.charAt(left) != '*') {
                    currentPrefix.append(str.charAt(left));
                    left++;
                }

                for (int j = 0; j < Math.min(currentPrefix.length(), prefix.length()); j++) {
                    if (prefix.charAt(j) != currentPrefix.charAt(j)) {
                        result = "*";
                    }
                }

                StringBuilder currentSuffix = new StringBuilder();
                while (right >= 0 && str.charAt(right) != '*') {
                    currentSuffix.append(str.charAt(right));
                    right--;
                }

                for (int j = 0; j < Math.min(currentSuffix.length(), suffix.length()); j++) {
                    if (suffix.charAt(j) != currentSuffix.charAt(j)) {
                        result = "*";
                    }
                }

                if (currentPrefix.length() > prefix.length()) {
                    prefix = currentPrefix;
                }
                if (currentSuffix.length() > suffix.length()) {
                    suffix = currentSuffix;
                }

                while (left < right) {
                    if (str.charAt(left) != '*') {
                        middle.append(str.charAt(left));
                    }
                    left++;
                }
            }

            if (result.isEmpty()) {
                result = prefix.toString() + middle.toString() + suffix.reverse().toString();
            }

            output.printf("Case #%d: %s%n", testNumber, result);
        }
    }

    static long binpow(long base, long exp, long mod) {
        base %= mod;
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }

    static void sort(int[] array) {
        shuffle(array);
        Arrays.sort(array);
    }

    static void sort(long[] array) {
        shuffle(array);
        Arrays.sort(array);
    }

    static class Tuple implements Comparable<Tuple> {
        int a, b;

        Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Tuple other) {
            return Integer.compare(other.b, b);
        }
    }

    static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int r = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[r];
            array[r] = temp;
        }
    }

    static void shuffle(long[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int r = random.nextInt(array.length);
            long temp = array[i];
            array[i] = array[r];
            array[r] = temp;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(fileName)));
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
}