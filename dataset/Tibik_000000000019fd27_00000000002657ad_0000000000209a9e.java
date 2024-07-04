import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        run();
        pw.close();
    }


    static int[] ans;

    private static void run() throws IOException {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            int n = nextInt();
            ans = new int[n];
            Pair p1 = null;
            Pair p2 = null;
            int k = 0;
            int start = 1;
            boolean tr = true;
            while (tr) {
                for (int j = 1; j <= 5 - k; j++) {
                    Pair p = getPair(start, n - start + 1);
                    ans[start - 1] = p.x;
                    ans[n - start] = p.y;
                    if (start + 1 >= n - start + 1) {
                        tr = false;
                        break;
                    }
                    start++;
                    if (p1 == null && p.x == p.y) {
                        p1 = p;
                    } else if (p2 == null && p.x != p.y) {
                        p2 = p;
                    }
                }
                if (!tr) break;
                if (p1 == null || p2 == null) {
                    k = 1;
                    if (p2 != null) {
                        Pair p = getPair(p2.x, p2.y);
                        if (p2.x != p.x) {
                            rebuild1();
                        }
                    } else {
                        Pair p = getPair(p1.x, p1.y);
                        if (p1.x != p.x) {
                            rebuild1();
                        }
                    }
                } else {
                    k = 2;
                    Pair p11 = getPair(p1.x, p1.y);
                    Pair p22 = getPair(p2.x, p2.y);
                    if (p11.x == p1.x) {
                        if (p22.x != p2.x) {
                            rebuild2();
                        }
                    } else {
                        if (p22.x != p2.x) {
                            rebuild1();
                        } else {
                            rebuild3();
                        }
                    }
                }
            }
            printAns();
        }
    }

    private static void printAns() throws IOException {
        for (int i = 0; i < ans.length; i++) {
            pw.print(ans[i]);
        }
        pw.println();
        pw.flush();
        if (nextLine().equals("N")) {
            System.exit(0);
        }
    }


    private static void rebuild3() {
        rebuild1();
        rebuild2();
    }

    private static void rebuild2() {
        for (int i = 0; i < ans.length / 2; i++) {
            ans[i] = ans[i] ^ ans[ans.length - 1 - i];
            ans[ans.length - 1 - i] = ans[i] ^ ans[ans.length - 1 - i];
            ans[i] = ans[i] ^ ans[ans.length - 1 - i];
        }
    }

    private static void rebuild1() {
        for (int i = 0; i < ans.length; i++) {
            ans[i] ^= 1;
        }
    }

    private static Pair getPair(int i, int j) {
        return new Pair(getInt(i), getInt(j));

    }

    private static int getInt(int i) {
        pw.println(i);
        pw.flush();
        int x = nextInt();
        if (x == ans.length) {
            System.exit(0);
        }
        return x;
    }

    private static String nextLine() throws IOException {
        return br.readLine();
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
