import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n_test = in.nextInt();
        in.nextLine(); // Move to the next line

        for (int i = 0; i < n_test; i++) {
            String s = in.next();
            StringBuilder s_out = new StringBuilder();

            // Check if all characters are zeros
            if (s.matches("[0]+")) {
                System.out.println("Case #" + (i + 1) + ": " + s);
                continue;
            }

            // Check if all characters are ones
            if (s.matches("[1]+")) {
                System.out.println("Case #" + (i + 1) + ": (" + s + ")");
                continue;
            }

            boolean openParenthesis = false;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c != '0' && !openParenthesis) {
                    s_out.append("(");
                    openParenthesis = true;
                }

                if (c == '0' && openParenthesis) {
                    s_out.append(")");
                    openParenthesis = false;
                }

                s_out.append(c);
            }

            if (openParenthesis) {
                s_out.append(")");
            }

            System.out.println("Case #" + (i + 1) + ": " + s_out.toString());
        }
    }
}