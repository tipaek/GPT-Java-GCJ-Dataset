import java.io.*;
import java.util.*;

public class Solution {

    static final int[][] NEIGHBOURS = {{-1, -1}, {-1, 0}, {0, -1}};

    static class Cell {
        int row, col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Cell cell = (Cell) obj;
            return row == cell.row && col == cell.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    static class Prev {
        Cell prevCell;
        int prevValue;

        public Prev(int row, int col, int prevValue) {
            this.prevCell = new Cell(row, col);
            this.prevValue = prevValue;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ":");
            pascalPath(scanner.nextInt());
        }
    }

    private static void pascalPath(int target) {
        List<int[]> path = new ArrayList<>();
        Map<Cell, Map<Integer, Prev>> dp = new HashMap<>();

        List<Integer> currentRow = new ArrayList<>(Collections.singletonList(1));
        int row = 0, col = 0;
        boolean found = target == 1;

        dp.put(new Cell(0, 0), new HashMap<>(Map.of(1, new Prev(-1, -1, 0))));

        while (!found) {
            row++;
            currentRow = generateNextPascalRow(currentRow);
            for (int c = 0; c < currentRow.size() && !found; c++) {
                Map<Integer, Prev> currentMap = new HashMap<>();
                for (int[] neighbour : NEIGHBOURS) {
                    if (isValidNeighbour(row, c, neighbour)) {
                        Cell neighbourCell = new Cell(row + neighbour[0], c + neighbour[1]);
                        Map<Integer, Prev> neighbourMap = dp.get(neighbourCell);
                        if (neighbourMap != null) {
                            for (Map.Entry<Integer, Prev> entry : neighbourMap.entrySet()) {
                                int newValue = entry.getKey() + currentRow.get(c);
                                if (!currentMap.containsKey(newValue)) {
                                    currentMap.put(newValue, new Prev(row + neighbour[0], c + neighbour[1], entry.getKey()));
                                }
                                if (newValue == target) {
                                    found = true;
                                    col = c;
                                    break;
                                }
                            }
                        }
                    }
                }
                dp.put(new Cell(row, c), currentMap);
            }
        }

        int currentValue = target;
        while (currentValue > 0) {
            path.add(new int[]{row, col});
            Prev prev = dp.get(new Cell(row, col)).get(currentValue);
            row = prev.prevCell.row;
            col = prev.prevCell.col;
            currentValue = prev.prevValue;
        }

        for (int i = path.size() - 1; i >= 0; i--) {
            int[] coordinates = path.get(i);
            System.out.println((coordinates[0] + 1) + " " + (coordinates[1] + 1));
        }
    }

    private static boolean isValidNeighbour(int row, int col, int[] neighbour) {
        return col + neighbour[1] >= 0 && col + neighbour[1] <= row + neighbour[0];
    }

    private static List<Integer> generateNextPascalRow(List<Integer> currentRow) {
        List<Integer> nextRow = new ArrayList<>();
        nextRow.add(1);
        for (int i = 0; i < currentRow.size() - 1; i++) {
            nextRow.add(currentRow.get(i) + currentRow.get(i + 1));
        }
        nextRow.add(1);
        return nextRow;
    }
}