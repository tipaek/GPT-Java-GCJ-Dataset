import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static class Cell {
        private final boolean[] allowedValues;
        private Integer selected;
        private final List<Boolean> modifyHistory;

        public Cell(int size) {
            this.allowedValues = new boolean[size];
            Arrays.fill(allowedValues, true);
            this.modifyHistory = new ArrayList<>();
        }

        private void disallow(int i) {
            if (allowedValues[i]) {
                modifyHistory.add(true);
                allowedValues[i] = false;
            } else {
                modifyHistory.add(false);
            }
        }

        private void allow(int i) {
            if (modifyHistory.remove(modifyHistory.size() - 1)) {
                allowedValues[i] = true;
            }
        }

        public void setSelected(Integer value) {
            this.selected = value;
        }
    }

    public static class Matrix {
        private final Cell[][] cells;
        private final Set<Integer> results;

        public Matrix(int size) {
            cells = new Cell[size][size];
            results = new HashSet<>();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    cells[i][j] = new Cell(size);
                }
            }
        }

        public int getDiagSum() {
            int sum = 0;
            for (int i = 0; i < cells.length; i++) {
                sum += cells[i][i].selected;
            }
            return sum;
        }

        private void printMatrix() {
            for (Cell[] row : cells) {
                System.out.println(Stream.of(row)
                        .map(cell -> String.valueOf(cell.selected + 1))
                        .collect(Collectors.joining(" ")));
            }
        }

        public Matrix iterate(int targetDiagSum, int x, int y) {
            Cell cell = cells[x][y];
            for (int i = 0; i < cell.allowedValues.length; i++) {
                if (cell.allowedValues[i]) {
                    cell.setSelected(i);
                    for (int j = x + 1; j < cells.length; j++) {
                        cells[j][y].disallow(i);
                    }
                    for (int j = y + 1; j < cells.length; j++) {
                        cells[x][j].disallow(i);
                    }
                    if (x == cells.length - 1 && y == cells.length - 1) {
                        if (getDiagSum() == targetDiagSum) {
                            return this;
                        }
                        return null;
                    } else {
                        int nextIdx = x * cells.length + y + 1;
                        int nextX = nextIdx / cells.length;
                        int nextY = nextIdx % cells.length;
                        Matrix result = iterate(targetDiagSum, nextX, nextY);
                        if (result != null) {
                            return result;
                        }
                    }
                    cell.setSelected(null);
                    for (int j = y + 1; j < cells.length; j++) {
                        cells[x][j].allow(i);
                    }
                    for (int j = x + 1; j < cells.length; j++) {
                        cells[j][y].allow(i);
                    }
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int test = 1; test <= testCount; test++) {
            int size = scanner.nextInt();
            int diagonal = scanner.nextInt();

            Matrix matrix = new Matrix(size);
            Matrix result = matrix.iterate(diagonal, 0, 0);
            if (result != null) {
                System.out.println("Case #" + test + ": POSSIBLE");
                result.printMatrix();
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }
}