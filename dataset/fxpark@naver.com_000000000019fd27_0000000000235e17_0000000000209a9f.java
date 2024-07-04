import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedReader rd;
    PrintWriter wr;
    StringTokenizer tok = null;

    String nextToken() throws IOException {
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
            String res = subsolve();
            wr.println(String.format("Case #%d: %s", i + 1, res));
        }
        rd.close();
        wr.close();
    }

    private String subsolve() throws IOException {
        String n = nextToken();
        int l = n.length();
        int curDepth = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < l; i++) {
            char ch = n.charAt(i);
            int num = ch - '0';

            while(curDepth < num) {
                sb.append("(");
                curDepth++;
            }

            while(curDepth > num) {
                sb.append(")");
                curDepth--;
            }

            sb.append(ch);
        }

        while(curDepth > 0) {
            sb.append(")");
            curDepth--;
        }


        return sb.toString();
    }
}