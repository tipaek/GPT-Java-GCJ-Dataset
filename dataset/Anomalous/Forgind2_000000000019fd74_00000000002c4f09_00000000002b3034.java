import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();

        for (int testCaseIndex = 1; testCaseIndex <= testCaseCount; testCaseIndex++) {
            int patternCount = scanner.nextInt();
            scanner.nextLine();
            String prefix = "";
            String suffix = "";
            boolean isValid = true;

            for (int i = 0; i < patternCount; i++) {
                String pattern = scanner.nextLine().trim();
                int asteriskIndex = pattern.indexOf('*');
                
                if (asteriskIndex == -1) {
                    isValid = false;
                    break;
                }

                String currentPrefix = pattern.substring(0, asteriskIndex);
                String currentSuffix = pattern.substring(asteriskIndex + 1);

                if (!prefix.startsWith(currentPrefix) && !currentPrefix.startsWith(prefix)) {
                    isValid = false;
                    break;
                }
                if (!suffix.endsWith(currentSuffix) && !currentSuffix.endsWith(suffix)) {
                    isValid = false;
                    break;
                }

                if (currentPrefix.length() > prefix.length()) {
                    prefix = currentPrefix;
                }
                if (currentSuffix.length() > suffix.length()) {
                    suffix = currentSuffix;
                }
            }

            System.out.println("Case #" + testCaseIndex + ": " + (isValid ? prefix + suffix : '*'));
        }

        scanner.close();
    }
}