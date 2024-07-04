import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        for (int tc = 1; tc <= testCaseCount; tc++) {
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int N = scanner.nextInt();
            List<Set<Integer>> columnSets = new ArrayList<>(Collections.nCopies(N, null));
            boolean[] colDuplicateFlags = new boolean[N];

            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;

                for (int j = 0; j < N; j++) {
                    int value = scanner.nextInt();
                    if (i == j) trace += value;

                    if (!rowHasDuplicates) {
                        if (!rowSet.add(value)) {
                            rowHasDuplicates = true;
                            rowDuplicates++;
                        }
                    }

                    if (!colDuplicateFlags[j]) {
                        if (columnSets.get(j) == null) {
                            columnSets.set(j, new HashSet<>(Collections.singleton(value)));
                        } else {
                            Set<Integer> colSet = columnSets.get(j);
                            if (!colSet.add(value)) {
                                colDuplicates++;
                                colDuplicateFlags[j] = true;
                            }
                        }
                    }
                }
            }
            System.out.println("Case #" + tc + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        scanner.close();
    }
}