import java.io.PrintStream;
import java.util.*;

class Template {

    Scanner in = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "A-large";
    static final String IN = FILENAME + ".in";
    static final String OUT = FILENAME + ".out";
    PrintStream out = System.out;

    private void solve() {

        int n = in.nextInt();
        long[][] a = new long[n][n];
        int r = 0, c = 0;
        HashSet<Long> mapr[] = new HashSet[n];
        HashSet<Long> mapc[] = new HashSet[n];
        for (int i = 0; i < n; i++) {
            mapr[i] = new HashSet<>();
            mapc[i] = new HashSet<>();
        }

        boolean row[] = new boolean[n];
        boolean col[] = new boolean[n];
        Arrays.fill(row, false);
        Arrays.fill(col, false);
        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextLong();
                mapr[i].add(a[i][j]);
                mapc[j].add(a[i][j]);

                if (mapr[i].contains(a[i][j]))
                    row[i] = true;

                if (mapc[j].contains(a[i][j]))
                    col[j] = true;

                if (i == j)
                    ans += a[i][j];
            }
        }

        for (int i = 0; i < n; i++)
            if (row[i])
                r++;

        for (int i = 0; i < n; i++)
            if (col[i])
                c++;
        out.println(ans+" "+r+" "+c);
    }

    private void run() throws Exception {
        // out = new PrintStream(new FileOutputStream(OUT));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        in.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Template().run();
    }

}
