import java.util.*;
import java.io.*;

public class Solution {

    private static final boolean IS_PRACTICE = false;
    private static final String INPUT_FILE_NAME = "test";

    private static String answer;

    public static void appendMultipleTimes(StringBuilder sb, String str, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = initializeScanner();

        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.nextLine();

            StringBuilder result = new StringBuilder();
            int currentDigit = Character.getNumericValue(input.charAt(0));
            int frequency = 1;

            appendMultipleTimes(result, "(", currentDigit);

            for (int i = 1; i < input.length(); i++) {
                int nextDigit = Character.getNumericValue(input.charAt(i));
                if (currentDigit != nextDigit) {
                    int difference = currentDigit - nextDigit;
                    appendMultipleTimes(result, String.valueOf(currentDigit), frequency);
                    if (difference > 0) {
                        appendMultipleTimes(result, ")", difference);
                    } else {
                        appendMultipleTimes(result, "(", -difference);
                    }
                    currentDigit = nextDigit;
                    frequency = 1;
                } else {
                    frequency++;
                }
            }

            appendMultipleTimes(result, String.valueOf(currentDigit), frequency);
            appendMultipleTimes(result, ")", currentDigit);

            System.out.printf("Case #%d: %s%s", caseNum, result.toString(), caseNum != testCases ? "\n" : "");
        }
        scanner.close();
    }

    private static Scanner initializeScanner() throws FileNotFoundException {
        if (IS_PRACTICE) {
            String outputFileName = "output-" + INPUT_FILE_NAME + ".out";
            System.setOut(new PrintStream(new File(outputFileName)));
            return new Scanner(new FileReader(INPUT_FILE_NAME + ".in"));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }
}