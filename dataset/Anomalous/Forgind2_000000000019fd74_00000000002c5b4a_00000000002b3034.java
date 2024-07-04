import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int len = scanner.nextInt();
            scanner.nextLine();

            String prefix = "";
            String suffix = "";
            boolean isValid = true;

            for (int i = 0; i < len; i++) {
                String currentLine = scanner.nextLine().trim();
                int asteriskIndex = currentLine.indexOf('*');

                if (asteriskIndex == -1) {
                    isValid = false;
                    break;
                }

                String currentPrefix = currentLine.substring(0, asteriskIndex);
                String currentSuffix = currentLine.substring(asteriskIndex + 1);

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

            System.out.println("Case #" + caseNum + ": " + (isValid ? prefix + suffix : "*"));
        }

        scanner.close();
    }
}