import java.util.Scanner;

public class Solution {
    public final static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            String S = scanner.next();
            StringBuilder sb = new StringBuilder();
            int topClosedPs = 0;
            int topOpenedPs = 0;
            for (int j = 0; j < S.length(); j++) {
                int d = S.charAt(j) - '0';
                if (topClosedPs > 0) {
                    if (topClosedPs < d) {
                        topOpenedPs = d - topClosedPs;
                        topClosedPs = 0;
                    } else {
                        topOpenedPs = 0;
                        topClosedPs -= d;
                    }
                } else {
                    topOpenedPs = d;
                }
                for (int k = 0; k < topClosedPs; k++) {
                    sb.append(')');
                }
                for (int k = 0; k < topOpenedPs; k++) {
                    sb.append('(');
                }
                sb.append(d);
                topClosedPs = d;
            }
            if (topClosedPs > 0) {
                for (int k = 0; k < topClosedPs; k++) {
                    sb.append(')');
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + sb.toString());
        }
    }
}
