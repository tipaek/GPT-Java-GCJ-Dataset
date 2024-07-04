import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            List<List> rows = new ArrayList<>();
            List<List> columns = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                List<Integer> row = new ArrayList<>();
                rows.add(row);
                List<Integer> column= new ArrayList<>();
                columns.add(column);
            }

            int trace = 0;
            List<Integer> duplicateRowIndex = new ArrayList<>();
            List<Integer> duplicateColumnIndex = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int ij = sc.nextInt();

                    List<Integer> row_i = rows.get(i);
                    List<Integer> column_j = columns.get(j);

                    if (row_i.contains(ij)) {
                        if (!duplicateRowIndex.contains(i)) duplicateRowIndex.add(i);
                    }

                    if (column_j.contains(ij)) {
                        if (!duplicateColumnIndex.contains(j)) duplicateColumnIndex.add(j);
                    }

                    if (i == j) {
                        trace += ij;
                    }

                    row_i.add(ij);
                    column_j.add(ij);
                }
            }

            String line = "Case #" + test_case + ": " +  trace + " " + duplicateRowIndex.size() + " " + duplicateColumnIndex.size() + " " + "\n";
            System.out.print(line);
        }
    }
}
