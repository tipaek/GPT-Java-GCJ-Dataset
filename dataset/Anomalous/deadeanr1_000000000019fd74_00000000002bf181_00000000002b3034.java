import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            String commonSubstring = "";
            for (int j = 0; j < n; j++) {
                String currentString = scanner.nextLine();

                if (j == 0) {
                    commonSubstring = currentString;
                } else {
                    if (!commonSubstring.isEmpty()) {
                        commonSubstring = getLongestCommonSubstring(currentString, commonSubstring);
                    }
                }
            }

            String result = commonSubstring.contains("*") ? commonSubstring.replace("*", "CO") : "*";
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String getLongestCommonSubstring(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int maxLength = 0;
        int endIndex = -1;

        int[][] dp = new int[length1][length2];

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (str1.charAt(i) == str2.charAt(j) || str1.charAt(i) == '*' || str2.charAt(j) == '*') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                    if (maxLength < dp[i][j]) {
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }

        if (maxLength == length1) {
            return str1;
        } else if (maxLength == length2) {
            return str2;
        }
        return "";
    }
}