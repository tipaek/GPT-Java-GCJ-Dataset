import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int patternCount = scanner.nextInt();
            scanner.nextLine();
            String prefix = "";
            String suffix = "";
            boolean isValid = true;

            for (int i = 0; i < patternCount; i++) {
                String pattern = scanner.nextLine().trim();
                int asteriskIndex = pattern.indexOf('*');
                
                String currentPrefix = pattern.substring(0, asteriskIndex);
                String currentSuffix = pattern.substring(asteriskIndex + 1);

                if (prefix.startsWith(currentPrefix) || currentPrefix.startsWith(prefix)) {
                    if (currentPrefix.length() > prefix.length()) {
                        prefix = currentPrefix;
                    }
                } else {
                    isValid = false;
                    break;
                }

                if (suffix.endsWith(currentSuffix) || currentSuffix.endsWith(suffix)) {
                    if (currentSuffix.length() > suffix.length()) {
                        suffix = currentSuffix;
                    }
                } else {
                    isValid = false;
                    break;
                }
            }

            String result = isValid ? prefix + suffix : "*";
            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}