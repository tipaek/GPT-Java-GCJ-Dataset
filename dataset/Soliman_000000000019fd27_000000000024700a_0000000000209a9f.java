import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static String solve(char[] s) {
        StringBuilder sb = new StringBuilder();
        int curDepth = 0;

        for (char c : s) {
            int curDigit = Integer.parseInt(c + "");
            int depthNeeded = curDigit - curDepth;
            if (depthNeeded > 0) {
                while (depthNeeded > 0) {
                    sb.append("(");
                    depthNeeded--;
                }
            } else {
                while (depthNeeded < 0) {
                    sb.append(")");
                    depthNeeded++;
                }
            }
            sb.append(c);
            curDepth = curDigit;
        }

        while (curDepth > 0) {
            sb.append(")");
            curDepth--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            char[] s = sc.next().toCharArray();
            pw.printf("Case #%d: %s\n", t, solve(s));
        }
        pw.flush();
        pw.close();
    }
}
