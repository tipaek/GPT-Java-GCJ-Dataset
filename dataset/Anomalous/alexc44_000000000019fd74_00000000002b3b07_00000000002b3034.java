import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = 0;
        if (scanner.hasNextLine()) {
            caseCount = Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i < caseCount; i++) {
            int currentLength = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("Case #" + (i + 1) + ": " + processCase(scanner, currentLength));
        }
    }

    public static String processCase(Scanner scanner, int length) {
        String pattern = "";
        boolean isValid = true;

        for (int i = 0; i < length; i++) {
            String currentString = scanner.nextLine().substring(1); // Remove the first character
            if (pattern.isEmpty()) {
                pattern = currentString;
            } else {
                String shorter, longer;
                if (currentString.length() > pattern.length()) {
                    longer = currentString;
                    shorter = pattern;
                } else {
                    longer = pattern;
                    shorter = currentString;
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