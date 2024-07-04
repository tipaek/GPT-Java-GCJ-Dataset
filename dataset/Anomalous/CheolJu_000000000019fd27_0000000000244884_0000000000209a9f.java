import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int nTestCases = in.nextInt();
        in.nextLine(); // Move to the next line

        for (int i = 0; i < nTestCases; i++) {
            String s = in.next();
            StringBuilder sOut = new StringBuilder();

            if (!s.contains("1")) {
                System.out.println("Case #" + (i + 1) + ": " + s);
                continue;
            }

            if (!s.contains("0")) {
                System.out.println("Case #" + (i + 1) + ": (" + s + ")");
                continue;
            }

            int openBrackets = 0;

            for (char c : s.toCharArray()) {
                if (c == '1' && openBrackets == 0) {
                    sOut.append('(');
                    openBrackets++;
                } else if (c == '0' && openBrackets == 1) {
                    sOut.append(')');
                    openBrackets--;
                }
                sOut.append(c);
            }

            if (openBrackets == 1) {
                sOut.append(')');
            }

            System.out.println("Case #" + (i + 1) + ": " + sOut.toString());
        }
    }
}