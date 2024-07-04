import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int amountCases = in.nextInt();

        for (int i = 1; i <= amountCases; ++i) {
            int matrixSize = in.nextInt();

            int trace = 0;
            Set<Integer> rows = new HashSet<>();
            Set<Integer> columns = new HashSet<>();

            List<Set<Integer>> columnValues = new ArrayList<>();

            for (int t = 0; t < matrixSize; t++) {
                columnValues.add(new HashSet<>());
            }

            for (int row = 0; row < matrixSize; row++) {

                Set<Integer> rowValues = new HashSet<>();

                for (int column = 0; column < matrixSize; column++) {
                    int current = in.nextInt();

                    if (row == column) trace += current;
                    if (!rowValues.add(current)) rows.add(row);
                    if (!columnValues.get(column).add(current)) columns.add(column);
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rows.size() + " " + columns.size());
        }
    }
}
