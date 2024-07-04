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

            if (!s.matches(".*[1-9].*")) {
                System.out.println("Case #" + (i + 1) + ": " + s);
                continue;
            }

            if (!s.contains("0")) {
                System.out.println("Case #" + (i + 1) + ": (" + s + ")");
                continue;
            }

            boolean isOpen = false;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c != '0' && !isOpen) {
                    s_out.append('(');
                    isOpen = true;
                } else if (c == '0' && isOpen) {
                    s_out.append(')');
                    isOpen = false;
                }

                s_out.append(c);
            }

            if (isOpen) {
                s_out.append(')');
            }

            System.out.println("Case #" + (i + 1) + ": " + s_out.toString());
        }
    }
}