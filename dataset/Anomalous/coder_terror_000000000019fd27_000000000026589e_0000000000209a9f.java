import java.util.Scanner;

public class Solution {
    static final int MOD = 1_000_000_007;
    static final int INFINITY = Integer.MAX_VALUE;
    static final int NEG_INFINITY = Integer.MIN_VALUE;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            for (int i = 1; i <= t; i++) {
                String s = sc.nextLine();
                StringBuilder s1 = new StringBuilder();
                int p = 0;

                // Append leading zeros
                int j = 0;
                while (j < s.length() && s.charAt(j) == '0') {
                    s1.append('0');
                    j++;
                }

                // Process the rest of the string
                for (int k = j; k < s.length(); k++) {
                    char ch = s.charAt(k);
                    int q = ch - '0';

                    // Add opening brackets
                    while (p < q) {
                        s1.append('(');
                        p++;
                    }

                    // Add closing brackets
                    while (p > q) {
                        s1.append(')');
                        p--;
                    }

                    s1.append(ch);
                }

                // Close any remaining open brackets
                while (p > 0) {
                    s1.append(')');
                    p--;
                }

                System.out.println("Case #" + i + ": " + s1);
            }
        } catch (Exception e) {
            // Handle exception
        }
    }
}