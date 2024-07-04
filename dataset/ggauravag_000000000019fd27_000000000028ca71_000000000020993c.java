import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        final int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            final int n = scanner.nextInt();
            final boolean[] notDuplicateCol = new boolean[n];
            Arrays.fill(notDuplicateCol, Boolean.TRUE);
            final HashSet<Integer>[] colSets = new HashSet[n];
            int trace = 0, rowCount = 0, colCount = 0;
            for (int r = 0; r < n; r++) {
                final Set<Integer> rowValues = new HashSet<>();
                boolean notDuplicate = true;
                for (int c = 0; c < n; c++) {
                    final int cellValue = scanner.nextInt();
                    if (c == r) {
                        trace += cellValue;
                    }

                    if (colSets[c] == null) {
                        colSets[c] = new HashSet<>();
                    }

                    if (notDuplicateCol[c]) {
                        notDuplicateCol[c] = colSets[c].add(cellValue);
                        if (!notDuplicateCol[c]) {
                            colCount++;
                        }
                    }

                    if (notDuplicate) {
                        notDuplicate = rowValues.add(cellValue);
                        if (!notDuplicate) {
                            rowCount++;
                        }
                    }
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d", i, trace, rowCount, colCount));
        }
        scanner.close();
    }

}
