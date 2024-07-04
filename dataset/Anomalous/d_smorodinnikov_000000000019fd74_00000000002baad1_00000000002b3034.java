import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            for (int j = 0; j < n; j++) {
                strings[j] = scanner.next();
            }
            processTestCase(i, n, strings);
        }
    }

    static void processTestCase(int testCaseNumber, int n, String[] strings) {
        Arrays.sort(strings, (a, b) -> Integer.compare(a.length(), b.length()));
        String longestString = strings[strings.length - 1];
        for (int i = 0; i < strings.length - 1; i++) {
            if (!isValidSubstring(longestString, strings[i])) {
                System.out.println("Case #" + (testCaseNumber + 1) + ": *");
                return;
            }
        }
        System.out.println("Case #" + (testCaseNumber + 1) + ": " + longestString.substring(1));
    }

    static boolean isValidSubstring(String mainString, String subString) {
        int mainLength = mainString.length() - 1;
        int subLength = subString.length() - 1;
        while (subLength > 0) {
            if (mainString.charAt(mainLength) != subString.charAt(subLength)) {
                return false;
            }
            subLength--;
            mainLength--;
        }
        return true;
    }
}