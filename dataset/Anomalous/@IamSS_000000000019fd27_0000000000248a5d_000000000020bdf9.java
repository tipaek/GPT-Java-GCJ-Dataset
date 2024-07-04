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
            return this.time - other.time;
        }
    }

    static void solve() throws Exception {
        int t = nextInt();
        for (int o = 1; o <= t; o++) {
            int n = nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            Pair[] events = new Pair[2 * n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = nextInt();
                endTimes[i] = nextInt();
                events[2 * i] = new Pair(startTimes[i], i, 1);
                events[2 * i + 1] = new Pair(endTimes[i], i, -1);
            }

            Arrays.sort(events);

            char[] result = new char[n];
            int possible = 1, endJ = 0, endC = 0;

            for (int i = 0; i < 2 * n; i++) {
                if (events[i].flag == -1) {
                    if (startTimes[events[i].index] >= endJ) {
                        result[events[i].index] = 'J';
                        endJ = events[i].time;
                    } else if (startTimes[events[i].index] >= endC) {
                        result[events[i].index] = 'C';
                        endC = events[i].time;
                    } else {
                        possible = 0;
                        break;
                    }
                }
            }

            if (possible == 0) {
                println("Case #" + o + ": IMPOSSIBLE");
            } else {
                println("Case #" + o + ": " + new String(result));
            }
        }
        out.flush();
    }

    public static void main(String[] args) {
        new Thread(null, null, "Name", 99999) {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
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

    static void print(Object obj) {
        out.print(obj);
    }

    static void println(Object obj) {
        out.println(obj);
    }

    static int abs(int x) {
        return x > 0 ? x : -x;
    }

    static long gcd(long a, long b) {
        if (b % a == 0) return a;
        return gcd(b % a, a);
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n % 2;
            n /= 2;
        }
        return count;
    }

    static void subtractOne(char[] number) {
        if (number[0] == '0') return;
        int n = number.length, i = n - 1;
        while (number[i] == '0') i--;
        number[i] = (char) (number[i] - 1);
        for (int j = i + 1; j < n; j++) number[j] = '9';
    }

    static long power(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    static long min(long a, long b) {
        return a < b ? a : b;
    }

    static long max(long a, long b) {
        return a > b ? a : b;
    }

    static boolean isPalindrome(String s) {
        int n = s.length(), left = 0, right = n - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
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