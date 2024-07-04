
import java.util.*;
import java.io.*;

public class Solution {

    public static int[] solve(List<List<Integer>> matrix) {
        int N = matrix.size();

        int trace = 0, nDuplicatedRows = 0, nDuplicatedColumns = 0;

        Map<Integer, Set<Integer>> colNs = new HashMap<>();
        Map<Integer, Boolean> duplicatedCols = new HashMap<>();
        for (int r = 0; r < N; r++) {
            Set<Integer> rowNs = new HashSet<>();
            boolean duplicatedRow = false;
            for (int c = 0; c < N; c++) {
                int el = matrix.get(r).get(c);
                if (c == r) {
                    trace += el;
                }
                if (!duplicatedRow) {
                    if (rowNs.contains(el)) {
                        nDuplicatedRows++;
                        duplicatedRow = true;
                    } else
                        rowNs.add(el);
                }
                if (!colNs.containsKey(c))
                    colNs.put(c, new HashSet<>());
                if (!duplicatedCols.containsKey(c))
                    duplicatedCols.put(c, false);

                if (!duplicatedCols.get(c))
                    if (colNs.get(c).contains(el)) {
                        nDuplicatedColumns++;
                        duplicatedCols.put(c, true);
                    } else
                        colNs.get(c).add(el);

            }
        }
        return new int[] { trace, nDuplicatedRows, nDuplicatedColumns };
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            List<List<Integer>> matrix = new ArrayList<>();
            for (int r = 0; r < N; r++) {
                List<Integer> row = new ArrayList<>();
                for (int c = 0; c < N; c++) {
                    row.add(in.nextInt());
                }
                matrix.add(row);
            }

            int[] results = solve(matrix);
            System.out.println("Case #" + i + ": " + results[0] + " " + results[1] + " " + results[2]);
        }

    }
}
