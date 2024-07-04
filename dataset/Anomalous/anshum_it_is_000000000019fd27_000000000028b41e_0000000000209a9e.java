import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int u, v, index;

    public Pair(int x, int y, int z) {
        u = x;
        v = y;
        index = z;
    }

    public Pair() {}

    @Override
    public int compareTo(Pair p) {
        return Integer.compare(this.u, p.u);
    }
}

public class Solution {
    public static int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        new Thread(null, null, "Anshum Gupta", 99999999) {
            @Override
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

    public static void solve() throws Exception {
        MyScanner s = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
        Random rand = new Random();
        int t = s.nextInt();
        int tc = 1;
        int b = s.nextInt();

        if (b == 10) {
            while (tc <= t) {
                int[] ans = new int[11];
                for (int i = 1; i <= b; i++) {
                    System.out.println(i);
                    System.out.flush();
                    ans[i] = s.nextInt();
                }
                for (int i = 1; i <= 10; i++) {
                    System.out.print(ans[i]);
                }
                System.out.println();
                System.out.flush();
                char x = s.next().charAt(0);
                tc++;
                if (x == 'Y') continue;
                else break;
            }
        } else {
            while (tc++ <= t) {
                int c = 1;
                int q = 1;
                int[] query = new int[151];
                while (q <= 20) {
                    System.out.println(c);
                    System.out.flush();
                    query[q] = s.nextInt();
                    if (c == 10) c -= 10;
                    c++;
                    q++;
                }
                if (b == 10) {
                    if (checkEqual(query) || checkReverse(query) || checkComplement(query) || checkComplementAndReverse(query)) {
                        for (int i = 1; i <= 10; i++) {
                            System.out.print(query[i]);
                        }
                        System.out.println();
                        System.out.flush();
                        char x = s.next().charAt(0);
                        if (x == 'Y') continue;
                        else break;
                    }
                }
            }
        }
    }

    private static boolean checkEqual(int[] query) {
        for (int i = 1; i <= 10; i++) {
            if (query[i] != query[i + 10]) return false;
        }
        return true;
    }

    private static boolean checkReverse(int[] query) {
        for (int i = 1; i <= 10; i++) {
            if (query[i] != query[21 - i]) return false;
        }
        return true;
    }

    private static boolean checkComplement(int[] query) {
        for (int i = 1; i <= 10; i++) {
            if (query[i] != 1 - query[10 + i]) return false;
        }
        return true;
    }

    private static boolean checkComplementAndReverse(int[] query) {
        for (int i = 1; i <= 10; i++) {
            if (query[i] != 1 - query[21 - i]) return false;
        }
        return true;
    }

    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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