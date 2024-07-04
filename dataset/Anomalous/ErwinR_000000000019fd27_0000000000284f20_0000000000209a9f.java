import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        // Process each testcase
        for (int i = 0; i < testcases; i++) {
            String output = sc.next();
            StringBuilder retString = new StringBuilder();

            // Initial opening parentheses
            int open = output.charAt(0) - '0';
            for (int j = 0; j < open; j++) {
                retString.append('(');
            }

            // Process each character in the output string
            for (int j = 0; j < output.length(); j++) {
                if (j > 0) {
                    int diff = output.charAt(j) - output.charAt(j - 1);
                    if (diff > 0) {
                        for (int k = 0; k < diff; k++) {
                            retString.append('(');
                        }
                    } else if (diff < 0) {
                        for (int k = 0; k < -diff; k++) {
                            retString.append(')');
                        }
                    }
                }
                retString.append(output.charAt(j));
            }

            // Final closing parentheses
            int close = output.charAt(output.length() - 1) - '0';
            for (int j = 0; j < close; j++) {
                retString.append(')');
            }

            // Output the result for the current testcase
            System.out.println("Case #" + (i + 1) + ": " + retString);
        }

        sc.close();
    }
}