import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            String[] patterns = new String[n];

            for (int j = 0; j < n; j++) {
                patterns[j] = sc.next();
            }

            String[] leftParts = new String[n];
            String[] rightParts = new String[n];

            for (int j = 0; j < n; j++) {
                int asteriskIndex = patterns[j].indexOf('*');
                leftParts[j] = patterns[j].substring(0, asteriskIndex);
                rightParts[j] = (asteriskIndex != patterns[j].length() - 1) ? patterns[j].substring(asteriskIndex + 1) : "";
            }

            String leftResult = findLongestCommonPrefix(leftParts);
            String rightResult = findLongestCommonPrefix(rightParts);

            if (leftResult.isEmpty() && rightResult.isEmpty()) {
                System.out.println("Case #" + i + ": *");
            } else {
                System.out.println("Case #" + i + ": " + leftResult + rightResult);
            }
        }
    }

    private static String findLongestCommonPrefix(String[] parts) {
        String longest = "";
        int maxLength = Integer.MIN_VALUE;

        for (String part : parts) {
            if (part.length() > maxLength) {
                maxLength = part.length();
                longest = part;
            }
        }

        if (longest.isEmpty()) {
            return "";
        }

        for (String part : parts) {
            if (!longest.contains(part)) {
                return "";
            }
        }

        return longest;
    }
}