import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    
    static PrintWriter out;

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        out = new PrintWriter(System.out);
        for (int t = 1; t <= count; t++) {
            out.print("Case #" + t + ": ");
            solve(s, out);
        }
        out.close();
    }

    static void solve(Scanner sc, PrintWriter out) {

        char[] c = sc.next().toCharArray();
        int n = c.length;

        int level = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int next = c[i] - '0';
            par(sb, next-level);
            sb.append(next);
            level = next;

        }
        par(sb, -level);
        out.println(sb.toString());
    }

    static void par(StringBuilder sb, int d) {
        if(d > 0) {
            for (int i = 0; i < d; i++) {
                sb.append('(');
            }
        } else {
            for (int i = 0; i < -d; i++) {
                sb.append(')');
            }
        }
    }


}
