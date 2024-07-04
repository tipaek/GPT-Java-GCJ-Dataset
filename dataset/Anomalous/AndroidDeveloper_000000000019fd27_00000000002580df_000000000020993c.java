import java.util.*;

public class Solution {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int test = 0; test < tests; ++test) {
            int nums = scanner.nextInt();
            int trace = 0;

            Set<Integer> repeatedRows = new HashSet<>();
            Set<Integer> repeatedCols = new HashSet<>();
            List<Set<Integer>> colsSetList = new ArrayList<>(nums);

            for (int j = 0; j < nums; j++) {
                colsSetList.add(new HashSet<>());
            }

            for (int i = 0; i < nums; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < nums; j++) {
                    int val = scanner.nextInt();
                    if (i == j) {
                        trace += val;
                    }

                    if (!rowSet.add(val)) {
                        repeatedRows.add(i);
                    }

                    if (!colsSetList.get(j).add(val)) {
                        repeatedCols.add(j);
                    }
                }
            }

            System.out.printf("#%d: %d %d %d%n", test + 1, trace, repeatedRows.size(), repeatedCols.size());
        }
    }
}