import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int n, a[], b[];
        String s = "";
        for (int i = 1; i <= t; ++i) {
            n = in.nextInt();
            in.nextLine();
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    s = in.nextLine();
                else {
                    if (!"".equals(s))
                        s = getLongestCommonSubstring(in.nextLine(), s);
                    else in.nextLine();
                }

            }
            String r = s.contains("*") ? s.replace("*", "CO") : "*";
            System.out.println("Case #" + (i) + ": " + r);
        }


    }

    public static String getLongestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int max = 0;

        int[][] dp = new int[m][n];
        int endIndex = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)
                        || str1.charAt(i)=='*' &&str2.charAt(j)!='*' ||str1.charAt(i)!='*' &&str2.charAt(j)=='*') {

                    // If first row or column
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // Add 1 to the diagonal value
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                    if (max < dp[i][j]) {
                        max = dp[i][j];
                        endIndex = i;
                    }
                }

            }
        }
        if(max==str1.length())
            return str1;
        else if(max==str2.length())
            return str2;
        return "";
    }


}
