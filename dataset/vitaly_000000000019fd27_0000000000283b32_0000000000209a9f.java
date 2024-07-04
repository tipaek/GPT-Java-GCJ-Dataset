import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int test = 1; test <= t; test++) {
            String s = in.next();
            System.out.println(String.format("Case #%d: %s", test, deepNest(s)));
        }
    }

    private static String deepNest(String inString) {
        int level = 0;
        StringBuilder result = new StringBuilder();
        int openedCount = 0;

        for (int currentItem : toIntArray(inString)) {
            if (currentItem > level) {
                int openingCount = currentItem - openedCount;
                result.append(duplicate('(', openingCount));
                level = currentItem;

                openedCount = currentItem;
            }
            if (currentItem < level) {
                int closingCount = level - currentItem;
                result.append(duplicate(')', closingCount));
                level = currentItem;
                openedCount -= closingCount;
            }
            result.append(currentItem);
        }

        result.append(duplicate(')', level));

        return result.toString();
    }

    private static char[] duplicate(char input, int times) {
        char[] chars = new char[times];
        for (int i = 0; i < times; i++) {
            chars[i] = input;
        }
        return chars;
    }

    private static int[] toIntArray(String s) {
        int zeroCode = '0';
        return s.chars().map((item) -> item - zeroCode).toArray();
    }

}
