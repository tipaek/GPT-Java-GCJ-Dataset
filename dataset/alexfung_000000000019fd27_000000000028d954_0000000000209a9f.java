import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(), test = 1;
        String S;
        while (test <= T) {
            S = scan.next();
            String[] parens = new String[S.length() + 1];
            int last = 0, diff;
            for (int i = 0; i <= S.length(); i++) {
                diff = i == S.length() ? -last : intAt(S, i) - last;
                last += diff;
                if (diff > 0) {
                    parens[i] = new String(new char[diff]).replace(
                            "\0", "(");
                } else if (diff < 0) {
                    parens[i] = new String(new char[-diff]).replace(
                            "\0", ")");
                } else {
                    parens[i] = "";
                }
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                res.append(parens[i]);
                res.append(S.charAt(i));
            }
            res.append(parens[S.length()]);
            System.out.println(String.format(
                    "Case #%d: %s", test, res));
            test++;
        }
    }

    static int intAt(String S, int i) {
        return S.charAt(i) - '0';
    }
}
