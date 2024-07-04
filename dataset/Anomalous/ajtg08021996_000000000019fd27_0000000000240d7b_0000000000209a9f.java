import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            String s = sc.next();
            char maxChar = s.charAt(0);

            // Find the maximum character in the string
            for (int i = 1; i < s.length(); i++) {
                if (maxChar < s.charAt(i)) {
                    maxChar = s.charAt(i);
                }
            }

            int maxCharValue = maxChar;
            int value;
            ArrayList<Character> result = new ArrayList<>();

            // Process each character in the string
            for (int i = 0; i < s.length(); i++) {
                value = maxCharValue + s.charAt(i) - maxChar - '0';

                if (value > 0) {
                    for (int j = 0; j < value; j++) {
                        result.add('(');
                    }
                    maxCharValue -= value;
                } else if (value < 0) {
                    value = -value;
                    for (int j = 0; j < value; j++) {
                        result.add(')');
                    }
                    maxChar -= value;
                }
                result.add(s.charAt(i));
            }

            // Add closing parentheses for the last character
            for (int i = 0; i < s.charAt(s.length() - 1) - '0'; i++) {
                result.add(')');
            }

            // Build the final output string
            StringBuilder sb = new StringBuilder(result.size());
            for (Character c : result) {
                sb.append(c);
            }
            System.out.println("Case #" + (t + 1) + ": " + sb.toString());
        }
        sc.close();
    }
}