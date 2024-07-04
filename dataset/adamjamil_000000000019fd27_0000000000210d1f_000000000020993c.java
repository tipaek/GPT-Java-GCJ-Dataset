import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution implements Runnable
{
    boolean multiple = true;
    long MOD;
    int caseNum = 1;

    @SuppressWarnings({"Duplicates", "ConstantConditions"})
    void solve() throws Exception
    {
        int n = sc.nextInt();
        long[][] a = new long[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextLong();
        int r = 0;
        for (int i = 0; i < n; i++)
        {
            TreeSet<Long> values = new TreeSet<>();
            for (int j = 0; j < n; j++)
                values.add(a[i][j]);
            if (values.size() < n) r++;
        }
        int c = 0;
        for (int i = 0; i < n; i++)
        {
            TreeSet<Long> values = new TreeSet<>();
            for (int j = 0; j < n; j++)
                values.add(a[j][i]);
            if (values.size() < n) c++;
        }
        long sum = 0;
        for (int i = 0; i < n; i++)
            sum += a[i][i];
        System.out.println("Case #" + caseNum+ ": " + sum + " " + r + " " + c);
        caseNum++;
    }

    StringBuilder ANS = new StringBuilder();
    void p(Object s) { ANS.append(s); } void p(double s) {ANS.append(s); } void p(long s) {ANS.append(s); } void p(char s) {ANS.append(s); }
    void pl(Object s) { ANS.append(s); ANS.append('\n'); } void pl(double s) { ANS.append(s); ANS.append('\n'); } void pl(long s) { ANS.append(s); ANS.append('\n'); } void pl(char s) { ANS.append(s); ANS.append('\n'); } void pl() { ANS.append(('\n')); }
    /*I/O, and other boilerplate*/ @Override public void run() { try { in = new BufferedReader(new InputStreamReader(System.in));out = new PrintWriter(System.out);sc = new FastScanner(in);if (multiple) { int q = sc.nextInt();for (int i = 0; i < q; i++) solve(); } else solve(); System.out.print(ANS); } catch (Throwable uncaught) { Solution.uncaught = uncaught; } finally { out.close(); }} public static void main(String[] args) throws Throwable{ Thread thread = new Thread(null, new Solution(), "", (1 << 26));thread.start();thread.join();if (Solution.uncaught != null) {throw Solution.uncaught;} } static Throwable uncaught; BufferedReader in; FastScanner sc; PrintWriter out; } class FastScanner { BufferedReader in; StringTokenizer st; public FastScanner(BufferedReader in) {this.in = in;}public String nextToken() throws Exception { while (st == null || !st.hasMoreTokens()) { st = new StringTokenizer(in.readLine()); }return st.nextToken(); }public int nextInt() throws Exception { return Integer.parseInt(nextToken()); }public long nextLong() throws Exception { return Long.parseLong(nextToken()); }public double nextDouble() throws Exception { return Double.parseDouble(nextToken()); }
}