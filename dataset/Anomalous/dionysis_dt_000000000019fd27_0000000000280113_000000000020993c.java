import java.util.*;

public class Solution {

    private int T;
    private List<int[][]> tables = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();

        for (int i = 0; i < solution.tables.size(); i++) {
            int[][] table = solution.tables.get(i);
            int N = table.length;

            int trace = solution.calculateTrace(table);
            int duplicateRows = solution.calculateDuplicateRows(table);
            int duplicateColumns = solution.calculateDuplicateColumns(table);

            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, duplicateRows, duplicateColumns);
        }
    }

    private void readInput() {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            T = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] table = new int[N][N];

            for (int j = 0; j < N; j++) {
                String[] cells = scanner.nextLine().split(" ");
                for (int k = 0; k < N; k++) {
                    table[j][k] = Integer.parseInt(cells[k]);
                }
            }

            tables.add(table);
        }

        scanner.close();
    }

    private int calculateTrace(int[][] table) {
        int trace = 0;

        for (int i = 0; i < table.length; i++) {
            trace += table[i][i];
        }

        return trace;
    }

    private int calculateDuplicateRows(int[][] table) {
        int duplicateRows = 0;

        for (int[] row : table) {
            Set<Integer> rowSet = new HashSet<>();
            for (int cell : row) {
                rowSet.add(cell);
            }
            if (rowSet.size() < row.length) {
                duplicateRows++;
            }
        }

        return duplicateRows;
    }

    private int calculateDuplicateColumns(int[][] table) {
        int duplicateColumns = 0;

        for (int i = 0; i < table.length; i++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int[] row : table) {
                columnSet.add(row[i]);
            }
            if (columnSet.size() < table.length) {
                duplicateColumns++;
            }
        }

        return duplicateColumns;
    }
}