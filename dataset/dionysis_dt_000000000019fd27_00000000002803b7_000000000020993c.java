import java.util.*;

public class Solution {

    private int T;
    private ArrayList<int[][]> tables = new ArrayList<>();

    public static void main(String[] args) {

        Solution vestigium = new Solution();
        vestigium.readInput();

        //System.out.println(String.format("Number of test:\t\t%d", vestigium.T));
        //System.out.println(String.format("Number of tables:\t%d", vestigium.tables.size()));

        for (int x=0; x<vestigium.tables.size(); x++) {
            int[][] table = vestigium.tables.get(x);
            int N = table.length;
            //System.out.println(String.format("Size of table:\t\t%dX%d", N, N));

            int k = vestigium.calcTrace(table);
            int r = vestigium.calcDuplRows(table);
            int c = vestigium.calcDuplColumns(table);
            System.out.println(String.format("Case #%d: %d %d %d", x+1, k, r, c));
            //System.out.println(Arrays.deepToString(table));
        }

    }

    private void readInput() {

        //File input = Paths.get(getClass().getClassLoader().getResource("input.txt").toURI()).toFile();
        Scanner reader = new Scanner(System.in);
        String data;

        if (reader.hasNextLine()) {
            data = reader.nextLine();
            T = Integer.parseInt(data);
        }

        for (int i = 0; i < T; i++) {

            data = reader.nextLine();
            int N = Integer.parseInt(data);
            int[][] table = new int[N][N];

            for (int j = 0; j < N; j++) {

                data = reader.nextLine();
                String[] cells = data.split(" ", 0);

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
            for (int j = 0; j < table[i].length; j++) {
                if (i == j) {
                    trace += table[i][j];
                } else if (j > i) {
                    break;
                }
            }
        }

        //System.out.println(String.format("Table trace:\t\t%d", trace));
        return trace;
    }

    private int calcDuplRows(int[][] table) {
        int duplRows = 0;

        for (int i = 0; i < table.length; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < table[i].length; j++) {
                rowSet.add(table[i][j]);
            }
            if(rowSet.size()<table[i].length) duplRows++;
        }

        //System.out.println(String.format("Duplicate rows:\t\t%d", duplRows));
        return duplRows;
    }

    private int calcDuplColumns(int[][] table) {
        int duplColumns = 0;

        for (int i = 0; i < table.length; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < table[i].length; j++) {
                rowSet.add(table[j][i]);
            }
            if(rowSet.size()<table[i].length) duplColumns++;
        }

        //System.out.println(String.format("Duplicate columns:\t%d", duplColumns));
        return duplColumns;
    }

}