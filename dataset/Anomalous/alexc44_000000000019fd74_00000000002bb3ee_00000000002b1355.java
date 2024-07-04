import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

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

    public static int processCase(Scanner scanner, int row, int col) {
        HashSet<String> activeCells = new HashSet<>();
        HashMap<String, Integer> cellValues = new HashMap<>();
        int totalValue = 0;

        for (int i = 0; i < row; i++) {
            String[] values = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                String loc = getCellLocation(i, j);
                int value = Integer.parseInt(values[j]);
                activeCells.add(loc);
                cellValues.put(loc, value);
                totalValue += value;
            }
        }

        boolean updates = true;
        while (updates) {
            int tempValue = 0;
            boolean hasUpdates = false;
            HashSet<String> nextActiveCells = new HashSet<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    String loc = getCellLocation(i, j);
                    if (activeCells.contains(loc)) {
                        if (isValidNeighbor(i, j, row, col, activeCells, cellValues)) {
                            nextActiveCells.add(loc);
                            tempValue += cellValues.get(loc);
                        } else {
                            hasUpdates = true;
                        }
                    }
                }
            }

            activeCells = nextActiveCells;
            updates = hasUpdates;
            if (updates) {
                totalValue += tempValue;
            }
        }

        return totalValue;
    }

    public static boolean isValidNeighbor(int i, int j, int row, int col, HashSet<String> activeCells, HashMap<String, Integer> cellValues) {
        int sum = 0;
        int count = 0;

        int[] directions = {-1, 1};
        for (int dir : directions) {
            int curr = j + dir;
            while (curr >= 0 && curr < col) {
                String loc = getCellLocation(i, curr);
                if (activeCells.contains(loc)) {
                    sum += cellValues.get(loc);
                    count++;
                    break;
                }
                curr += dir;
            }

            curr = i + dir;
            while (curr >= 0 && curr < row) {
                String loc = getCellLocation(curr, j);
                if (activeCells.contains(loc)) {
                    sum += cellValues.get(loc);
                    count++;
                    break;
                }
                curr += dir;
            }
        }

        if (count == 0) {
            return true;
        } else {
            return cellValues.get(getCellLocation(i, j)) >= (double) sum / count;
        }
    }

    public static String getCellLocation(int i, int j) {
        return i + "," + j;
    }
}