import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;

        for (int i = 0; i < cases; i++) {
            int len = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("Case #" + (i + 1) + ": " + generateOutput(scanner, len));
        }
    }

    private static String generateOutput(Scanner scanner, int len) {
        String pattern = "";
        String longest = "";

        for (int i = 0; i < len; i++) {
            String curr = scanner.nextLine().substring(1); // Skip the first character
            if (pattern.isEmpty()) {
                pattern = curr;
            } else {
                String shorter, longer;
                if (curr.length() > pattern.length()) {
                    longer = curr;
                    shorter = pattern;
                } else {
                    longer = pattern;
                    shorter = curr;
                }

                for (int j = 0; j < shorter.length(); j++) {
                    if (shorter.charAt(shorter.length() - j - 1) != longer.charAt(longer.length() - j - 1)) {
                        return "*";
                    }
                }
                pattern = longer;
            }
        }
        return pattern;
    }
}