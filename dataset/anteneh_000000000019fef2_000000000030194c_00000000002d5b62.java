import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String result = "";

        for (int i = 0; i < numberOfTestCases; i++) {
            String testCase = scanner.nextLine();
            result = result + "Case #" + (i + 1) + ": " + getCoordinates(testCase);
            result += (i != numberOfTestCases - 1) ? "\n" : "";
        }
        System.out.println(result);
    }


    public static String getCoordinates(String input) {

        int reqColumn = Integer.parseInt(input.split(" ")[1]);
        int reqRow = Integer.parseInt(input.split(" ")[0]);

        HashSet<Cell> visited = new HashSet<>();
        LinkedList<Cell> queue = new LinkedList<>();
        Cell start = new Cell(0, 0, 0, "");
        queue.add(start);

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            visited.add(current);
//            System.out.println("Current is " + current);
            if (current.row == reqColumn && current.column == reqRow) {
                return current.path;
            }
            if(Math.abs(current.row) > Math.abs(reqColumn)&& Math.abs(current.column) > Math.abs(reqRow)){
                return "IMPOSSIBLE";
            }

            int topNeighRow = (int) (current.row + Math.pow(2, current.incomingLength));
            if (topNeighRow < 1000000000) {
                Cell topNeighbour = new Cell(topNeighRow, current.column, current.incomingLength + 1, current.path + "N");
                if (!visited.contains(topNeighbour)) {
                    queue.add(topNeighbour);
                }
            }

            int bottomNeighRow = (int) (current.row - Math.pow(2, current.incomingLength));
            if (bottomNeighRow > -1000000000) {
                Cell bottomNeighBour = new Cell(bottomNeighRow, current.column, current.incomingLength + 1, current.path + "S");
                if (!visited.contains(bottomNeighBour)) {
                    queue.add(bottomNeighBour);
                }
            }

            int leftNeighColumn = (int) (current.column - Math.pow(2, current.incomingLength));
            if (leftNeighColumn > -1000000000) {
                Cell leftNeighBour = new Cell(current.row, leftNeighColumn, current.incomingLength + 1, current.path + "W");
                if (!visited.contains(leftNeighBour)) {
                    queue.add(leftNeighBour);
                }
            }
            int rightNeighCol = (int) (current.column + Math.pow(2, current.incomingLength));
            if (rightNeighCol < 1000000000) {
                Cell rightNeighBour = new Cell(current.row, rightNeighCol, current.incomingLength + 1, current.path + "E");
                if (!visited.contains(rightNeighBour)) {
                    queue.add(rightNeighBour);
                }
            }
        }
        return "IMPOSSIBLE";


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

    public boolean equals(Object o) {
        Cell newObject = (Cell) o;
        return (this.row == newObject.row && this.column == newObject.column) && this.incomingLength == newObject.incomingLength;
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