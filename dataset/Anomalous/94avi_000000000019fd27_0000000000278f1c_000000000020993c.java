import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Vestigium {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCaseCount; test++) {
            int n = Integer.parseInt(br.readLine());
            int trace = 0;
            List<HashSet<Integer>> rows = new ArrayList<>();
            List<HashSet<Integer>> columns = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                HashSet<Integer> currentRow = new HashSet<>();
                rows.add(currentRow);

                for (int j = 0; j < n; j++) {
                    int number = Integer.parseInt(input[j]);
                    currentRow.add(number);

                    if (i == 0) {
                        columns.add(new HashSet<>());
                    }
                    columns.get(j).add(number);

                    if (i == j) {
                        trace += number;
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (HashSet<Integer> row : rows) {
                if (row.size() != n) {
                    duplicateRows++;
                }
            }

            for (HashSet<Integer> column : columns) {
                if (column.size() != n) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + test + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}