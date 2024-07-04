import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numberOfTestCases; i++) {
            String testCase = scanner.nextLine();
            result.append("Case #").append(i + 1).append(": ").append(getCoordinates(testCase));
            if (i != numberOfTestCases - 1) {
                result.append("\n");
            }
        }
        System.out.println(result.toString());
    }

    public static String getCoordinates(String input) {
        String[] parts = input.split(" ");
        int reqRow = Integer.parseInt(parts[0]);
        int reqColumn = Integer.parseInt(parts[1]);

        HashSet<Cell> visited = new HashSet<>();
        LinkedList<Cell> queue = new LinkedList<>();
        Cell start = new Cell(0, 0, 0, "");
        queue.add(start);

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            visited.add(current);

            if (current.row == reqRow && current.column == reqColumn) {
                return current.path;
            }
            if (Math.abs(current.row) > Math.abs(reqRow) && Math.abs(current.column) > Math.abs(reqColumn)) {
                return "IMPOSSIBLE";
            }

            int stepSize = (int) Math.pow(2, current.incomingLength);

            addCellToQueue(queue, visited, new Cell(current.row + stepSize, current.column, current.incomingLength + 1, current.path + "N"));
            addCellToQueue(queue, visited, new Cell(current.row - stepSize, current.column, current.incomingLength + 1, current.path + "S"));
            addCellToQueue(queue, visited, new Cell(current.row, current.column - stepSize, current.incomingLength + 1, current.path + "W"));
            addCellToQueue(queue, visited, new Cell(current.row, current.column + stepSize, current.incomingLength + 1, current.path + "E"));
        }
        return "IMPOSSIBLE";
    }

    private static void addCellToQueue(LinkedList<Cell> queue, HashSet<Cell> visited, Cell cell) {
        if (!visited.contains(cell) && Math.abs(cell.row) < 1000000000 && Math.abs(cell.column) < 1000000000) {
            queue.add(cell);
        }
    }
}

class Cell {
    int row;
    int column;
    int incomingLength;
    String path;

    public Cell(int row, int column, int incomingLength, String path) {
        this.row = row;
        this.column = column;
        this.incomingLength = incomingLength;
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return row == cell.row && column == cell.column && incomingLength == cell.incomingLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, incomingLength);
    }

    @Override
    public String toString() {
        return row + " , " + column + " => " + incomingLength + " --  " + path;
    }
}