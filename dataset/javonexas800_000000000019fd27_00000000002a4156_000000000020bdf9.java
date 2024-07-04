import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static final char CAMERON_FIRST_LETTER = 'C';
    private static final char JAMIE_FIRST_LETTER = 'J';
    private static final String IMPOSSIBLE_MESSAGE = "IMPOSSIBLE";

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(
                new BufferedReader(
                        new InputStreamReader(System.in)));
        // Scanner in = new Scanner(new File("input3.txt"));

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int inputSize = in.nextInt();
            System.out.println("Case #" + i + ": " + new Solution().process(in, inputSize));
        }
    }

    private String process(Scanner in, int inputSize) {
        StringBuilder builder = new StringBuilder();
        int[] c = new int[1440];
        int[] j = new int[1440];
        for (int i = 0 ; i < inputSize; i++ ) {
            int begin = in.nextInt();
            int end = in.nextInt() - 1 ;
            if (populateSchedule(c, begin, end)) {
                builder.append(CAMERON_FIRST_LETTER);
                continue;
            }

            if (populateSchedule(j,begin, end)) {
                builder.append(JAMIE_FIRST_LETTER);
                continue;
            }

            return IMPOSSIBLE_MESSAGE;
        }

        return builder.toString();
    }

    private boolean populateSchedule(int[] schedule, int start, int end) {
        for (int x = start, y = end ; x < y ; x++ , y --) {
            if (schedule[x] == 0 && schedule[y] == 0) {
                schedule[x] = 1;
                schedule[y] = 1;
            } else {
                revert(schedule, x, y, start, end);
                return false;
            }
        }
        return true;
    }

    private void revert(int[] schedule, int x, int y, int start, int end) {
        for (;x > start && y < end; x--, y++) {
            schedule[x] = 1;
            schedule[y] = 1;
        }
    }
}
