import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            // Read the input string for each test case
            String s = sc.next();
            
            // Find the maximum character in the string
            char maxChar = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) > maxChar) {
                    maxChar = s.charAt(i);
                }
            }

            int maxCharValue = maxChar - '0';
            List<Character> result = new ArrayList<>();

            // Process each character in the string
            for (int i = 0; i < s.length(); i++) {
                int currentValue = s.charAt(i) - '0';
                int value = maxCharValue + currentValue - maxChar - 48;

                if (value > 0) {
                    for (int j = 0; j < value; j++) {
                        result.add('(');
                    }
                    maxCharValue -= value;
                } else if (value < 0) {
                    for (int j = 0; j < -value; j++) {
                        result.add(')');
                    }
                    maxChar -= -value;
                }

                result.add(s.charAt(i));
            }

            // Add closing parentheses based on the last character
            char lastChar = s.charAt(s.length() - 1);
            for (int i = 0; i < lastChar - '0'; i++) {
                result.add(')');
            }

            // Convert the result list to a string and print the result
            StringBuilder sb = new StringBuilder(result.size());
            for (Character ch : result) {
                sb.append(ch);
            }
            System.out.println("Case #" + (t + 1) + ": " + sb.toString());
        }
        
        sc.close();
    }
}