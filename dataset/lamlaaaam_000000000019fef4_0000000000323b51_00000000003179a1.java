import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int T = io.nextInt();
        for (int i = 1; i <= T; ++i) {
            solve(io, i);
        }
        io.close();
    }

    private static boolean[][] table;
    private static boolean[] letters;

    private static void solve(Kattio io, int t) {
        table = new boolean[26][10];
        letters = new boolean[26];
        int u = io.nextInt();
        for (int i = 0; i < 10000; ++i) {
            long num = io.nextLong();
            String str = io.next();
            process(num, str);
            //System.out.println("PROCESSING " + num + " " + str);
        }
        //System.out.println(Arrays.toString(letters));
        //for (char c = 'A'; c <= 'Z'; ++c) {
        //    System.out.println(c);
        //    System.out.println(Arrays.toString(table[c - 'A']));
        //}
        char[] map = new char[10];
        for (char c = 'A'; c <= 'Z'; ++c) {
            //System.out.println("FINDING " + c);
            if (!letters[c - 'A']) continue;
            boolean[] digits = table[c - 'A'];
            //System.out.println("WORKING ON " + c);
            if (!digits[0]) {
                map[0] = c;
                continue;
            }
            for (int i = 9; i >= 1; --i) {
                if (!digits[i]) {
                    map[i] = c;
                    break;
                }
            }
        }
        io.println("Case #" + t + ": " + new String(map));
    }

    private static void process(long num, String str) {
        int len = str.length();
        int numLen = (int) (Math.log10(num) + 1);
        if (len == 1 && numLen != 1) {
            letters[str.charAt(0) - 'A'] = true;
            return;
        }
        if (len != numLen) {
            for (int i = 0; i < len; ++i) {
                char c = str.charAt(i);
                letters[c - 'A'] = true;
            }
            table[str.charAt(0) - 'A'][0] = true;
            return;
        }
        for (int i = 0; i < len; ++i) {
            char c = str.charAt(i);
            letters[c - 'A'] = true;
        }
        table[str.charAt(0) - 'A'][0] = true;
        int first = (int) (num / (Math.pow(10, numLen - 1)));
        for (int i = first + 1; i < 10; ++i) {
            table[str.charAt(0) - 'A'][i] = true;
        }
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    public String next() {
        return nextToken();
    }

    public String nextLine() {
        try {
            return r.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
