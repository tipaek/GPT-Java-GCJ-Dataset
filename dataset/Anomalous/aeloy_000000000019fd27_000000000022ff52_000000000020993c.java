import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int x = 0; x < t; x++) {
            int order = sc.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            List<Set<Integer>> columns = initializeColumns(order);

            for (int i = 0; i < order; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < order; j++) {
                    int val = sc.nextInt();
                    rowSet.add(val);
                    if (i == j) {
                        trace += val;
                    }
                    columns.get(j).add(val);
                }
                if (rowSet.size() < order) {
                    rowRepeats++;
                }
            }

            for (Set<Integer> colSet : columns) {
                if (colSet.size() < order) {
                    colRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", x + 1, trace, rowRepeats, colRepeats);
        }
    }

    private static List<Set<Integer>> initializeColumns(int order) {
        List<Set<Integer>> columns = new ArrayList<>(order);
        for (int i = 0; i < order; i++) {
            columns.add(new HashSet<>());
        }
        return columns;
    }
}