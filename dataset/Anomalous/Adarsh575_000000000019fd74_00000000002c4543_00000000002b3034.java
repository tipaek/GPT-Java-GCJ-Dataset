import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = Integer.parseInt(sc.nextLine());
        for (int test = 1; test <= testcase; test++) {
            System.out.println("Case #" + test + ": " + solve(sc));
        }
    }

    private static String solve(Scanner sc) {
        int N = Integer.parseInt(sc.nextLine());
        String[] s = new String[N];
        for (int i = 0; i < N; i++) {
            s[i] = sc.nextLine();
        }

        String[] revString = new String[N];
        for (int i = 0; i < N; i++) {
            revString[i] = new StringBuilder(s[i]).reverse().toString();
        }

        for (int i = 0; i < N; i++) {
            int starIndex = revString[i].indexOf('*');
            if (starIndex != -1) {
                revString[i] = revString[i].substring(0, starIndex);
            }
            System.out.println(revString[i]);
        }

        int largestIndex = 0;
        int maxLength = -1;
        for (int i = 0; i < N; i++) {
            if (revString[i].length() > maxLength) {
                maxLength = revString[i].length();
                largestIndex = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (revString[i].length() != maxLength) {
                int paddingLength = maxLength - revString[i].length();
                revString[i] = revString[i] + "|".repeat(paddingLength);
            }
            System.out.println(revString[i]);
        }

        char[][] rv = new char[N][maxLength];
        for (int i = 0; i < N; i++) {
            rv[i] = revString[i].toCharArray();
        }

        String[] ans = new String[maxLength];
        for (int i = 0; i < maxLength; i++) {
            boolean match = true;
            char refChar = rv[largestIndex][i];
            for (int j = 1; j < N; j++) {
                if (rv[j][i] != refChar && rv[j][i] != '|') {
                    match = false;
                    break;
                }
            }
            if (match) {
                ans[i] = String.valueOf(refChar);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String str : ans) {
            if (str == null) {
                return "*";
            }
            if (!str.equals("|")) {
                result.append(str);
            }
        }

        return result.reverse().toString();
    }
}