import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution implements Runnable {
    private boolean multiple = true;
    private long MOD;
    private int caseNumber = 0;
    private StringBuilder ANS = new StringBuilder();
    private BufferedReader in;
    private FastScanner sc;
    private PrintWriter out;
    private static Throwable uncaught;

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(in);
            if (multiple) {
                int q = sc.nextInt();
                for (int i = 0; i < q; i++) solve();
            } else {
                solve();
            }
            System.out.print(ANS);
        } catch (Throwable uncaught) {
            Solution.uncaught = uncaught;
        } finally {
            out.close();
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

    private void solve() throws Exception {
        caseNumber++;
        int n = sc.nextInt();
        StringBuilder beg = new StringBuilder(), end = new StringBuilder();
        List<String> contains = new ArrayList<>();
        boolean good = true;
        String fixedWord = null;

        for (int i = 0; i < n; i++) {
            String s = sc.nextToken();
            if (s.indexOf('*') == -1) {
                good &= fixedWord == null || fixedWord.equals(s);
                if (fixedWord == null) fixedWord = s;
            }

            StringBuilder sBeg = extractPrefix(s);
            good &= checkPrefix(beg, sBeg);
            if (beg.length() < sBeg.length()) beg = sBeg;

            StringBuilder sEnd = extractSuffix(s);
            good &= checkSuffix(end, sEnd);
            if (end.length() < sEnd.length()) end = sEnd;

            contains.addAll(extractContains(s));
        }

        if (fixedWord != null) {
            good &= validateFixedWord(fixedWord, beg, end, contains);
            appendResult("Case #" + caseNumber + ": ", good ? fixedWord : "*");
            return;
        }

        end.reverse();
        StringBuilder ans = new StringBuilder(beg);
        for (String contain : contains) ans.append(contain);
        ans.append(end);

        appendResult("Case #" + caseNumber + ": ", good ? ans : "*");
    }

    private StringBuilder extractPrefix(String s) {
        StringBuilder sBeg = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') break;
            sBeg.append(c);
        }
        return sBeg;
    }

    private boolean checkPrefix(StringBuilder beg, StringBuilder sBeg) {
        for (int j = 0; j < min(beg.length(), sBeg.length()); j++) {
            if (beg.charAt(j) != sBeg.charAt(j)) return false;
        }
        return true;
    }

    private StringBuilder extractSuffix(String s) {
        StringBuilder sEnd = new StringBuilder();
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == '*') break;
            sEnd.append(s.charAt(j));
        }
        return sEnd;
    }

    private boolean checkSuffix(StringBuilder end, StringBuilder sEnd) {
        for (int j = 0; j < min(end.length(), sEnd.length()); j++) {
            if (end.charAt(j) != sEnd.charAt(j)) return false;
        }
        return true;
    }

    private List<String> extractContains(String s) {
        List<String> contains = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        for (int j = 1 + s.indexOf('*'); j < s.length(); j++) {
            if (s.charAt(j) == '*') {
                contains.add(curr.toString());
                curr = new StringBuilder();
            } else {
                curr.append(s.charAt(j));
            }
        }
        return contains;
    }

    private boolean validateFixedWord(String fixedWord, StringBuilder beg, StringBuilder end, List<String> contains) {
        boolean good = beg.length() <= fixedWord.length() && end.length() <= fixedWord.length();
        for (int i = 0; i < min(beg.length(), fixedWord.length()); i++) {
            good &= beg.charAt(i) == fixedWord.charAt(i);
        }
        for (int i = 0; i < min(end.length(), fixedWord.length()); i++) {
            good &= end.charAt(i) == fixedWord.charAt(fixedWord.length() - 1 - i);
        }
        for (String contain : contains) {
            good &= fixedWord.contains(contain);
        }
        return good;
    }

    private void appendResult(String prefix, Object result) {
        ANS.append(prefix).append(result).append('\n');
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
}