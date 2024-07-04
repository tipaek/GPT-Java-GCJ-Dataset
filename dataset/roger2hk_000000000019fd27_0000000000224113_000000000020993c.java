import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int squareSize = in.nextInt();

            int trace = 0;
            Set<Integer> duplicatedRow = new HashSet<>();
            Set<Integer> duplicatedCol = new HashSet<>();

            List<Set<Integer>> cols = new ArrayList<>();
            for (int j = 0; j < squareSize; j++) {
                cols.add(new HashSet<>());
            }

            for (int j = 0; j < squareSize; j++) {

                Set<Integer> row = new HashSet<>();

                for (int k = 0; k < squareSize; k++) {
                    int input = in.nextInt();

                    if (j == k) {
                        trace += input;
                    }

                    if (row.contains(input)) {
                        duplicatedRow.add(j);
                    } else {
                        row.add(input);
                    }

                    if (cols.get(k).contains(input)) {
                        duplicatedCol.add(k);
                    } else {
                        cols.get(k).add(input);
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + duplicatedRow.size() + " " + duplicatedCol.size());
        }
    }
}
