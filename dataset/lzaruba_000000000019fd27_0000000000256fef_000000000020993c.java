import java.util.*;
import java.io.*;

public class Solution {

    private static class Matrix {

        private final int id;
        private final int size;

        private Set[] rows;
        private Set[] columns;

        private int trace = 0;

        public Matrix(int id, int size) {
            this.id = id;
            this.size = size;
            rows = new Set[size];
            columns = new Set[size];
            for (int i = 0; i < size; i++) {
                rows[i] = new HashSet<Integer>();
                columns[i] = new HashSet<Integer>();
            }
        }

        public void pushValue(int row, int column, int value) {
            if (row == column) {
                this.trace += value;
            }
            rows[row].add(value);
            columns[column].add(value);
        }

        @Override
        public String toString() {
            return "\nMatrix " + id + ": size=" +
                    size;
        }

        public void output() {
            int rowsCount = 0;
            int columnsCount = 0;
            for (int i = 0; i < size; i++) {
                if (rows[i].size() != size) {
                    rowsCount++;
                }
                if (columns[i].size() != size) {
                    columnsCount++;
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d", id, trace, rowsCount, columnsCount));
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int casesCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<Matrix> matrices = new ArrayList<>();
        for (int caseId = 1; caseId <= casesCount; caseId++) {
            int size = in.nextInt();
            Matrix matrix = new Matrix(caseId, size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix.pushValue(i, j, in.nextInt());
                }
            }
            matrices.add(matrix);
        }

        matrices.forEach(Matrix::output);
    }

}
