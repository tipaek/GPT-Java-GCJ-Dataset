import java.util.Scanner;

public class Solution {


    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new java.io.BufferedReader(new java.io.InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            String S = in.next();
            System.out.println("Case #" + t + ": " + compute(S));
        }
        in.close();
    }


    static int countOpen = 0;

    public static String compute(String S) {
        countOpen = 0;
        StringBuilder sb = new StringBuilder();
        int prev = -1;
        for (char c : S.toCharArray()) {
            int n = Integer.parseInt(c + "");
            if (prev == -1) {
                addParenthesis(sb, n);
                sb.append(n);
                prev = n;
                continue;
            }
            addParenthesis(sb, n - prev);
            sb.append(n);
            prev = n;
        }
        addParenthesis(sb, -1 * countOpen);

        return sb.toString();
    }

    private static void addParenthesis(StringBuilder sb, int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                sb.append("(");
                countOpen++;
            }
        } else {
            n = n * -1;
            for (int i = 0; i < n; i++) {
                sb.append(")");
                countOpen--;
            }
        }
    }
}