import java.util.*;
import java.io.*;

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

    public static String findShortestString(String[] array) {
        String shortestString = array.length > 0 ? array[0] : "";
        for (String s : array) {
            if (s.length() < shortestString.length()) {
                shortestString = s;
            }
        }
        return shortestString;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            boolean hasStarPrefix = false;
            boolean hasStarSuffix = false;

            for (int j = 0; j < n; j++) {
                strings[j] = scanner.next();
                if (strings[j].charAt(0) == '*') {
                    hasStarPrefix = true;
                }
                if (strings[j].charAt(strings[j].length() - 1) == '*') {
                    hasStarSuffix = true;
                }
            }

            String longestString = findLongestString(strings);
            if (hasStarPrefix) {
                longestString = longestString.substring(1);
                boolean isValid = true;

                for (String s : strings) {
                    if (!longestString.contains(s.substring(1)) || s.charAt(s.length() - 1) != longestString.charAt(longestString.length() - 1)) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    System.out.println("Case #" + i + ": " + longestString);
                } else {
                    System.out.println("Case #" + i + ": *");
                }
            } else if (hasStarSuffix) {
                longestString = longestString.replace("*", "");
                boolean isValid = true;

                for (String s : strings) {
                    for (char ch : s.toCharArray()) {
                        if (ch != '*' && longestString.indexOf(ch) == -1) {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid) {
                        break;
                    }
                }

                if (isValid) {
                    String start = "", end = "";
                    for (String s : strings) {
                        if (s.endsWith("*")) {
                            start = s.substring(0, s.length() - 1);
                        }
                        if (s.startsWith("*")) {
                            end = s.substring(1);
                        }
                    }
                    longestString = start + end;

                    for (String s : strings) {
                        for (char ch : s.toCharArray()) {
                            if (ch != '*' && longestString.indexOf(ch) == -1) {
                                isValid = false;
                                break;
                            }
                        }
                        if (!isValid) {
                            break;
                        }
                    }

                    if (isValid) {
                        System.out.println("Case #" + i + ": " + longestString);
                    } else {
                        System.out.println("Case #" + i + ": *");
                    }
                } else {
                    System.out.println("Case #" + i + ": *");
                }
            }
        }
        scanner.close();
    }
}