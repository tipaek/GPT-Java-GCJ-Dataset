import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;

        for (int i = 0; i < cases; i++) {
            int curr = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after the integer input
            System.out.println("Case #" + (i + 1) + ": " + processPattern(scanner, curr));
        }
    }

    public static String processPattern(Scanner scanner, int len) {
        String pattern = "";
        String longest = "";

        for (int i = 0; i < len; i++) {
            String curr = scanner.nextLine().substring(1);
            if (pattern.isEmpty()) {
                pattern = curr;
                longest = curr;
            } else {
                String shorter, longer;
                if (curr.length() > longest.length()) {
                    longer = curr;
                    shorter = pattern;
                } else {
                    longer = longest;
                    shorter = curr;
                }

                for (int j = 0; j < shorter.length(); j++) {
                    if (shorter.charAt(shorter.length() - j - 1) != longer.charAt(longer.length() - j - 1)) {
                        return "*";
                    }
                }
                longest = longer;
            }
        }
        return longest;
    }
}