import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution implements Runnable {
    private boolean multiple = true;
    private long MOD;
    private int caseNumber = 0;
    private StringBuilder result = new StringBuilder();

    @SuppressWarnings({"Duplicates", "ConstantConditions"})
    private void solve() throws Exception {
        caseNumber++;
        int n = sc.nextInt();
        StringBuilder prefix = new StringBuilder(), suffix = new StringBuilder();
        HashSet<String> contains = new HashSet<>();
        boolean isValid = true;
        String fixedWord = null;
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String s = arr[i] = sc.nextToken();
            if (s.indexOf('*') == -1) {
                isValid &= fixedWord == null || fixedWord.equals(s);
                if (fixedWord == null) fixedWord = s;
            }

            int m = s.length();
            StringBuilder currentPrefix = new StringBuilder();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '*') break;
                currentPrefix.append(s.charAt(j));
            }
            for (int j = 0; j < min(prefix.length(), currentPrefix.length()); j++) {
                isValid &= prefix.charAt(j) == currentPrefix.charAt(j);
            }
            if (prefix.length() < currentPrefix.length()) {
                prefix = currentPrefix;
            }

            StringBuilder currentSuffix = new StringBuilder();
            for (int j = m - 1; j >= 0; j--) {
                if (s.charAt(j) == '*') break;
                currentSuffix.append(s.charAt(j));
            }
            for (int j = 0; j < min(suffix.length(), currentSuffix.length()); j++) {
                isValid &= suffix.charAt(j) == currentSuffix.charAt(j);
            }
            if (suffix.length() < currentSuffix.length()) {
                suffix = currentSuffix;
            }

            StringBuilder current = new StringBuilder();
            for (int j = 1 + s.indexOf('*'); j < m; j++) {
                if (s.charAt(j) == '*') {
                    contains.add(current.toString());
                    current = new StringBuilder();
                } else {
                    current.append(s.charAt(j));
                }
            }
        }

        if (fixedWord != null) {
            isValid &= prefix.length() <= fixedWord.length() && suffix.length() <= fixedWord.length();
            for (int i = 0; i < min(prefix.length(), fixedWord.length()); i++) {
                isValid &= prefix.charAt(i) == fixedWord.charAt(i);
            }
            for (int i = 0; i < min(suffix.length(), fixedWord.length()); i++) {
                isValid &= suffix.charAt(i) == fixedWord.charAt(fixedWord.length() - 1 - i);
            }
            for (String contain : contains) {
                isValid &= fixedWord.contains(contain);
            }
            print("Case #" + caseNumber + ": ");
            println(isValid ? fixedWord : '*');
            return;
        }

        suffix.reverse();
        StringBuilder answer = new StringBuilder(prefix);
        for (String contain : contains) {
            answer.append(contain);
        }
        answer.append(suffix);
        print("Case #" + caseNumber + ": ");
        println(isValid ? answer : '*');
    }

    private void print(Object s) {
        result.append(s);
    }

    private void println(Object s) {
        result.append(s).append('\n');
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            sc = new FastScanner(in);
            if (multiple) {
                int q = sc.nextInt();
                for (int i = 0; i < q; i++) {
                    solve();
                }
            } else {
                solve();
            }
            System.out.print(result);
        } catch (Throwable uncaught) {
            Solution.uncaught = uncaught;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Solution(), "", (1 << 26));
        thread.start();
        thread.join();
        if (Solution.uncaught != null) {
            throw Solution.uncaught;
        }
    }

    private static Throwable uncaught;
    private FastScanner sc;
    private PrintWriter out;
}

class FastScanner {
    private BufferedReader in;
    private StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }

    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}