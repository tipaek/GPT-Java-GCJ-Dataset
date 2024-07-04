import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int t1 = 0; t1 < t; t1++) {
            int n = sc.nextInt();
            String[] ar = new String[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.next();
            }

            String longestSuffix = findLongestSuffix(ar);
            boolean isValid = validateSuffixes(ar, longestSuffix);

            if (isValid) {
                System.out.println("Case #" + (t1 + 1) + ": " + longestSuffix);
            } else {
                System.out.println("Case #" + (t1 + 1) + ": *");
            }
        }
    }

    private static String findLongestSuffix(String[] ar) {
        int maxLength = 0;
        String longestSuffix = "";

        for (String s : ar) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                longestSuffix = s.substring(1);
            }
        }

        return longestSuffix;
    }

    private static boolean validateSuffixes(String[] ar, String longestSuffix) {
        int maxLength = longestSuffix.length();

        for (String s : ar) {
            int suffixLength = s.length() - 1;
            if (!longestSuffix.substring(maxLength - suffixLength).equals(s.substring(1))) {
                return false;
            }
        }

        return true;
    }
}