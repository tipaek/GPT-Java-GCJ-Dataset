import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            StringBuilder builder = new StringBuilder();

            int previousNumber = 0;
            for (int j = 0; j < s.length(); j++) {
                int number = Integer.parseInt(s.charAt(j) + "");
                builder.append(handle(number, previousNumber));
                previousNumber = number;
            }
            if (previousNumber != 0) {
                builder.append(repeat(")", previousNumber));
            }
            System.out.println(String.format("Case #%d: %s", i, builder.toString()));
        }
    }

    private static String handle(int number, int openings) {
        StringBuilder builder = new StringBuilder();
        if (number < openings) {
            builder.append(repeat(")", openings - number));
        } else {
            builder.append(repeat("(", number - openings));
        }
        builder.append(number);
        return builder.toString();
    }

    private static String repeat(String s, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(s);
        }
        return result.toString();
    }
}