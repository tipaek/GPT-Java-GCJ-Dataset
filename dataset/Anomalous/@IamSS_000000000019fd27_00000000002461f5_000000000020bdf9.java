import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter out = new PrintWriter(System.out);

    static class Pair implements Comparable<Pair> {
        int time, index, flag;

        Pair(int time, int index, int flag) {
            this.time = time;
            this.index = index;
            this.flag = flag;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.time == other.time) {
                return this.flag - other.flag;
            } else {
                return this.time - other.time;
            }
        }
    }

    static void solve() throws Exception {
        int testCases = nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            Pair[] pairs = new Pair[2 * n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = nextInt();
                endTimes[i] = nextInt();
                pairs[2 * i] = new Pair(startTimes[i], i, 1);
                pairs[2 * i + 1] = new Pair(endTimes[i], i, -1);
            }

            Arrays.sort(pairs);

            char[] result = new char[n];
            int isPossible = 1;
            int endJ = 0, endC = 0;

            for (Pair pair : pairs) {
                if (pair.flag == -1) {
                    if (startTimes[pair.index] >= endJ) {
                        result[pair.index] = 'J';
                        endJ = pair.time;
                    } else if (startTimes[pair.index] >= endC) {
                        result[pair.index] = 'C';
                        endC = pair.time;
                    } else {
                        isPossible = 0;
                        break;
                    }
                }
            }

            if (isPossible == 0) {
                println("Case #" + t + ": IMPOSSIBLE");
            } else {
                println("Case #" + t + ": " + new String(result));
            }
        }
        out.flush();
    }

    public static void main(String[] args) {
        new Thread(null, () -> {
            try {
                solve();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }, "Name", 99999).start();
    }

    static FastReader sc = new FastReader();

    static int nextInt() {
        return sc.nextInt();
    }

    static long nextLong() {
        return sc.nextLong();
    }

    static String next() {
        return sc.next();
    }

    static String nextLine() {
        return sc.nextLine();
    }

    static double nextDouble() {
        return sc.nextDouble();
    }

    static void print(Object o) {
        out.print(o);
    }

    static void println(Object o) {
        out.println(o);
    }

    static int[] readIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    static long[] readLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

    static int abs(int x) {
        return Math.abs(x);
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int countSetBits(int n) {
        return Integer.bitCount(n);
    }

    static void subtractOne(char[] number) {
        if (number[0] == '0') return;
        int n = number.length, i = n - 1;
        while (number[i] == '0') i--;
        number[i] = (char) (number[i] - 1);
        for (int j = i + 1; j < n; j++) {
            number[j] = '9';
        }
    }

    static long pow(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    static long min(long a, long b) {
        return Math.min(a, b);
    }

    static long max(long a, long b) {
        return Math.max(a, b);
    }

    static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) return false;
        }
        return true;
    }

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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