import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;

        for (int i = 0; i < cases; i++) {
            int curr = Integer.parseInt(scanner.nextLine());
            System.out.println("Case #" + (i + 1) + ": " + generateOutput(scanner, curr));
        }
    }

    public static String generateOutput(Scanner scanner, int len) {
        String pattern = "";
        
        for (int i = 0; i < len; i++) {
            String curr = scanner.nextLine().substring(1);
            if (pattern.isEmpty()) {
                pattern = curr;
            } else {
                pattern = mergePatterns(pattern, curr);
                if (pattern.equals("*")) {
                    return "*";
                }
            }
        }
        return pattern;
    }

    private static String mergePatterns(String pattern1, String pattern2) {
        String shorter = pattern1.length() > pattern2.length() ? pattern2 : pattern1;
        String longer = pattern1.length() > pattern2.length() ? pattern1 : pattern2;

        for (int j = 0; j < shorter.length(); j++) {
            if (shorter.charAt(shorter.length() - j - 1) != longer.charAt(longer.length() - j - 1)) {
                return "*";
            }
        }
        return longer;
    }
}