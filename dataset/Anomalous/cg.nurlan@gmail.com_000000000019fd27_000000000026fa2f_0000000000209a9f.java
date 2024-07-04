import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    public String solve(String s) {
        StringBuilder res = new StringBuilder();
        int openBrackets = 0;

        for (int i = 0; i < s.length(); ++i) {
            int digit = s.charAt(i) - '0';
            while (openBrackets < digit) {
                res.append('(');
                openBrackets++;
            }
            while (openBrackets > digit) {
                res.append(')');
                openBrackets--;
            }
            res.append(s.charAt(i));
        }

        while (openBrackets > 0) {
            res.append(')');
            openBrackets--;
        }

        return res.toString();
    }

    public void solve() throws Exception {
        int t = sc.nextInt();
        for (int i = 0; i < t; ++i) {
            String s = sc.nextToken();
            System.out.println("Case #" + (i + 1) + ": " + solve(s));
        }
    }

    /*--------------------------------------------------------------*/

    static String filename = "";
    static boolean fromFile = false;

    BufferedReader in;
    PrintWriter out;
    FastScanner sc;

    public static void main(String[] args) {
        new Thread(null, new Solution(), "", 1 << 25).start();
    }

    public void run() {
        try {
            init();
            solve();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
    }

    void init() throws Exception {
        if (fromFile) {
            in = new BufferedReader(new FileReader(filename + ".in"));
            out = new PrintWriter(new FileWriter(filename + ".out"));
        } else {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
        sc = new FastScanner(in);
    }
}

class FastScanner {

    BufferedReader reader;
    StringTokenizer strTok;

    public FastScanner(BufferedReader reader) {
        this.reader = reader;
    }

    public String nextToken() throws IOException {
        while (strTok == null || !strTok.hasMoreTokens()) {
            strTok = new StringTokenizer(reader.readLine());
        }
        return strTok.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public BigInteger nextBigInteger() throws IOException {
        return new BigInteger(nextToken());
    }

    public BigDecimal nextBigDecimal() throws IOException {
        return new BigDecimal(nextToken());
    }
}