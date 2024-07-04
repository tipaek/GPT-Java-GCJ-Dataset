import java.util.*;
import java.io.*;

public class Solution {

    private static final boolean IS_PRACTICE = false;
    private static final String INPUT_FILE_NAME = "test";

    private static String answer;
    private static Set<String> vincentWords;
    private static List<Set<String>> availableLetters;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = createScanner();

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] array = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    array[j][k] = in.nextInt();
                }
            }

            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += array[j][j];
            }

            int totalNonUniqueRows = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    set.add(array[j][k]);
                }
                if (set.size() != n) {
                    totalNonUniqueRows++;
                }
            }

            int totalNonUniqueColumns = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    set.add(array[k][j]);
                }
                if (set.size() != n) {
                    totalNonUniqueColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%s", i, trace, totalNonUniqueRows, totalNonUniqueColumns, i != t ? "\n" : "");
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
