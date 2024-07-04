import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    /**
     * Given a string of digits S, insert a minimum number of opening and closing parentheses into it such that
     * the resulting string is balanced and each digit d is inside exactly d pairs of matching parentheses.
     * <p>
     * Let the nesting of two parentheses within a string be the substring that occurs strictly between them.
     * An opening parenthesis and a closing parenthesis that is further to its right are said to match if their
     * nesting is empty, or if every parenthesis in their nesting matches with another parenthesis in their nesting.
     * The nesting depth of a position p is the number of pairs of matching parentheses m such that p is included
     * in the nesting of m.
     * <p>
     * For example, in the following strings, all digits match their nesting depth: 0((2)1), (((3))1(2)), ((((4)))),
     * ((2))((2))(1). The first three strings have minimum length among those that have the same digits in the same
     * order, but the last one does not since ((22)1) also has the digits 221 and is shorter.
     *
     * Sample input:
     * 4
     * 0000
     * 101
     * 111000
     * 1
     *
     * Sample output:
     * Case #1: 0000
     * Case #2: (1)0(1)
     * Case #3: (111)000
     * Case #4: (1)
     *
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt(); // Number of test cases.
        in.nextLine();

        for (int i = 1; i <= t; ++i) {

            String s = in.nextLine();

            List<String> groups = getGroups(s);

            String result = getResultString(groups);

            System.out.printf("Case #%d: %s\n", i, result);
        }

        in.close();
    }

    private static String getResultString(List<String> groups) {
        StringBuilder stringBuilder = new StringBuilder();

        // Special case for size 1 sequences list.
        if (groups.size() == 1) {
            int digit = Integer.parseInt(Character.toString(groups.get(0).charAt(0)));

            for (int i = 0; i < digit; i++) {
                stringBuilder.append('(');
            }
            stringBuilder.append(groups.get(0));
            for (int i = 0; i < digit; i++) {
                stringBuilder.append(')');
            }

            return stringBuilder.toString();
        }

        // First digit.
        int firstDigit = Integer.parseInt(Character.toString(groups.get(0).charAt(0)));
        for (int i = 0; i < firstDigit; i++) {
            stringBuilder.append('(');
        }
        stringBuilder.append(groups.get(0));

        // Middle digits.
        for (int i = 1; i < groups.size(); i++) {

            int digit = Integer.parseInt(Character.toString(groups.get(i).charAt(0)));
            int prevDigit = Integer.parseInt(Character.toString(groups.get(i - 1).charAt(0)));

            if (digit < prevDigit) {
                for (int j = 0; j < (prevDigit - digit); j++) {
                    stringBuilder.append(')');
                }
            } else {
                for (int j = 0; j < (digit - prevDigit); j++) {
                    stringBuilder.append('(');
                }
            }
            stringBuilder.append(groups.get(i));

        }

        // Last digit.
        int lastDigit = Integer.parseInt(Character.toString(groups.get(groups.size() - 1).charAt(0)));
        for (int i = 0; i < lastDigit; i++) {
            stringBuilder.append(')');
        }

        return stringBuilder.toString();
    }

    /**
     * Groups number into groups of equal digit sequences.
     *
     * For example, if s = "1100112", this method returns a List sequences = ["11", "00", "11", "2"].
     */
    private static List<String> getGroups(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> groups = new ArrayList<>();

        char[] chars = s.toCharArray();

        if (chars.length == 1) {
            groups.add(s);
            return groups;
        }

        if (chars.length == 0) {
            return groups;
        }

        for (int i = 0; i < chars.length - 1; i++) {
            stringBuilder.append(chars[i]);

            if (!((chars[i] == chars[i + 1] ) && (chars[i] != '0'))) {
                groups.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
            if (i == chars.length - 2) {
                stringBuilder.append(chars[chars.length - 1]);
                groups.add(stringBuilder.toString());
            }
        }

        return groups;
    }
}