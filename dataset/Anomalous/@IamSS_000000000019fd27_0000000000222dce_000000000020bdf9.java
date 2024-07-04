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
                if (this.index == other.index) {
                    return 1;
                } else if (this.index > other.index) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return this.time - other.time;
            }
        }
    }

    static void solve() throws Exception {
        int t = nextInt();
        for (int o = 1; o <= t; o++) {
            int n = nextInt();
            Pair[] pairs = new Pair[2 * n];
            for (int i = 0; i < n; i++) {
                int start = nextInt() + 1;
                int end = nextInt();
                pairs[2 * i] = new Pair(start, i, 1);
                pairs[2 * i + 1] = new Pair(end, i, -1);
            }
            Arrays.sort(pairs);
            char[] result = new char[n];
            int count = 0, flag = 0; // 0 for C and 1 for J
            boolean possible = true;
            for (int i = 0; i < 2 * n; i++) {
                count += pairs[i].flag;
                if (count > 2) {
                    possible = false;
                    break;
                } else if (pairs[i].flag == -1) {
                    if (flag == 0) {
                        result[pairs[i].index] = 'C';
                        flag = 1;
                    } else {
                        result[pairs[i].index] = 'J';
                        flag = 0;
                    }
                }
            }
            if (!possible) {
                println("Case #" + o + ": IMPOSSIBLE");
            } else {
                print("Case #" + o + ": ");
                for (int i = 0; i < n; i++) {
                    print(result[i]);
                }
                if (o != t) {
                    println("");
                }
            }
        }
        out.flush();
    }

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }, "Name", 99999).start();
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

    static void print(Object o) {
        out.print(o);
    }

    static void println(Object o) {
        out.println(o);
    }

    static int abs(int x) {
        return x > 0 ? x : -x;
    }

    static long gcd(long a, long b) {
        return b % a == 0 ? a : gcd(b % a, a);
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
    }

    static void subtractOne(char[] s) {
        if (s[0] == '0') {
            return;
        }
        int n = s.length, i = n - 1;
        while (s[i] == '0') {
            i--;
        }
        s[i] = (char) ((int) (s[i] - '0') + 47);
        for (int j = i + 1; j < n; j++) {
            s[j] = '9';
        }
    }

    static long power(long a, long b, long mod) {
        long result = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            b /= 2;
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
        int n = s.length(), i1 = 0, i2 = n - 1;
        while (i1 < i2) {
            if (s.charAt(i1) != s.charAt(i2)) {
                return false;
            }
            i1++;
            i2--;
        }
        return true;
    }

    static String reverse(String r) {
        StringBuilder sb = new StringBuilder(r);
        return sb.reverse().toString();
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