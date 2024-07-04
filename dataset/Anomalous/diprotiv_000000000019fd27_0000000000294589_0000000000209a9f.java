import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static class Cell {
        private String value;

        public Cell(String value) {
            this.value = value;
        }

        public void prependLeftParenthesis() {
            value = '(' + value;
        }

        public void appendRightParenthesis() {
            value = value + ')';
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        for (int t = 1; t <= testCases; t++) {
            String input = bufferedReader.readLine();
            Cell[] balancedCells = generateBalancedCells(input);
            System.out.print(String.format("Case #%d: ", t));
            for (Cell cell : balancedCells) {
                if (cell != null) {
                    System.out.print(cell);
                }
            }
            System.out.println();
        }
    }

    private static Cell[] generateBalancedCells(String input) {
        Cell[][] cellMatrix = new Cell[10][input.length()];
        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';
            cellMatrix[digit][i] = new Cell(String.valueOf(input.charAt(i)));
        }

        for (int level = 9; level > 0; level--) {
            processLevel(cellMatrix[level]);
            for (int i = 0; i < input.length(); i++) {
                if (cellMatrix[level - 1][i] == null) {
                    cellMatrix[level - 1][i] = cellMatrix[level][i];
                }
            }
        }
        return cellMatrix[0];
    }

    private static void processLevel(Cell[] cells) {
        int i = 0;
        while (i < cells.length) {
            if (cells[i] != null) {
                int j = i + 1;
                while (j < cells.length && cells[j] != null) {
                    j++;
                }
                cells[i].prependLeftParenthesis();
                cells[j - 1].appendRightParenthesis();
                i = j;
            } else {
                i++;
            }
        }
    }
}