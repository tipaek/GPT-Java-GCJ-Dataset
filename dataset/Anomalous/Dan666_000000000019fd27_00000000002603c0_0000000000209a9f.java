import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= t; i++) {
            String s = scanner.nextLine();
            StringBuilder n = new StringBuilder();
            int co = 0;

            for (int c = 0, j = c + 1; j < s.length(); c++, j++) {
                if (s.charAt(c) == '1') {
                    co++;
                    if (co == 1) {
                        n.append("(");
                    } else if (co > 1 && s.charAt(j) != '1') {
                        n.append(")");
                        co = 0; // Reset counter after closing parenthesis
                    } else if (co > 1 && s.charAt(j) == '1') {
                        n.append(s.charAt(c));
                    } else if (c == 0 && s.charAt(c) != s.charAt(j)) {
                        n.append("(1)");
                    }
                } else if (s.charAt(c) == '0') {
                    n.append(s.charAt(c));
                    if (s.charAt(j) == '0') {
                        n.append(s.charAt(j));
                    }
                }
            }
            System.out.format("Case #%d: %s%n", i, n.toString());
        }

        scanner.close();
    }
}