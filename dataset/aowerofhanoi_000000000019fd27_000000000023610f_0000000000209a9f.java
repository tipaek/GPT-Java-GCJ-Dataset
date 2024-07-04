import java.util.Scanner;

public class Solution {

    static void innerSolve(int T, Scanner sc) {
        String S = sc.next() + "0";
        StringBuilder out = new StringBuilder();
        int currentDep = 0;
        for (int i = 0; i < S.length(); i++) {
            int dep = S.charAt(i) - '0';
            char paren = currentDep < dep ? '(' : ')';
            for (int j = 0; j < Math.abs(currentDep - dep); j++) {
                out.append(paren);
            }
            out.append(S.charAt(i));
            currentDep = dep;
        }
        String ans = out.substring(0, out.length() - 1);
        System.out.println("Case #" + T + ": " + ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            innerSolve(t, sc);
        }
    }
}
