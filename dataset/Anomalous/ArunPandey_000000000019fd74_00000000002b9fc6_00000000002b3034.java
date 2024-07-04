import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            String[] strings = new String[n];

            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }

            String longestString = findLongestString(strings);
            boolean isMismatch = checkMismatch(strings, longestString);

            if (isMismatch) {
                System.out.println("Case #" + caseNumber + ": *");
            } else {
                System.out.println("Case #" + caseNumber + ": " + longestString);
            }
        }
    }

    private static String findLongestString(String[] strings) {
        String longestString = "";
        for (String s : strings) {
            if (s.length() > longestString.length()) {
                longestString = s;
            }
        }
        return longestString.substring(1);
    }

    private static boolean checkMismatch(String[] strings, String longestString) {
        for (String s : strings) {
            if (!isSuffix(s, longestString)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSuffix(String s, String longestString) {
        int sLength = s.length();
        int longestLength = longestString.length();

        if (sLength - 1 < longestLength) {
            return false;
        }

        for (int i = 0; i < longestLength; i++) {
            if (s.charAt(sLength - 1 - i) != longestString.charAt(longestLength - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}