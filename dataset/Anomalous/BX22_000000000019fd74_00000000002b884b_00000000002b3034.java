import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<String> start = new ArrayList<>();
            List<String> middle = new ArrayList<>();
            List<String> end = new ArrayList<>();
            String longestStart = "";
            String longestEnd = "";

            for (int j = 0; j < n; j++) {
                String pattern = in.next();
                boolean isOpen = false;
                StringBuilder temp = new StringBuilder();

                for (int k = 0; k < pattern.length(); k++) {
                    char ch = pattern.charAt(k);
                    if (ch == '*' && isOpen && temp.length() > 0) {
                        middle.add(temp.toString());
                        temp.setLength(0);
                    } else if (ch == '*' && !isOpen && temp.length() > 0) {
                        if (temp.length() > longestStart.length()) longestStart = temp.toString();
                        start.add(temp.toString());
                        temp.setLength(0);
                        isOpen = true;
                    } else if (ch == '*' && temp.length() == 0) {
                        isOpen = true;
                    } else if (ch != '*') {
                        temp.append(ch);
                        if (k == pattern.length() - 1) {
                            if (temp.length() > longestEnd.length()) longestEnd = temp.toString();
                            end.add(temp.toString());
                        }
                    }
                }
            }

            System.out.println(start);
            System.out.println(middle);
            System.out.println(end);

            boolean validStart = checkPrefixes(longestStart, start);
            boolean validEnd = checkSuffixes(longestEnd, end);

            if (validStart && validEnd) {
                StringBuilder result = new StringBuilder();
                result.append(longestStart);
                for (String part : middle) result.append(part);
                result.append(longestEnd);
                System.out.println("Case #" + i + ": " + result.toString());
            } else {
                System.out.println("Case #" + i + ": *");
            }
        }
    }

    public static boolean checkPrefixes(String longest, List<String> prefixes) {
        for (String prefix : prefixes) {
            if (!longest.startsWith(prefix)) return false;
        }
        return true;
    }

    public static boolean checkSuffixes(String longest, List<String> suffixes) {
        for (String suffix : suffixes) {
            if (!longest.endsWith(suffix)) return false;
        }
        return true;
    }
}