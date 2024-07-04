import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();

            int diagonal = 0;
            int row = 0;
            int column = 0;

            Map<Integer, List<Integer>> columnCells = new HashMap<>();
            List<Integer> addedColumns = new ArrayList<>();

            for (int y = 0; y < size; y++) {
                List<Integer> rowCells = new ArrayList<>();
                boolean addedRow = false;

                for (int x = 0; x < size; x++) {
                    int cell = in.nextInt();

                    if (rowCells.contains(cell)) {
                        if (!addedRow) {
                            row++;
                            addedRow = true;
                        }
                    } else {
                        rowCells.add(cell);
                    }

                    List<Integer> columnCellsList;
                    if (!columnCells.containsKey(x)) {
                        columnCellsList = new ArrayList<>();
                        columnCells.put(x, columnCellsList);
                    } else {
                        columnCellsList = columnCells.get(x);
                    }

                    if (columnCellsList.contains(cell)) {
                        if (!addedColumns.contains(x)) {
                            column++;
                            addedColumns.add(x);
                        }
                    } else {
                        columnCellsList.add(cell);
                    }

                    if (x == y) {
                        diagonal += cell;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", i, diagonal, row, column);
        }
    }
}
