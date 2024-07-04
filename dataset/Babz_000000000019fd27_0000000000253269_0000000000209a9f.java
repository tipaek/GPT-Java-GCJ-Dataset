import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String input = in.next();
            System.out.println(input);
            String output = getOutput(asIntArray(input));
            System.out.println("Case #" + i + ": " + output);
        }
    }

    public static int[] asIntArray(String number) {
        int[] result = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            result[i] = Integer.parseInt(number.charAt(i) + "");
        }
        return result;
    }

    public static String getOutput(int[] input) {
        StringBuffer output = new StringBuffer("");
        for (int i = 0; i < input.length; i++) {
            if (i == 0) {
                for (int j = 0; j < input[i]; j++) {
                    output.append("(");
                }
                output.append(input[i]);

                for (int k = 0; k < input[i]; k++) {
                    output.append(")");
                }

            } else if (input[i] < (input[i - 1])) {
                StringBuffer small = new StringBuffer();
                for (int j = 0; j < input[i]; j++) {
                    small.append("(");
                }
                small.append(input[i]);
                for (int j = 0; j < input[i]; j++) {
                    small.append(")");
                }
                output.append(small);
            } else if (input[i] > input[i - 1]) {
                int diff = input[i] - input[i - 1];
                StringBuffer small = new StringBuffer();
                for (int j = 0; j < diff; j++) {
                    small.append("(");
                }
                small.append(input[i]);

                for (int k = 0; k < diff; k++) {
                    small.append(")");
                }

                output.insert(output.lastIndexOf(String.valueOf(input[i - 1])) + 1, small);


            } else if (input[i] == input[i - 1]) {
                int length = output.length();
                output.insert(length - input[i], input[i]);
            }
        }
        return output.toString().replace(")(", "");
    }
}