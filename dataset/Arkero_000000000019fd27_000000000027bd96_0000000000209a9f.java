import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine().trim());

        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= T; ++test) {
            String line = in.nextLine().trim();
            result.append("Case #" + test + ": " + processLine(line) + "\n");
        }
        System.out.println(result);
    }

    static String processLine(String line) {
        StringBuilder builder = new StringBuilder();

        int index = 0;
        char previousValue = ' ';
        int repeatedValues = 0;

        while (index <= line.length()) {

            if (index < line.length() && (line.charAt(index) == previousValue || previousValue == ' ')) {
                repeatedValues++;

            } else {
                int digit = Integer.valueOf(String.valueOf(previousValue));
                appendCharacters(builder, digit, '(');
                appendCharacters(builder, repeatedValues, previousValue);
                appendCharacters(builder, digit, ')');
                repeatedValues = 1;
            }

            if (index < line.length()) {
                previousValue = line.charAt(index);
            }
            index++;
        }
        return builder.toString();
    }

    static StringBuilder appendCharacters(StringBuilder builder, int times, char character) {
        for (int i=0; i<times; i++) {
            builder.append(character);
        }
        return builder;
    }

}
