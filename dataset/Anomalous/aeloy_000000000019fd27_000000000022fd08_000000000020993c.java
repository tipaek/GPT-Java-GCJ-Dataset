import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 0; x < t; x++) {
            int order = sc.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            List<Set<Integer>> colSets = initializeColumnSets(order);

            for (int i = 0; i < order; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < order; j++) {
                    int val = sc.nextInt();
                    if (i == j) {
                        trace += val;
                    }
                    rowSet.add(val);
                    colSets.get(j).add(val);
                }
                if (rowSet.size() != order) {
                    rowRepeats++;
                }
            }

            for (Set<Integer> colSet : colSets) {
                if (colSet.size() != order) {
                    colRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", x + 1, trace, rowRepeats, colRepeats);
        }
    }

    private static List<Set<Integer>> initializeColumnSets(int order) {
        List<Set<Integer>> columnSets = new ArrayList<>(order);
        for (int i = 0; i < order; i++) {
            columnSets.add(new HashSet<>());
        }
        return columnSets;
    }
}