import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String start = "";
            String end = "";
            String middle = "";
            String answer = "";

            for (int j = 0; j < n; j++) {
                String s = in.next();
                String parts[] = s.split("\\*");
                if (parts.length == 0 ) {
                    continue;
                }

                start = checkStart(start, parts[0]);
                if (start.equals("*")) {
                    break;
                }

                if (parts.length > 1) {
                    end = checkEnd(end, parts[parts.length - 1]);
                    if (end.equals("*")) {
                        break;
                    }
                }

                if (parts.length > 2) {
                    String[] sub = Arrays.copyOfRange(parts, 1, parts.length - 1);
                    middle = collectMiddle(middle, sub);
                }
            }

            if (start.equals("*") || end.equals("*")) {
                answer = "*";
            } else {
                answer = start + middle + end;
            }
            System.out.println("Case #" + i + ": " + answer);
        }
    }

    private static String collectMiddle(String middle, String[] sub) {
        StringBuffer result = new StringBuffer(middle);
        for (String el : sub) {
            if (!result.toString().contains(el)) {
                result.append(el);
            }
        }
        return result.toString();
    }

    private static String checkStart(String old, String current) {
        if (old.isEmpty()) {
            return current;
        } else if (current.isEmpty()) {
            return old;
        } else if (old.length() == current.length()) {
            if (old.equals(current)) {
                return old;
            } else {
                return "*";
            }
        } else if (old.length() > current.length()) {
            if (old.startsWith(current)) {
                return old;
            } else {
                return "*";
            }
        } else {
            if (current.startsWith(old)) {
                return current;
            } else {
                return "*";
            }
        }
    }

    private static String checkEnd(String old, String current) {
        if (old.isEmpty()) {
            return current;
        } else if (current.isEmpty()) {
            return old;
        } else if (old.length() == current.length()) {
            if (old.equals(current)) {
                return old;
            } else {
                return "*";
            }
        } else if (old.length() > current.length()) {
            if (old.endsWith(current)) {
                return old;
            } else {
                return "*";
            }
        } else {
            if (current.endsWith(old)) {
                return current;
            } else {
                return "*";
            }
        }
    }

}