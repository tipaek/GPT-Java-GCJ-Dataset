import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Vestigium {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCaseCount; test++) {
            int n = Integer.parseInt(br.readLine());
            int trace = 0;
            List<HashSet<Integer>> rows = new ArrayList<>();
            List<HashSet<Integer>> columns = new ArrayList<>();

            for (int row = 0; row < n; row++) {
                String[] inputData = br.readLine().split(" ");
                HashSet<Integer> currentRow = new HashSet<>();
                rows.add(currentRow);

                for (int col = 0; col < n; col++) {
                    int number = Integer.parseInt(inputData[col]);
                    currentRow.add(number);

                    if (row == 0) {
                        columns.add(new HashSet<>());
                    }
                    columns.get(col).add(number);

                    if (row == col) {
                        trace += number;
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (HashSet<Integer> rowSet : rows) {
                if (rowSet.size() != n) {
                    duplicateRows++;
                }
            }

            for (HashSet<Integer> colSet : columns) {
                if (colSet.size() != n) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + test + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}