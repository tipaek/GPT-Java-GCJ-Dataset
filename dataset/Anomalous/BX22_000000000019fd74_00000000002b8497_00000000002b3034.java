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
                int k = 0;
                StringBuilder temp = new StringBuilder();

                while (k < pattern.length()) {
                    char ch = pattern.charAt(k);

                    if (ch == '*' && isOpen && temp.length() > 0) {
                        middle.add(temp.toString());
                        temp.setLength(0);
                    } else if (ch == '*' && !isOpen && temp.length() > 0) {
                        if (temp.length() > longestStart.length()) {
                            longestStart = temp.toString();
                        }
                        start.add(temp.toString());
                        temp.setLength(0);
                    } else if (ch == '*' && temp.length() == 0) {
                        isOpen = true;
                    } else if (ch != '*') {
                        temp.append(ch);
                        if (k == pattern.length() - 1) {
                            if (temp.length() > longestEnd.length()) {
                                longestEnd = temp.toString();
                            }
                            end.add(temp.toString());
                        }
                    }
                    k++;
                }
            }

            boolean isStartValid = isValid(longestStart, start, Solution::startsWith);
            boolean isEndValid = isValid(longestEnd, end, Solution::endsWith);

            if (isStartValid && isEndValid) {
                StringBuilder result = new StringBuilder();
                result.append(longestStart);
                for (String mid : middle) {
                    result.append(mid);
                }
                result.append(longestEnd);
                System.out.println("Case #" + i + ": " + result.toString());
            } else {
                System.out.println("Case #" + i + ": *");
            }
        }
    }

    public static boolean isValid(String longest, List<String> segments, BiPredicate<String, String> checkFunction) {
        for (String segment : segments) {
            if (!checkFunction.test(longest, segment)) {
                return false;
            }
        }
        return true;
    }

    public static boolean startsWith(String longest, String segment) {
        return longest.startsWith(segment);
    }

    public static boolean endsWith(String longest, String segment) {
        return longest.endsWith(segment);
    }
}