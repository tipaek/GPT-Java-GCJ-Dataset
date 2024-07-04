
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
      in.nextLine();
      for (int i = 1; i <= t; ++i) {
        String line = in.nextLine();

        String output = getOutput(line);
        System.out.println("Case #" + i + ": " + output);
      }
    }

    private static String getOutput(String input) {
        String output = "";
        int opened = 0;
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if (c >= '0' && c <= '9') {
                int num = Integer.parseInt(Character.toString(c));
                int diff = Math.abs(num - opened);
                if (num < opened) {
                    // need to close extras
                    output = output + getParentheses(diff, ")");
                } else if (num > opened) {
                    // need to open
                    output += getParentheses(diff, "(");
                }
                opened = num;
                output = output + num;
            } else {
                output = output + "" + c;
            }
        }
        if (opened > 0) {
            output += getParentheses(opened, ")");
        }
        return output;
    }

    private static String getParentheses(int count, String parenthe) {
        String output = "";
        for (int i = 0; i < count; i++) {
            output = output + parenthe;
        }
        return output;
    }
}