import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static String findLongestString(String[] array) {
        String longest = "";
        for (String s : array) {
            if (s.length() > longest.length()) {
                longest = s;
            }
        }
        return longest;
    }

    public static String findSmallestString(String[] array) {
        String smallest = null;
        for (String s : array) {
            if (smallest == null || s.length() < smallest.length()) {
                smallest = s;
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            for (int j = 0; j < n; j++) {
                strings[j] = scanner.next();
            }

            String longestSubstr = findLongestString(strings).substring(1);
            boolean isValid = true;
            for (String s : strings) {
                if (!longestSubstr.contains(s.substring(1)) || s.charAt(s.length() - 1) != longestSubstr.charAt(longestSubstr.length() - 1)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + i + ": " + longestSubstr);
            } else {
                System.out.println("Case #" + i + ": *");
            }
        }
    }
}