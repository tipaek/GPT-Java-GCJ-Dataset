import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class Solution {
    private BufferedReader br;
    private StringTokenizer stk;
    private static final long MOD = 1000000007L;

    public static void main(String[] args) {
        new Thread(null, () -> {
            try {
                new Solution().run();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }, "solution", 1 << 26).start();
    }

    public Solution() {
        br = new BufferedReader(new InputStreamReader(System.in));
        stk = null;
    }

    private void run() throws Exception {
        int t = ni();
        for (int I = 1; I <= t; I++) {
            String s = nt();
            StringBuilder str = new StringBuilder(1000);
            for (char c : s.toCharArray()) {
                int num = c - '0';
                String temp = String.valueOf(num);
                for (int j = 0; j < num; j++) {
                    temp = "(" + temp + ")";
                }
                str.append(temp);
            }
            String res = str.toString().replace(")(", "");
            pl("Case #" + I + ": " + res);
        }
    }

    private String nextToken() throws Exception {
        while (stk == null || !stk.hasMoreTokens()) {
            stk = new StringTokenizer(br.readLine(), " ");
        }
        return stk.nextToken();
    }

    private String nt() throws Exception {
        return nextToken();
    }

    private int ni() throws Exception {
        return Integer.parseInt(nextToken());
    }

    private void pl(Object o) {
        System.out.println(o);
    }
}