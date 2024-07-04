import java.util.*;
import java.io.*;

public class Solution {
    private static final long REM = 1000000000L;
    private InputReader sc;
    private boolean singleTest = false;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        sc = new InputReader();
        int tests = singleTest ? 1 : sc.nextInt();
        for (int t = 1; t <= tests; t++) {
            solve(t);
        }
    }

    public void solve(int test) {
        int x = nextInt();
        int y = nextInt();
        if ((x % 2) == (y % 2)) {
            println("Case #" + test + ": IMPOSSIBLE");
            return;
        }

        int x1 = x;
        int y1 = y;
        x = Math.abs(x);
        y = Math.abs(y);
        int sum = x + y;

        int maxI = 31 - Integer.numberOfLeadingZeros(sum);
        boolean[] pos = new boolean[maxI + 1];

        for (int i = maxI; i >= 0; i--) {
            if (sum > 0) {
                pos[i] = true;
                sum -= (1 << i);
            } else if (sum < 0) {
                pos[i] = false;
                sum += (1 << i);
            } else {
                println("Case #" + test + ": IMPOSSIBLE");
                return;
            }
        }

        boolean[] horPart = new boolean[maxI + 1];
        boolean toggle = false;

        while (x > 0) {
            int msb = 31 - Integer.numberOfLeadingZeros(x);
            if (pos[msb] && !toggle) {
                horPart[msb] = true;
                x -= (1 << msb);
            } else if (!pos[msb] && !toggle) {
                while (msb <= maxI && !pos[msb]) {
                    msb++;
                }
                if (msb > maxI) {
                    println("Case #" + test + ": IMPOSSIBLE");
                    return;
                }
                horPart[msb] = true;
                x = (1 << msb) - x;
                toggle = true;
            } else if (pos[msb]) {
                while (msb <= maxI && pos[msb]) {
                    msb++;
                }
                if (msb > maxI) {
                    println("Case #" + test + ": IMPOSSIBLE");
                    return;
                }
                horPart[msb] = true;
                x = (1 << msb) - x;
                toggle = false;
            } else {
                horPart[msb] = true;
                x -= (1 << msb);
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= maxI; i++) {
            if (horPart[i]) {
                if (pos[i]) {
                    res.append(x1 < 0 ? "W" : "E");
                } else {
                    res.append(x1 < 0 ? "E" : "W");
                }
            } else {
                if (pos[i]) {
                    res.append(y1 < 0 ? "S" : "N");
                } else {
                    res.append(y1 < 0 ? "N" : "S");
                }
            }
        }

        println("Case #" + test + ": " + res.toString());
    }

    public int nextInt() {
        return sc.nextInt();
    }

    public long nextLong() {
        return sc.nextLong();
    }

    public String next() {
        return sc.next();
    }

    public String nextLine() {
        return sc.nextLine();
    }

    public void println(String str) {
        System.out.println(str);
    }

    public void println(int num) {
        System.out.println(num);
    }

    public void println(long num) {
        System.out.println(num);
    }

    public void print(String str) {
        System.out.print(str);
    }

    public void print(int num) {
        System.out.print(num);
    }

    public void print(long num) {
        System.out.print(num);
    }

    public void printArr(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            print(arr[i] + " ");
        }
        println(arr[arr.length - 1]);
    }

    public void printArr(long[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            print(arr[i] + " ");
        }
        println(arr[arr.length - 1]);
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader() {
            this(System.in);
        }

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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}