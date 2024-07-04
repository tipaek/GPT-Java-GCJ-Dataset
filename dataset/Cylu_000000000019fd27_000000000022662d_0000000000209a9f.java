import java.io.PrintStream;
import java.util.*;

public class Solution {
    Scanner             sc       = new Scanner(System.in);
    static final String FILENAME = "Input";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;

    private void solve() {
        StringBuilder res = new StringBuilder();
        String s = sc.nextLine();
        int d = 0;
        for(char c: s.toCharArray()) {
            int n = Character.getNumericValue(c);
            if(n > d) {
                for(int i = 0; i < n - d; i++) {
                    res.append("(");
                    d++;
                }
            }
            if(n < d) {
                for(int i = 0; i < d - n; i++) {
                    res.append(")");
                    d--;
                }
            }
            res.append(c);
        }
        for(int i = 0; i < d; i++) {
            res.append(")");
            d--;
        }
        out.println(res.toString());
            
    }

    private void run() throws Exception {
        // out = new PrintStream(new FileOutputStream(OUT));
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

}