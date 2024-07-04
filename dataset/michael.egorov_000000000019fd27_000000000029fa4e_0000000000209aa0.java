import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int k = 1; k <= t; k++) {
            pw.print("Case #" + k + ": ");
            solve();
        }
        pw.flush();
    }

    private static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n == 2) {
            SolveTwo(k);
            return;
        }
        if (n == 3) {
            SolveThree(k);
            return;
        }
        if (n == 4) {
            SolveFour(k);
            return;
        }
        if (n >= 5) {
            SolveFive(k);
            return;
        }
        return;
    }

    private static void SolveTwo(int k) {
        if (k == 2) {
            pw.println("POSSIBLE");
            pw.println("1 2");
            pw.println("2 1");
            return;
        }
        if (k == 4) {
            pw.println("POSSIBLE");
            pw.println("2 1");
            pw.println("1 2");
            return;
        }
        pw.println("IMPOSSIBLE");
    }

    private static void SolveThree(int k) {
        if (k == 3) {
            pw.println("POSSIBLE");
            pw.println("1 2 3");
            pw.println("3 1 2");
            pw.println("2 3 1");
            return;
        }
        if (k == 6) {
            pw.println("POSSIBLE");
            pw.println("2 1 3");
            pw.println("3 2 1");
            pw.println("1 3 2");
            return;
        }
        if (k == 9) {
            pw.println("POSSIBLE");
            pw.println("3 1 2");
            pw.println("2 3 1");
            pw.println("1 2 3");
            return;
        }
        pw.println("IMPOSSIBLE");
    }

    private static void SolveFour(int k) {
        if (k == 4) {
            pw.println("POSSIBLE");
            pw.println("1 2 3 4");
            pw.println("4 1 2 3");
            pw.println("3 4 1 2");
            pw.println("2 3 4 1");
            return;
        }
        if (k == 8) {
            pw.println("POSSIBLE");
            pw.println("2 1 3 4");
            pw.println("4 2 1 3");
            pw.println("3 4 2 1");
            pw.println("1 3 4 2");
            return;
        }
        if (k == 12) {
            pw.println("POSSIBLE");
            pw.println("3 4 1 2");
            pw.println("2 3 4 1");
            pw.println("1 2 3 4");
            pw.println("4 1 2 3");
            return;
        }
        if (k == 16) {
            pw.println("POSSIBLE");
            pw.println("4 1 2 3");
            pw.println("3 4 1 2");
            pw.println("2 3 4 1");
            pw.println("1 2 3 4");
            return;
        }
        pw.println("IMPOSSIBLE");
    }

    private static void SolveFive(int k) {
        if (k == 5) {
            pw.println("POSSIBLE");
            pw.println("1 2 3 4 5");
            pw.println("5 1 2 3 4");
            pw.println("4 5 1 2 3");
            pw.println("3 4 5 1 2");
            pw.println("2 3 4 5 1");
            return;
        }
        if (k == 10) {
            pw.println("POSSIBLE");
            pw.println("2 3 4 5 1");
            pw.println("1 2 3 4 5");
            pw.println("5 1 2 3 4");
            pw.println("4 5 1 2 3");
            pw.println("3 4 5 1 2");
            return;
        }
        if (k == 15) {
            pw.println("POSSIBLE");
            pw.println("3 4 5 1 2");
            pw.println("2 3 4 5 1");
            pw.println("1 2 3 4 5");
            pw.println("5 1 2 3 4");
            pw.println("4 5 1 2 3");
            return;
        }
        if (k == 20) {
            pw.println("POSSIBLE");
            pw.println("4 5 1 2 3");
            pw.println("3 4 5 1 2");
            pw.println("2 3 4 5 1");
            pw.println("1 2 3 4 5");
            pw.println("5 1 2 3 4");
            return;
        }
        if (k == 25) {
            pw.println("POSSIBLE");
            pw.println("5 1 2 3 4");
            pw.println("4 5 1 2 3");
            pw.println("3 4 5 1 2");
            pw.println("2 3 4 5 1");
            pw.println("1 2 3 4 5");
            return;
        }
        pw.println("IMPOSSIBLE");
    }
}
