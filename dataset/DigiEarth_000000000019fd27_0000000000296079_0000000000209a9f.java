import java.util.*;
import java.io.*;

public class Solution {

    private static final boolean IS_PRACTICE = false;
    private static final String INPUT_FILE_NAME = "test";

    private static String answer;

    public static void multipleAppend(StringBuilder sb, String appendedString, int times) {
        for (int i = 0; i < times; i++) {
            sb.append(appendedString);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = createScanner();

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String str = in.nextLine();

            StringBuilder sb = new StringBuilder();

            int currentDigit = Integer.parseInt(str.charAt(0) + "");
            int freq = 1;

            multipleAppend(sb, "(", currentDigit);

            for (int k = 1; k < str.length(); k++) {
                int nextDigit = Integer.parseInt(str.charAt(k) + "");
                if (currentDigit != nextDigit) {
                    int diff = currentDigit - nextDigit;
                    multipleAppend(sb, currentDigit + "", freq);
                    if (diff > 0) {
                        multipleAppend(sb, ")", Math.abs(diff));
                    } else {
                        multipleAppend(sb, "(", Math.abs(diff));
                    }
                    currentDigit = nextDigit;
                    freq = 1;
                } else {
                    freq++;
                }
            }

            multipleAppend(sb, currentDigit + "", freq);
            multipleAppend(sb, ")", currentDigit);

            System.out.printf("Case #%d: %s%s", i, sb.toString(), i != t ? "\n" : "");
        }
        in.close();
    }

    private static Scanner createScanner() throws FileNotFoundException {
        if (IS_PRACTICE) {
            String outputFileName = "output-" + INPUT_FILE_NAME + ".out";
            File outputFile = new File(outputFileName);
            System.setOut(new PrintStream(outputFile));

            return new Scanner(new FileReader(INPUT_FILE_NAME + ".in"));

        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }
}
