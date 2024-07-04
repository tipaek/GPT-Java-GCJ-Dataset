import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            List<Set<Integer>> columnSets = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                columnSets.add(new HashSet<>());
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    rowSet.add(value);
                    columnSets.get(j).add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
                if (rowSet.size() < n) {
                    rowRepeats++;
                }
            }

            for (Set<Integer> columnSet : columnSets) {
                if (columnSet.size() < n) {
                    colRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats);
        }
    }
}