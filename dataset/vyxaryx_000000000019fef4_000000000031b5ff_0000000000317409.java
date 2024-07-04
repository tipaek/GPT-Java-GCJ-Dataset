import java.io.*;
import java.util.StringTokenizer;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader rd;
    private PrintWriter wr;
    private StringTokenizer tok;

    private String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(rd.readLine());
        }
        return tok.nextToken();
    }

    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);

        int t = Integer.parseInt(nextToken());
        for (int i = 0; i < t; ++i) {
            wr.print(String.format("Case #%d: ", i + 1));
            int res = subsolve();
            if (res == -1) {
                wr.println("IMPOSSIBLE");
            } else {
                wr.println(String.format("%d", res));
            }
        }

        rd.close();
        wr.close();
    }

    private int subsolve() throws IOException {
        int x = Integer.parseInt(nextToken());
        int y = Integer.parseInt(nextToken());
        int cx = x;
        int cy = y;
        int t = 0;
        String s = nextToken().trim();
        if (dist(cx, cy) <= t) {
            return t;
        }
        for (int i = 0; i < s.length(); ++i) {
            char ch = Character.toLowerCase(s.charAt(i));
            ++t;
            switch (ch) {
                case 'n':
                    cy += 1;
                    break;
                case 's':
                    cy -= 1;
                    break;
                case 'e':
                    cx += 1;
                    break;
                case 'w':
                    cx -= 1;
                    break;
            }
            if (dist(cx, cy) <= t) {
                return t;
            }
        }
        return -1;
    }

    private int dist(int cx, int cy) {
        return Math.abs(cx) + Math.abs(cy);
    }
}
