import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            String solution = new Solution(scanner).solve();
            System.out.println("Case #" + t + ": " + solution);
        }
    }

    final String S;

    public Solution(Scanner scanner) {
        S = scanner.next();
    }

    private String solve() {
        String s = "";

        int depth = 0;
        int index = 0;
        while (index < S.length() || depth > 0) {

            if (index == S.length() &&  depth > 0) {
                s += ")";
                depth--;
                continue;
            }

            int n = S.charAt(index) - '0';
            if (depth == n) {
                s += n;
                index++;
            } else if (depth < n) {
                s += "(";
                depth++;
            } else {
                s += ")";
                depth--;
            }
        }
        return s;
    }

}
