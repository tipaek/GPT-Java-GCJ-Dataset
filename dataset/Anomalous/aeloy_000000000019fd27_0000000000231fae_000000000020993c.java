import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            int order = sc.nextInt();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            Set<Integer> rowSet = new HashSet<>();
            List<Set<Integer>> colSets = initializeColumnSets(order);

            for (int i = 0; i < order; i++) {
                for (int j = 0; j < order; j++) {
                    int val = sc.nextInt();
                    rowSet.add(val);
                    if (i == j) {
                        trace += val;
                    }
                    colSets.get(j).add(val);
                }
                if (rowSet.size() < order) {
                    rowDuplicates++;
                }
                rowSet.clear();
            }

            for (Set<Integer> colSet : colSets) {
                if (colSet.size() < order) {
                    colDuplicates++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", x, trace, rowDuplicates, colDuplicates);
        }
    }

    private static List<Set<Integer>> initializeColumnSets(int order) {
        List<Set<Integer>> columnSets = new ArrayList<>();
        for (int i = 0; i < order; i++) {
            columnSets.add(new HashSet<>());
        }
        return columnSets;
    }
}