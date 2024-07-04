import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int k = 1; k <= m; k++) {
            String s = scanner.nextLine();
            StringBuilder t = new StringBuilder();
            boolean openParenthesis = false;

            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (currentChar == '0') {
                    if (openParenthesis) {
                        t.append(')');
                        openParenthesis = false;
                    }
                    t.append('0');
                } else {
                    if (!openParenthesis) {
                        t.append("(1");
                        openParenthesis = true;
                    } else {
                        t.append('1');
                    }
                }
            }

            if (openParenthesis) {
                t.append(')');
            }

            System.out.println("Case #" + k + ": " + t);
        }
    }
}