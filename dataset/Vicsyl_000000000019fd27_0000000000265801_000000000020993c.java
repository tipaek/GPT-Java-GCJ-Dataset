import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void solve(int[][] cells, int caze) {
        int size = cells.length;
        int rowsDuplicate = 0;
        int columnsDuplicate = 0;
        int trace = 0;
        for (int r = 0; r < size; r++) {
            trace += cells[r][r];
            Set<Integer> rowsSet = new HashSet<>();
            for (int c = 0; c < size; c++) {
                int cell = cells[r][c];
                if (rowsSet.contains(cell)) {
                    rowsDuplicate++;
                    break;
                }
                rowsSet.add(cell);
            }
            Set<Integer> columnsSet = new HashSet<>();
            for (int c = 0; c < size; c++) {
                int cell = cells[c][r];
                if (columnsSet.contains(cell)) {
                    columnsDuplicate++;
                    break;
                }
                columnsSet.add(cell);
            }
        }
        System.out.println("Case #" + caze + ": " + trace + " " + rowsDuplicate + " " + columnsDuplicate);
    }

    public static void main(String... args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        int cases = Integer.parseInt(line.trim());
        for (int i = 0; i < cases; i++) {
            line = reader.readLine();
            int size = Integer.parseInt(line.trim());
            int[][] cells = new int[size][size];
            for (int r = 0; r < size; r++) {
                String[] strs = reader.readLine().trim().split(" ");
                for (int c = 0; c < size; c++) {
                    cells[r][c] = Integer.parseInt(strs[c].trim());
                }
            }
            solve(cells, i + 1);
        }

    }
    // comment
}
