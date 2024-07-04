import java.util.*;

public class Solution {

    private int T;
    private List<int[][]> tables = new ArrayList<>();

    public static void main(String[] args) {
        Solution vestigium = new Solution();
        vestigium.readInput();

        for (int x = 0; x < vestigium.tables.size(); x++) {
            int[][] table = vestigium.tables.get(x);
            int N = table.length;

            int k = vestigium.calcTrace(table);
            int r = vestigium.calcDuplRows(table);
            int c = vestigium.calcDuplColumns(table);
            System.out.println(String.format("Case #%d: %d %d %d", x + 1, k, r, c));
        }
    }

    private void readInput() {
        Scanner reader = new Scanner(System.in);

        if (reader.hasNextLine()) {
            T = Integer.parseInt(reader.nextLine());
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.nextLine());
            int[][] table = new int[N][N];

            for (int j = 0; j < N; j++) {
                String[] cells = reader.nextLine().split(" ");
                for (int k = 0; k < N; k++) {
                    table[j][k] = Integer.parseInt(cells[k]);
                }
            }
            tables.add(table);
        }

        reader.close();
    }

    private int calcTrace(int[][] table) {
        int trace = 0;
        for (int i = 0; i < table.length; i++) {
            trace += table[i][i];
        }
        return trace;
    }

    private int calcDuplRows(int[][] table) {
        int duplRows = 0;
        for (int[] row : table) {
            Set<Integer> rowSet = new HashSet<>();
            for (int cell : row) {
                rowSet.add(cell);
            }
            if (rowSet.size() < row.length) duplRows++;
        }
        return duplRows;
    }

    private int calcDuplColumns(int[][] table) {
        int duplColumns = 0;
        int N = table.length;
        for (int i = 0; i < N; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                colSet.add(table[j][i]);
            }
            if (colSet.size() < N) duplColumns++;
        }
        return duplColumns;
    }
}