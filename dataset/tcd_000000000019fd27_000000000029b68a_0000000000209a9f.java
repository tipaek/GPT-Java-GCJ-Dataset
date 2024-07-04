import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String input = in.nextLine();
            StringBuilder result = new StringBuilder();
            int count = 0;
            for (int j = 0; ; j++) {
                int number = Character.getNumericValue(input.charAt(j));
                int diff = number - count;
                if (diff > 0) {
                    result.append(repeat("(", diff));
                    count += diff;

                } else if (diff < 0) {
                    result.append(repeat(")", -diff));
                    count += diff;
                }
                result.append(number);

                if (j == input.length() - 1) {
                    result.append(repeat(")", count));
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }

    private static StringBuilder repeat(String str, int number) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            builder.append(str);
        }
        return builder;
    }
}