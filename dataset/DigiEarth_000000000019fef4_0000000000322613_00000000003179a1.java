import java.util.*;
import java.io.*;

public class Solution {

    private static final boolean IS_PRACTICE = false;
    private static final String INPUT_FILE_NAME = "test";

    private static String answer;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = createScanner();

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int u = in.nextInt();
            List<Set<String>> possibleDigits = new ArrayList<>();
            for (int k = 0; k < 10; k++) {
                possibleDigits.add(new HashSet<>());
            }

            for (int j = 0; j < 10000; j++) {
                String m = in.next();
                String r = in.next();

                if (m.length() == 1 || m.equals("10")) {
                    int val = Integer.parseInt(m);

                    possibleDigits.get(val % 10).add(r);
                }
            }

            String[] digits = new String[10];
            for (int j = 1; j <= 10; j++) {
                if (j < 10) {
                    Set<String> set = possibleDigits.get(j);
                    for (int k = 1; k <= j - 1; k++) {
                       possibleDigits.get(k).stream().forEach(set::remove);
                    }

                    digits[j] = set.iterator().next();
                    possibleDigits.get(0).remove(digits[j]);
                } else {
                    digits[0] = possibleDigits.get(0).iterator().next().charAt(1) + "";
                }
            }

            String answer = String.join("", digits);
            System.out.printf("Case #%d: %s%s", i, answer, i != t ? "\n" : "");
        }
        in.close();
    }

    private static Scanner createScanner() throws FileNotFoundException {
        if (IS_PRACTICE) {
//			String outputFileName = "output-" + INPUT_FILE_NAME + ".out";
//			File outputFile = new File(outputFileName);
//			System.setOut(new PrintStream(outputFile));

            return new Scanner(new FileReader(INPUT_FILE_NAME + ".in"));

        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }
}
