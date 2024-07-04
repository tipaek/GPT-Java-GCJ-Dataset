import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static String findLongestString(String[] array) {
        String longestString = "";
        for (String s : array) {
            if (s.length() > longestString.length()) {
                longestString = s;
            }
        }
        return longestString;
    }

    public static String findSmallestString(String[] array) {
        String smallestString = array[0];
        for (String s : array) {
            if (s.length() < smallestString.length()) {
                smallestString = s;
            }
        }
        return smallestString;
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

            String longestString = findLongestString(strings).substring(1);
            boolean isPossible = true;
            
            for (String s : strings) {
                if (!longestString.contains(s.substring(1))) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + i + ": " + longestString);
            } else {
                System.out.println("Case #" + i + ": *");
            }
        }
    }
}