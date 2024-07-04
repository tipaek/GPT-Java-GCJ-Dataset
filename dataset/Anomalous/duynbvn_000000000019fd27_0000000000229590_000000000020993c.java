import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0;
            Map<Integer, Set<Integer>> columnSets = new HashMap<>();

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    if (i == j) trace += value;
                    rowSet.add(value);
                    columnSets.computeIfAbsent(j, k -> new HashSet<>()).add(value);
                }
                if (rowSet.size() < n) rowRepeats++;
            }

            long columnRepeats = columnSets.values().stream().filter(set -> set.size() < n).count();
            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowRepeats, columnRepeats);
        }
    }
}