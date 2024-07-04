import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
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
        int n = nextInt();
        for (int i = 0; i < t; i++) {
            ans = new int[n];
            for (int j = 0; j < n; j++) {
                ans[j] = getInt(j + 1);
                ans[n - j - 1] = getInt(n - j);
            }
            for (int j = 0; j < (n + 1) / 2; j++) {
                int x = getInt(j + 1);
                if (ans[j] != x) {
                    if (ans[j] == ans[n - j - 1]) {
                        ans[j] = x;
                        ans[n - j - 1] = x;
                    } else {
                        ans[j] = x;
                        ans[n - j - 1] = x ^ 1;
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
}
