import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
            String input = in.nextLine();
            StringBuilder output = new StringBuilder();
            char[] chars = input.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int count = Integer.parseInt(Character.toString(chars[i]));
                output.append(repeat("(", count));
                output.append(chars[i]);
                output.append(repeat(")", count));
            }
            String simplifiedOutput = refactorString(output.toString());
            System.out.println("Case #" + k + ": " + simplifiedOutput);
        }
    }

    private static String refactorString(String input) {
        char[] chars = input.toCharArray();
        StringBuilder output = new StringBuilder();
        boolean toRefactor = false;
        for (int i = 0; i < chars.length; i++) {
            String current = Character.toString(chars[i]);
            String next = "";
            if (i + 1 < chars.length) {
                next = Character.toString(chars[i + 1]);
            }
            if (")(".equals(current + next)) {
                toRefactor = true;
                i++;
            } else {
                output.append(chars[i]);
            }
        }
        if (toRefactor) {
            return refactorString(output.toString());
        }
        return output.toString();
    }

    private static String repeat(String s, int repeat) {
        StringBuilder stringToRepeat = new StringBuilder();
        for (int j = 0; j < repeat; j++) {
            stringToRepeat.append(s);
        }
        return stringToRepeat.toString();
    }
} 