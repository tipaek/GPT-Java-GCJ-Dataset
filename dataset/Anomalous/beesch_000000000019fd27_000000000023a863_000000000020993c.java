import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();

            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                int trace = 0, duplicateRows = 0, duplicateColumns = 0;

                Map<Integer, Set<Integer>> activeColumns = new HashMap<>();
                for (int r = 0; r < n; r++) {
                    Set<Integer> row = new HashSet<>();
                    boolean rowHasDuplicates = false;

                    for (int c = 0; c < n; c++) {
                        if (r == 0) {
                            activeColumns.put(c, new HashSet<>());
                        }

                        int cell = in.nextInt();
                        if (r == c) {
                            trace += cell;
                        }

                        if (!rowHasDuplicates && !row.add(cell)) {
                            duplicateRows++;
                            rowHasDuplicates = true;
                        }

                        Set<Integer> column = activeColumns.get(c);
                        if (column != null && !column.add(cell)) {
                            duplicateColumns++;
                            activeColumns.remove(c);
                        }
                    }
                }

                System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}