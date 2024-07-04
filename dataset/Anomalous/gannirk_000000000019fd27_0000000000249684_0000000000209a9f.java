import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer input

        for (int z = 1; z <= t; z++) {
            String s = sc.nextLine();
            StringBuilder sd = new StringBuilder();
            int l = s.charAt(0) - '0';

            // Add opening parentheses for the first character
            for (int j = 0; j < l; j++) {
                sd.append('(');
            }
            sd.append(s.charAt(0));

            // Process the rest of the string
            for (int i = 1; i < s.length(); i++) {
                int r = s.charAt(i) - '0';
                if (r < l) {
                    for (int j = 0; j < l - r; j++) {
                        sd.append(')');
                    }
                } else if (r > l) {
                    for (int j = 0; j < r - l; j++) {
                        sd.append('(');
                    }
                }
                sd.append(s.charAt(i));
                l = r; // Update l to the current digit
            }

            // Add closing parentheses for the last character
            for (int j = 0; j < l; j++) {
                sd.append(')');
            }

            System.out.println("Case #" + z + ": " + sd.toString());
        }

        sc.close();
    }
}