import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = 0;
        if (scanner.hasNextLine()) {
            cases = Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i < cases; i++) {
            int curr = scanner.nextInt();
            scanner.nextLine(); // consume the newline
            System.out.println("Case #" + (i + 1) + ": " + processCase(scanner, curr));
        }
    }

    public static String processCase(Scanner scanner, int len) {
        String pattern = "";
        for (int i = 0; i < len; i++) {
            String curr = scanner.nextLine().substring(1); // remove the first character
            if (pattern.isEmpty()) {
                pattern = curr;
            } else {
                if (!matchesPattern(pattern, curr)) {
                    return "*";
                }
                if (curr.length() > pattern.length()) {
                    pattern = curr;
                }
            }
        }
        return pattern;
    }

    private static boolean matchesPattern(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(s1.length() - 1 - i) != s2.charAt(s2.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}