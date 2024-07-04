import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int o = 1; o <= t; o++) {
            int n = Integer.parseInt(sc.nextLine());
            String[] arr = new String[n];
            boolean fall = true;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLine();
                if (arr[0].charAt(0) != '*') {
                    fall = false;
                }
            }

            Arrays.sort(arr, (s1, s2) -> s2.length() - s1.length());

            if (fall) {
                if (isValidPattern(arr, n)) {
                    String sub = arr[0].substring(1);
                    System.out.println("Case #" + o + ": " + sub);
                } else {
                    System.out.println("Case #" + o + ": *");
                }
            } else {
                if (isValidNonFallPattern(arr, n)) {
                    String[] leftParts = new String[n];
                    String[] rightParts = new String[n];
                    splitPatterns(arr, n, leftParts, rightParts);

                    String right = helperss(rightParts);
                    String left = helperss(leftParts);

                    if (right.isEmpty() || left.isEmpty()) {
                        System.out.println("Case #" + o + ": *");
                    } else {
                        System.out.println("Case #" + o + ": " + right + left);
                    }
                } else {
                    System.out.println("Case #" + o + ": *");
                }
            }
        }
    }

    private static boolean isValidPattern(String[] arr, int n) {
        char last = arr[0].charAt(arr[0].length() - 1);
        String sub = arr[0].substring(1);

        for (int i = 1; i < n; i++) {
            if (last == arr[i].charAt(arr[i].length() - 1)) {
                if (!sub.contains(arr[i].substring(1))) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidNonFallPattern(String[] arr, int n) {
        char first = arr[0].charAt(0);
        if (first == '*') {
            for (String s : arr) {
                if (s.charAt(0) != '*') {
                    first = s.charAt(0);
                    break;
                }
            }
        }

        for (String s : arr) {
            if (first != s.charAt(0) && s.charAt(0) != '*') {
                return false;
            }
        }
        return true;
    }

    private static void splitPatterns(String[] arr, int n, String[] leftParts, String[] rightParts) {
        for (int i = 0; i < n; i++) {
            String[] temp = arr[i].split("\\*");
            if (temp.length == 1) {
                if (arr[i].charAt(0) == '*') {
                    leftParts[i] = temp[0];
                    rightParts[i] = "*";
                } else {
                    rightParts[i] = temp[0];
                    leftParts[i] = "*";
                }
            } else {
                leftParts[i] = temp[1];
                rightParts[i] = temp[0];
            }
        }
    }

    public static String helperss(String[] arr) {
        Arrays.sort(arr, (s1, s2) -> s2.length() - s1.length());

        String sub = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() > 1 && !sub.contains(arr[i])) {
                return "";
            }
        }
        return arr[0];
    }
}