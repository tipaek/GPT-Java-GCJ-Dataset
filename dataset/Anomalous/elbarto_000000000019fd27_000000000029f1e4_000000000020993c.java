import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long cases = scanner.nextLong();

        for (long index = 1; index <= cases; index++) {
            long trace = 0;
            long repeatedRows = 0;
            long repeatedCols = 0;
            long n = scanner.nextLong();

            Map<Long, Set<Long>> columnMap = new HashMap<>();
            Set<Long> colsRepeated = new HashSet<>();

            for (long row = 0; row < n; row++) {
                Set<Long> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (long col = 0; col < n; col++) {
                    long value = scanner.nextLong();

                    if (row == col) {
                        trace += value;
                    }

                    if (!rowSet.add(value) && !rowHasDuplicate) {
                        repeatedRows++;
                        rowHasDuplicate = true;
                    }

                    columnMap.putIfAbsent(col, new HashSet<>());
                    Set<Long> colSet = columnMap.get(col);

                    if (!colSet.add(value) && colsRepeated.add(col)) {
                        repeatedCols++;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", index, trace, repeatedRows, repeatedCols);
        }
    }
}