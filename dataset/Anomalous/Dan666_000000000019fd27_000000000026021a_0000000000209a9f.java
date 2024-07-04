import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int i = 1; i <= t; i++) {
            String s = scanner.nextLine();
            StringBuilder n = new StringBuilder();
            int co = 0;

            for (int c = 0; c < s.length(); c++) {
                char currentChar = s.charAt(c);
                char nextChar = (c + 1 < s.length()) ? s.charAt(c + 1) : '\0';

                if (currentChar == '1') {
                    co++;
                    if (co == 1) {
                        n.append("(");
                    }
                    if (co > 1 && nextChar != '1') {
                        n.append(")");
                    }
                    if (co > 1 && nextChar == '1') {
                        n.append(currentChar);
                    }
                    if (c == 0 && currentChar != nextChar) {
                        n.append("(1)");
                    }
                } else if (currentChar == '0') {
                    n.append(currentChar);
                    if (nextChar == '0') {
                        n.append(nextChar);
                        c++; // Skip the next character as it has already been processed
                    }
                }
            }

            System.out.format("Case #%d: %s%n", i, n.toString());
        }
        
        scanner.close();
    }
}