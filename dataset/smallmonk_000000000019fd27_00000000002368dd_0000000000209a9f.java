import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static char cStart = '(';
    public static char cEnd = ')';

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String numOnly = in.nextLine();

            String result = parenthesize(numOnly);

            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String parenthesize(final String numOnly) {
        String result = "";
        int level = 0;

        for(int i = 0; i<numOnly.length(); i++) {
            char current = numOnly.charAt(i);
            int levelCurrent = current - 48;

            for (int j=level; j<levelCurrent; j++) {
                result += cStart;
            }
            for (int j=levelCurrent; j<level; j++) {
                result += cEnd;
            }
            level = levelCurrent;

            result += current;
        }

        for (int j=0; j<level; j++) {
            result += cEnd;
        }

        return result;
    }
}
