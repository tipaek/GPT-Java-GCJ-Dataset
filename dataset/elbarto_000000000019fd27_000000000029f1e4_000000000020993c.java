import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long cases = scanner.nextLong();

        for (long index = 1; index <= cases; index++) {
            long trace = 0;
            long repeatedRows = 0;
            long repeatedCols = 0;
            long n = scanner.nextLong();

            HashMap<Long, Set<Long>> mapRow = new LinkedHashMap<>();
            Set<Long> colsRepeated = new HashSet<>();
            for (long r = 0; r < n; r++) {
                Set<Long> setCols = new HashSet<>();
                boolean isRepeated = false;
                for (long c = 0; c < n; c++) {
                    long cell = scanner.nextLong();
                    if (r == c) {
                        trace += cell;
                    }
                    if (setCols.contains(cell) && !isRepeated) {
                        repeatedRows++;
                        isRepeated = true;
                    }
                    setCols.add(cell);

                    if (!mapRow.containsKey(c)) {
                        mapRow.put(c, new HashSet<>());
                    }

                    if (mapRow.get(c).contains(cell) && !colsRepeated.contains(c)) {
                        repeatedCols++;
                        colsRepeated.add(c);
                    }

                    mapRow.get(c).add(cell);
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d", index, trace, repeatedRows, repeatedCols));
        }
    }
}
