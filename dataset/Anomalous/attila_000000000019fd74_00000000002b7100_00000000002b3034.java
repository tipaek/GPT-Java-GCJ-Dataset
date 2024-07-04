import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.nextLine();
            }

            StringBuilder prefix = new StringBuilder();
            boolean isValid = true;

            outerLoop:
            for (String pattern : patterns) {
                for (int j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) == '*') {
                        break;
                    }
                    isValid = match(prefix, j, pattern.charAt(j));
                    if (!isValid) {
                        break outerLoop;
                    }
                }
            }

            StringBuilder suffix = new StringBuilder();
            if (isValid) {
                outerLoop:
                for (String pattern : patterns) {
                    for (int j = pattern.length() - 1; j >= 0; j--) {
                        if (pattern.charAt(j) == '*') {
                            break;
                        }
                        isValid = match(suffix, pattern.length() - 1 - j, pattern.charAt(j));
                        if (!isValid) {
                            break outerLoop;
                        }
                    }
                }
                suffix.reverse();
            }

            String result = null;
            if (isValid) {
                if (prefix.length() + suffix.length() <= 10000) {
                    result = prefix.toString() + suffix.toString();
                } else {
                    result = combine(prefix, suffix);
                }
            }

            if (!isValid || result == null) {
                System.out.println("Case #" + t + ": *");
            } else {
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }

    private static String combine(StringBuilder prefix, StringBuilder suffix) {
        for (int i = 0; i < prefix.length(); i++) {
            boolean matches = true;
            for (int j = 0; j < prefix.length() - i; j++) {
                if (prefix.charAt(i + j) != suffix.charAt(j)) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                return prefix.toString() + suffix.substring(prefix.length() - i);
            }
        }
        return null;
    }

    private static boolean match(StringBuilder sb, int index, char character) {
        if (sb.length() <= index) {
            sb.append(character);
            return true;
        }
        return sb.charAt(index) == character;
    }
}