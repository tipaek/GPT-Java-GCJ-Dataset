import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;

        for (int i = 0; i < cases; i++) {
            String[] dimensions = scanner.nextLine().split(" ");
            int row = Integer.parseInt(dimensions[0]);
            int col = Integer.parseInt(dimensions[1]);
            System.out.println("Case #" + (i + 1) + ": " + processCase(scanner, row, col));
        }
    }

    private static String processCase(Scanner scanner, int row, int col) {
        Set<String> activeCells = new HashSet<>();
        Map<String, Integer> cellValues = new HashMap<>();
        int totalValue = 0;

        for (int i = 0; i < row; i++) {
            String[] values = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                String cell = getCellKey(i, j);
                int value = Integer.parseInt(values[j]);
                activeCells.add(cell);
                cellValues.put(cell, value);
                totalValue += value;
            }
        }

        boolean hasChanges;
        do {
            hasChanges = false;
            int tempTotalValue = 0;
            Set<String> nextActiveCells = new HashSet<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    String cell = getCellKey(i, j);
                    if (activeCells.contains(cell) && isValidCell(i, j, row, col, activeCells, cellValues)) {
                        nextActiveCells.add(cell);
                        tempTotalValue += cellValues.get(cell);
                    } else if (activeCells.contains(cell)) {
                        hasChanges = true;
                    }
                }
            }

            activeCells = nextActiveCells;
            if (hasChanges) {
                totalValue += tempTotalValue;
            }
        } while (hasChanges);

        return Integer.toString(totalValue);
    }

    private static boolean isValidCell(int i, int j, int row, int col, Set<String> activeCells, Map<String, Integer> cellValues) {
        long sum = 0;
        int count = 0;

        sum += getNeighborValue(i, j - 1, row, col, activeCells, cellValues);
        sum += getNeighborValue(i, j + 1, row, col, activeCells, cellValues);
        sum += getNeighborValue(i - 1, j, row, col, activeCells, cellValues);
        sum += getNeighborValue(i + 1, j, row, col, activeCells, cellValues);

        count += activeCells.contains(getCellKey(i, j - 1)) ? 1 : 0;
        count += activeCells.contains(getCellKey(i, j + 1)) ? 1 : 0;
        count += activeCells.contains(getCellKey(i - 1, j)) ? 1 : 0;
        count += activeCells.contains(getCellKey(i + 1, j)) ? 1 : 0;

        return count == 0 || cellValues.get(getCellKey(i, j)) * count >= sum;
    }

    private static int getNeighborValue(int i, int j, int row, int col, Set<String> activeCells, Map<String, Integer> cellValues) {
        String cell = getCellKey(i, j);
        return (i >= 0 && i < row && j >= 0 && j < col && activeCells.contains(cell)) ? cellValues.get(cell) : 0;
    }

    private static String getCellKey(int i, int j) {
        return i + "," + j;
    }
}