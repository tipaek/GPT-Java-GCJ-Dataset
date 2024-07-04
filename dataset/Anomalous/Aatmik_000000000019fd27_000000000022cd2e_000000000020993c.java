import java.util.HashSet;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine().trim());
            int trace = 0;
            HashSet<Integer> duplicateRows = new HashSet<>();
            HashSet<Integer> duplicateCols = new HashSet<>();
            HashSet<Integer>[] columnSets = new HashSet[n];
            HashSet<Integer> rowValues = new HashSet<>();

            for (int row = 0; row < n; row++) {
                String[] values = reader.readLine().trim().split("\\s+");
                for (int col = 0; col < n; col++) {
                    if (row == 0) {
                        columnSets[col] = new HashSet<>();
                    }
                    int number = Integer.parseInt(values[col]);

                    if (row == col) {
                        trace += number;
                    }

                    if (!rowValues.add(number)) {
                        duplicateRows.add(row);
                    }

                    if (!columnSets[col].add(number)) {
                        duplicateCols.add(col);
                    }
                }
                rowValues.clear();
            }

            writer.write(String.format("Case #%d: %d %d %d%n", t, trace, duplicateRows.size(), duplicateCols.size()));
        }

        reader.close();
        writer.close();
    }
}