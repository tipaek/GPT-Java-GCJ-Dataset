import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static class Cell {
        private final boolean[] allowedValues;
        private Integer selected;
        private List<Boolean> modify = new ArrayList<>();

        public Cell(int size) {
            this.allowedValues = new boolean[size];
            Arrays.fill(allowedValues, true);
        }

        private void disallow(int i) {
            if (this.allowedValues[i]) {
                this.modify.add(true);
                this.allowedValues[i] = false;
            } else {
                this.modify.add(false);
            }
        }

        private void allow(int i) {
            boolean action = this.modify.remove(this.modify.size() - 1);
            if (action) {
                this.allowedValues[i] = true;
            }
        }

        public void setSelected(Integer selected) {
            this.selected = selected;
        }
    }

    public static class Matrix {
        private Cell[][] cells;
        private final Set<Integer> results = new HashSet<>();

        public Matrix(int size) {
            this.cells = new Cell[size][];
            for (int i = 0; i < size; ++i) {
                this.cells[i] = new Cell[size];
                for (int j = 0; j < size; ++j) {
                    this.cells[i][j] = new Cell(size);
                }
            }
        }

        public int getDiag() {
            int sum = cells.length;
            for (int i = 0; i < cells.length; ++i) {
                sum += cells[i][i].selected;
            }
            return sum;
        }

        private void printSelf() {
            for (int i = 0; i < cells.length; ++i) {
                System.out.println(Stream.of(cells[i]).map(this::cellPrintable).map(String::valueOf).collect(Collectors.joining(" ")));
            }
        }

        private String cellPrintable(Cell c) {
            return String.valueOf(c.selected + 1);
        }

        public Matrix iterate(int size, int x, int y) {
            final Cell cell = cells[x][y];
            for (int i = 0; i < cell.allowedValues.length; ++i) {
                if (cell.allowedValues[i]) {
                    cell.setSelected(i);
                    for (int j = x + 1; j < cells.length; ++j) {
                        cells[j][y].disallow(i);
                    }
                    for (int j = y + 1; j < cells.length; ++j) {
                        cells[x][j].disallow(i);
                    }
                    int idx = x * cells.length + y;
                    if ((x == cells.length - 1) && (y == cells.length - 1)) {
                        if (getDiag() == size) {
                            return this;
                        }
                        return null;
                    } else {
                        idx += 1;
                        int y1 = idx % cells.length;
                        int x1 = idx / cells.length;
                        Matrix result = iterate(size, x1, y1);
                        if (result != null) {
                            return result;
                        }
                    }
                    cell.setSelected(null);
                    for (int j = y + 1; j < cells.length; ++j) {
                        cells[x][j].allow(i);
                    }
                    for (int j = x + 1; j < cells.length; ++j) {
                        cells[j][y].allow(i);
                    }
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int test = 1; test <= testCount; test++) {
            final int size = scanner.nextInt();
            final int diagonal = scanner.nextInt();

            final Matrix m = new Matrix(size);
            final Matrix result = m.iterate(diagonal, 0, 0);
            if (result != null) {
                System.out.println("Case #" + test + ": " + "POSSIBLE");
                result.printSelf();
            } else {
                System.out.println("Case #" + test + ": " + "IMPOSSIBLE");
            }

        }
    }

}
