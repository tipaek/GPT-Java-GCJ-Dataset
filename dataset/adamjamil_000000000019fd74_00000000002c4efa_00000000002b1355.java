import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution implements Runnable
{
    boolean multiple = true;
    long MOD;

    class FuckBucket { TreeSet<Integer> set = new TreeSet<>(); }
    class FuckBucket2 { ArrayList<Long> list = new ArrayList<>(); }
    FuckBucket2[][] lists;
    long[][] val;
    FuckBucket[] rows, cols;
    HashSet<Long> remove, next;
    int caseNum = 0;

    @SuppressWarnings({"Duplicates", "ConstantConditions"})
    void solve() throws Exception
    {
        caseNum++;
        p("Case #" + caseNum + ": ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        val = new long[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                val[i][j] = sc.nextLong();
        rows = new FuckBucket[r]; cols = new FuckBucket[c];
        for (int i = 0; i < r; i++)
        {
            rows[i] = new FuckBucket();
            for (int j = 0; j < c; j++)
                rows[i].set.add(j);
        }
        for (int i = 0; i < c; i++)
        {
            cols[i] = new FuckBucket();
            for (int j = 0; j < r; j++)
                cols[i].set.add(j);
        }

        remove = new HashSet<>();
        lists = new FuckBucket2[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                lists[i][j] = new FuckBucket2();

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
            {
                long neighSum = 0, neighs = 0;
                if (i > 0) { neighs++; neighSum += val[i - 1][j]; lists[i][j].list.add(val[i - 1][j]); }
                if (i < r - 1) { neighs++; neighSum += val[i + 1][j]; lists[i][j].list.add(val[i + 1][j]); }
                if (j > 0) { neighs++; neighSum += val[i][j - 1]; lists[i][j].list.add(val[i][j - 1]); }
                if (j < c - 1) { neighs++; neighSum += val[i][j + 1]; lists[i][j].list.add(val[i][j + 1]); }
                if (val[i][j] * neighs < neighSum) { remove.add(pair(i, j)); }
            }
        int[][] last = new int[r][c];
        int steps = 1;

        while (true)
        {
//            for (FuckBucket row : rows)
//                pl(row.set);
//            pl();
//            for (FuckBucket col : cols)
//                pl(col.set);
//            pl();
            if (remove.isEmpty())
                break;
            for (Long rem : remove)
            {
                int i = f(rem), j = s(rem);
                rows[i].set.remove(j);
                cols[j].set.remove(i);
                last[i][j] = steps;
            }
            next = new HashSet<>();
            for (Long rem : remove)
            {
                int i = f(rem), j = s(rem);
                if (rows[i].set.lower(j) != null)
                {
                    Integer otherJ = rows[i].set.lower(j);
                    if (update(i, otherJ, val[i][j], rows[i].set.higher(j)))
                        next.add(pair(i, otherJ));
                    else next.remove(pair(i, otherJ));
                }
                if (rows[i].set.higher(j) != null)
                {
                    Integer otherJ = rows[i].set.higher(j);
                    if (update(i, otherJ, val[i][j], rows[i].set.lower(j)))
                        next.add(pair(i, otherJ));
                    else next.remove(pair(i, otherJ));
                }
                if (cols[j].set.lower(i) != null)
                {
                    Integer otherI = cols[j].set.lower(i);
                    if (update2(otherI, j, val[i][j], cols[j].set.higher(i)))
                        next.add(pair(otherI, j));
                    else next.remove(pair(otherI, j));
                }
                if (cols[j].set.higher(i) != null)
                {
                    Integer otherI = cols[j].set.higher(i);
                    if (update2(otherI, j, val[i][j], cols[j].set.lower(i)))
                        next.add(pair(otherI, j));
                    else next.remove(pair(otherI, j));
                }
            }
            remove = next;
            steps++;
        }
        long ans = 0;
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                ans += (last[i][j] == 0 ? steps : last[i][j]) * val[i][j];
            }
        }
        pl(ans);
    }

    boolean update2(int i, int j, long remove, Integer nextI)
    {
        lists[i][j].list.remove(remove);
        if (nextI != null)
            lists[i][j].list.add(val[nextI][j]);
        long sum = 0;
        for (Long v : lists[i][j].list)
            sum += v;
        return val[i][j] * lists[i][j].list.size() < sum;
    }

    boolean update(int i, int j, long remove, Integer nextJ)
    {
        lists[i][j].list.remove(remove);
        if (nextJ != null)
            lists[i][j].list.add(val[i][nextJ]);
        long sum = 0;
        for (Long v : lists[i][j].list)
            sum += v;
        return val[i][j] * lists[i][j].list.size() < sum;
    }

    long pair(int i, int j)
    {
        return (((long) i) << 32) + j;
    }

    int f(long key)
    {
        return (int) (key >> 32);
    }

    int s(long key)
    {
        return (int) (key & ((1L << 32) - 1));
    }

    StringBuilder ANS = new StringBuilder();
    void p(Object s) { ANS.append(s); } void p(double s) {ANS.append(s); } void p(long s) {ANS.append(s); } void p(char s) {ANS.append(s); }
    void pl(Object s) { ANS.append(s); ANS.append('\n'); } void pl(double s) { ANS.append(s); ANS.append('\n'); } void pl(long s) { ANS.append(s); ANS.append('\n'); } void pl(char s) { ANS.append(s); ANS.append('\n'); } void pl() { ANS.append(('\n')); }
    /*I/O, and other boilerplate*/ @Override public void run() { try { in = new BufferedReader(new InputStreamReader(System.in));out = new PrintWriter(System.out);sc = new FastScanner(in);if (multiple) { int q = sc.nextInt();for (int i = 0; i < q; i++) solve(); } else solve(); System.out.print(ANS); } catch (Throwable uncaught) { Solution.uncaught = uncaught; } finally { out.close(); }} public static void main(String[] args) throws Throwable{ Thread thread = new Thread(null, new Solution(), "", (1 << 26));thread.start();thread.join();if (Solution.uncaught != null) {throw Solution.uncaught;} } static Throwable uncaught; BufferedReader in; FastScanner sc; PrintWriter out; } class FastScanner { BufferedReader in; StringTokenizer st; public FastScanner(BufferedReader in) {this.in = in;}public String nextToken() throws Exception { while (st == null || !st.hasMoreTokens()) { st = new StringTokenizer(in.readLine()); }return st.nextToken(); }public int nextInt() throws Exception { return Integer.parseInt(nextToken()); }public long nextLong() throws Exception { return Long.parseLong(nextToken()); }public double nextDouble() throws Exception { return Double.parseDouble(nextToken()); }
}