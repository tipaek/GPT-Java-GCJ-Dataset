import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution implements Runnable
{
    boolean multiple = true;
    long MOD;
    boolean set = false;
    long[][] nck = new long[600][600];
    int caseNum = 0;

    long nck(int n, int k)
    {
        if (n == k || k == 0) return 1;
        if (nck[n][k] != -1) return nck[n][k];
        return nck[n][k] = (n * nck(n - 1, k - 1)) / k;
    }

    @SuppressWarnings({"Duplicates", "ConstantConditions"})
    void solve() throws Exception
    {
        caseNum++;
        pl("Case #" + caseNum + ": ");
        if (!set)
            for (int i = 0; i < nck.length; i++)
                for (int j = 0; j < nck.length; j++)
                    nck[i][j] = -1;
        set = true;
        long n = sc.nextLong(), curr = 1;
        int i = 1, j = 1;
        pl(i + " " + j);
        while (curr < n)
        {
//            System.out.println(curr + " " + i + " " + j);
//            pl(curr + " " + i + " " + j + " debu+");
            if (i <= 2 || n - curr < i - 1)
            {
                i++;
                curr++;
                pl(i + " " + j);
            }
            else
            {
                //compute furthest out i can go
                long returnCost = 2;
                for (int furthest = 2; furthest <= i + 1; furthest++)
                {

                    returnCost += nck(i - 1, furthest - 1) + nck(i, furthest - 1);
                    if (furthest == i + 1 || returnCost + curr > n)
                    {
                        furthest--;
                        for (int k = 2; k <= furthest; k++) //where i will be
                        {
                            curr += nck(i - 1, k - 1);
                            pl(i + " " + k);
                        }
                        i++;
                        for (int k = furthest; k >= 1; k--) //where i will be
                        {
                            curr += nck(i - 1, k - 1);
                            pl(i + " " + k);
                        }
                        i++;
                        j = 1;
                        pl(i + " " + j);
                        curr++;
                        break;
                    }
                }
            }
//            moves++;
        }
//        pl(moves);
//        pl(curr == n);
    }

    StringBuilder ANS = new StringBuilder();
    void p(Object s) { ANS.append(s); } void p(double s) {ANS.append(s); } void p(long s) {ANS.append(s); } void p(char s) {ANS.append(s); }
    void pl(Object s) { ANS.append(s); ANS.append('\n'); } void pl(double s) { ANS.append(s); ANS.append('\n'); } void pl(long s) { ANS.append(s); ANS.append('\n'); } void pl(char s) { ANS.append(s); ANS.append('\n'); } void pl() { ANS.append(('\n')); }
    /*I/O, and other boilerplate*/ @Override public void run() { try { in = new BufferedReader(new InputStreamReader(System.in));out = new PrintWriter(System.out);sc = new FastScanner(in);if (multiple) { int q = sc.nextInt();for (int i = 0; i < q; i++) solve(); } else solve(); System.out.print(ANS); } catch (Throwable uncaught) { Solution.uncaught = uncaught; } finally { out.close(); }} public static void main(String[] args) throws Throwable{ Thread thread = new Thread(null, new Solution(), "", (1 << 26));thread.start();thread.join();if (Solution.uncaught != null) {throw Solution.uncaught;} } static Throwable uncaught; BufferedReader in; FastScanner sc; PrintWriter out; } class FastScanner { BufferedReader in; StringTokenizer st; public FastScanner(BufferedReader in) {this.in = in;}public String nextToken() throws Exception { while (st == null || !st.hasMoreTokens()) { st = new StringTokenizer(in.readLine()); }return st.nextToken(); }public int nextInt() throws Exception { return Integer.parseInt(nextToken()); }public long nextLong() throws Exception { return Long.parseLong(nextToken()); }public double nextDouble() throws Exception { return Double.parseDouble(nextToken()); }
}