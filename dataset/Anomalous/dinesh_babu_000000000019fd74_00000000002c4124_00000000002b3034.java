import java.util.*;

public class Solution {
    static boolean match(String s, String k) {
        int sLength = s.length();
        int kLength = k.length();
        int index = sLength;

        for (int i = kLength - 1; i >= 0; i--) {
            index--;
            if (k.charAt(i) == '*' || s.charAt(index) == '*') {
                return true;
            } else if (k.charAt(i) == s.charAt(index)) {
                continue;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            String maxString = "";
            int maxLength = -1;
            String[] arr = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.next();
                if (arr[i].length() > maxLength) {
                    maxLength = arr[i].length();
                    maxString = arr[i];
                }
            }

            boolean isMatch = true;
            Arrays.sort(arr);

            for (int j = 0; j < n; j++) {
                int t = arr[j].length();
                for (int i = maxLength - 1; i >= 0; i--) {
                    t--;
                    if (maxString.charAt(i) == '*' || arr[j].charAt(t) == '*') {
                        break;
                    } else if (maxString.charAt(i) == arr[j].charAt(t)) {
                        continue;
                    } else {
                        isMatch = false;
                        break;
                    }
                }
                if (!isMatch) {
                    break;
                }
            }

            if (isMatch) {
                System.out.println("Case #" + testCase + ": " + maxString.substring(1));
            } else {
                System.out.println("Case #" + testCase + ": *");
            }
        }

        scanner.close();
    }
}