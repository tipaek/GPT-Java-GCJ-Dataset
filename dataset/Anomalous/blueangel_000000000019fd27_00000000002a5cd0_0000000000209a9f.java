import java.util.*;
import java.io.*;

public class Solution {

    public static String addParentheses(String str) {
        int num = Integer.parseInt(str);
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < num; i++) {
            ret.append("(");
        }
        ret.append(str);
        for (int i = 0; i < num; i++) {
            ret.append(")");
        }
        return ret.toString();
    }

    public static String insertIntoString(String first, String processStr) {
        int firstDigit = Integer.parseInt(first);
        for (int i = 0; i < processStr.length(); i++) {
            try {
                int digit = Integer.parseInt(String.valueOf(processStr.charAt(i)));
                if (firstDigit == digit) {
                    return processStr.substring(0, i + 1) + first + processStr.substring(i + 1);
                } else {
                    return addParentheses(first) + processStr;
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }
        return "";
    }

    public static String processString(String str) {
        if (str.length() == 1) {
            return addParentheses(str);
        } else {
            String firstChar = String.valueOf(str.charAt(0));
            return insertIntoString(firstChar, processString(str.substring(1)));
        }
    }

    public static String optimizeString(String str) {
        return str.replaceAll("\\)\\(", "");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            String number = in.next();
            String result = processString(number);
            System.out.println("Case #" + (i + 1) + ": " + optimizeString(result));
        }
        in.close();
    }
}