import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution implements Runnable
{
    boolean multiple = true;
    long MOD;
    int caseNume = 0;

    @SuppressWarnings({"Duplicates", "ConstantConditions"})
    void solve() throws Exception
    {
        caseNume++;
        int n = sc.nextInt();
        StringBuilder beg = new StringBuilder(), end = new StringBuilder();
        HashSet<String> contains = new HashSet<>();
        boolean good = true;
        String fixedWord = null;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
        {
            String s = arr[i] = sc.nextToken();
            if (s.indexOf('*') == -1)
            {
                good &= fixedWord == null || fixedWord.equals(s);
                if (fixedWord == null) fixedWord = s;
            }

            int m = s.length();
            StringBuilder sBeg = new StringBuilder();
            for (int j = 0; j < m; j++)
                if (s.charAt(j) == '*') break;
                else sBeg.append(s.charAt(j));
            for (int j = 0; j < min(beg.length(), sBeg.length()); j++)
                good &= beg.charAt(j) == sBeg.charAt(j);
            if (beg.length() < sBeg.length())
                beg = sBeg;

            StringBuilder sEnd = new StringBuilder();
            for (int j = m - 1; j >= 0; j--)
                if (s.charAt(j) == '*') break;
                else sEnd.append(s.charAt(j));
            for (int j = 0; j < min(end.length(), sEnd.length()); j++)
                good &= end.charAt(j) == sEnd.charAt(j);
            if (end.length() < sEnd.length())
                end = sEnd;

            StringBuilder curr = new StringBuilder();
            for (int j = 1 + s.indexOf('*'); j < m; j++)
            {
                if (s.charAt(j) == '*')
                {
                    contains.add(curr.toString());
                    curr = new StringBuilder();
                }
                else curr.append(s.charAt(j));
            }
        }

//        end = end.reverse();

        if (fixedWord != null) //fixedWord must match ALL patterns
        {
            good &= beg.length() <= fixedWord.length() && end.length() <= fixedWord.length();
            for (int i = 0; i < min(beg.length(), fixedWord.length()); i++)
                good &= beg.charAt(i) == fixedWord.charAt(i);
            for (int i = 0; i < min(end.length(), fixedWord.length()); i++)
                good &= end.charAt(i) == fixedWord.charAt(fixedWord.length() - 1 - i);

            for (String contain : contains)
                good &= fixedWord.contains(contain);
            p("Case #" + caseNume + ": ");
            pl(good ? fixedWord : '*');
            return;
        }

        end = end.reverse();
        StringBuilder ans = new StringBuilder(beg);
        for (String contain : contains)
            ans.append(contain);
        ans.append(end);
        p("Case #" + caseNume + ": ");
        pl((good) ? ans : '*');
    }

    StringBuilder ANS = new StringBuilder();
    void p(Object s) { ANS.append(s); } void p(double s) {ANS.append(s); } void p(long s) {ANS.append(s); } void p(char s) {ANS.append(s); }
    void pl(Object s) { ANS.append(s); ANS.append('\n'); } void pl(double s) { ANS.append(s); ANS.append('\n'); } void pl(long s) { ANS.append(s); ANS.append('\n'); } void pl(char s) { ANS.append(s); ANS.append('\n'); } void pl() { ANS.append(('\n')); }
    /*I/O, and other boilerplate*/ @Override public void run() { try { in = new BufferedReader(new InputStreamReader(System.in));out = new PrintWriter(System.out);sc = new FastScanner(in);if (multiple) { int q = sc.nextInt();for (int i = 0; i < q; i++) solve(); } else solve(); System.out.print(ANS); } catch (Throwable uncaught) { Solution.uncaught = uncaught; } finally { out.close(); }} public static void main(String[] args) throws Throwable{ Thread thread = new Thread(null, new Solution(), "", (1 << 26));thread.start();thread.join();if (Solution.uncaught != null) {throw Solution.uncaught;} } static Throwable uncaught; BufferedReader in; FastScanner sc; PrintWriter out; } class FastScanner { BufferedReader in; StringTokenizer st; public FastScanner(BufferedReader in) {this.in = in;}public String nextToken() throws Exception { while (st == null || !st.hasMoreTokens()) { st = new StringTokenizer(in.readLine()); }return st.nextToken(); }public int nextInt() throws Exception { return Integer.parseInt(nextToken()); }public long nextLong() throws Exception { return Long.parseLong(nextToken()); }public double nextDouble() throws Exception { return Double.parseDouble(nextToken()); }
}