import java.util.*;

public class Solution {

    private static String solve(List<List<Integer>> full) {
        int n = full.size();

        Set<Integer> repeatedCols = new HashSet<>();
        Map<Integer, Set<Integer>> columnToNumbers = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            columnToNumbers.put(i, new HashSet<>());
        }

        int repeatRow = 0;

        for (List<Integer> line : full) {
            boolean repeatedRow = false;
            Set<Integer> rowValues = new HashSet<>();
            for (int i = 0; i < n; ++i) {
                if (!rowValues.add(line.get(i))) {
                    repeatedRow = true;
                }
                if (!columnToNumbers.get(i).add(line.get(i))) {
                    repeatedCols.add(i);
                }
            }
            if (repeatedRow) {
                ++repeatRow;
            }
        }

        int trace = 0;
        for (int i = 0; i < n; ++i) {
            trace += full.get(i).get(i);
        }

        return String.format("%d %d %d", trace, repeatRow, repeatedCols.size());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = in.nextInt();
            List<List<Integer>> full = new ArrayList<>(n);
            for (int j = 0; j < n; ++j) {
                List<Integer> line = new ArrayList<>(n);
                for (int k = 0; k < n; ++k) {
                    line.add(in.nextInt());
                }
                full.add(line);
            }

            System.out.println(String.format("Case #" + (i + 1) + ": " + solve(full)));
        }
    }

}
