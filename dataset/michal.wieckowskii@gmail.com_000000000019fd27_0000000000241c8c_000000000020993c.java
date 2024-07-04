import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            solveCase(in, i);
        }
    }

    public static void solveCase(Scanner in, int caseNb) {
        int k = 0;
        int r = 0;
        int c = 0;


        int n = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.

        List<Set<Integer>> columnValuesSets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            columnValuesSets.add(new HashSet<>());
        }

        for (int row = 0; row < n; row++) {
            final String lineString = in.nextLine();
            final String[] stringArray = lineString.split(" ");

            Set<Integer> rowCheckSet = new HashSet<>();

            for (int col = 0; col < n; col++) {
                final int value = Integer.parseInt(stringArray[col]);

                if (col == row) {
                    k += value;
                }

                if (rowCheckSet != null) {
                    if (!rowCheckSet.contains(value)) {
                        rowCheckSet.add(value);
                    } else {
                        r++;
                        rowCheckSet = null;
                    }
                }

                Set<Integer> columnSet = columnValuesSets.get(col);
                if (columnSet != null) //null means that columns has duplicates
                {
                    if (columnSet.contains(value)) {
                        c++;
                        columnValuesSets.set(col, null);
                    } else {
                        columnSet.add(value);
                    }
                }

            }
        }

        System.out.println("Case #" + caseNb + ": " + k + " " + r + " " + c);

    }


}
