import java.util.*;

public class Solution {

    private static void sortStringsByLength(String[] strings, int length) {
        for (int i = 1; i < length; i++) {
            String temp = strings[i];
            int j = i - 1;
            while (j >= 0 && temp.length() < strings[j].length()) {
                strings[j + 1] = strings[j];
                j--;
            }
            strings[j + 1] = temp;
        }
    }

    private static String concatenateWithOverlap(String first, String second) {
        if (!first.contains(second.substring(0, 1))) {
            return first + second;
        }
        int index = second.length();
        try {
            while (!first.endsWith(second.substring(0, index--))) ;
        } catch (Exception ignored) {
        }
        return first + second.substring(index + 1);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            int n = scanner.nextInt();
            String[] prefixes = new String[n];
            String[] suffixes = new String[n];
            boolean hasAsterisk = false;

            for (int i = 0; i < n; i++) {
                String input = scanner.next();

                if (input.charAt(0) == '*') {
                    prefixes[i] = "";
                    suffixes[i] = input.substring(1);
                } else if (input.charAt(input.length() - 1) == '*') {
                    prefixes[i] = input.substring(0, input.length() - 1);
                    suffixes[i] = "";
                } else {
                    String[] parts = input.split("\\*");
                    prefixes[i] = parts[0];
                    suffixes[i] = parts[1];
                    hasAsterisk = true;
                }
            }

            sortStringsByLength(prefixes, n);
            sortStringsByLength(suffixes, n);

            if (!hasAsterisk) {
                boolean isValid = true;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < suffixes[i].length(); j++) {
                        if (suffixes[i].charAt(suffixes[i].length() - 1 - j) != suffixes[n - 1].charAt(suffixes[n - 1].length() - 1 - j)) {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid) break;
                }

                if (isValid) {
                    System.out.println("Case #" + caseNumber + ": " + suffixes[n - 1]);
                } else {
                    System.out.println("Case #" + caseNumber + ": *");
                }
                testCases--;
                caseNumber++;
                continue;
            }

            boolean isValid = true;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < prefixes[i].length(); j++) {
                    if (prefixes[i].charAt(j) != prefixes[n - 1].charAt(j)) {
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) break;
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < suffixes[i].length(); j++) {
                    if (suffixes[i].charAt(suffixes[i].length() - 1 - j) != suffixes[n - 1].charAt(suffixes[n - 1].length() - 1 - j)) {
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) break;
            }

            if (isValid) {
                String result = prefixes[n - 1] + suffixes[n - 1];
                if (result.length() <= 10000) {
                    System.out.println("Case #" + caseNumber + ": " + result);
                } else {
                    System.out.println("Case #" + caseNumber + ": *");
                }
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }

            caseNumber++;
            testCases--;
        }
    }
}