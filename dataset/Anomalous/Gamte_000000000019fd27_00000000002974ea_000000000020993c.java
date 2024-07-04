import java.util.*;
import java.io.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int matrixSize = scanner.nextInt();
            int diagonalSum = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            Map<Id, ResultSet> valueMap = new HashMap<>();
            for (int i = 0; i < matrixSize; i++) {
                valueMap.put(new Id(Marker.ROW, i), new ResultSet());
                valueMap.put(new Id(Marker.COL, i), new ResultSet());
            }

            for (int row = 0, col = 0, counter = 0; counter < matrixSize * matrixSize; counter++) {
                int number = scanner.nextInt();

                Id rowId = new Id(Marker.ROW, row);
                Id colId = new Id(Marker.COL, col);

                if (!valueMap.get(rowId).hasDuplicate() && shouldIncrement(valueMap.get(rowId), number)) {
                    repeatedRows++;
                }
                if (!valueMap.get(colId).hasDuplicate() && shouldIncrement(valueMap.get(colId), number)) {
                    repeatedCols++;
                }

                if (row == col) {
                    diagonalSum += number;
                }

                if (++col == matrixSize) {
                    col = 0;
                    row++;
                }
            }
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static boolean shouldIncrement(ResultSet resultSet, int number) {
        if (resultSet.contains(number)) {
            resultSet.markDuplicate();
            return true;
        }
        resultSet.add(number);
        return false;
    }

    private static class ResultSet {
        private final Set<Integer> numbers = new HashSet<>();
        private boolean hasDuplicate = false;

        boolean contains(int number) {
            return numbers.contains(number);
        }

        void add(int number) {
            numbers.add(number);
        }

        void markDuplicate() {
            this.hasDuplicate = true;
        }

        boolean hasDuplicate() {
            return hasDuplicate;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            ResultSet resultSet = (ResultSet) obj;
            return hasDuplicate == resultSet.hasDuplicate && Objects.equals(numbers, resultSet.numbers);
        }

        @Override
        public int hashCode() {
            return Objects.hash(numbers, hasDuplicate);
        }

        @Override
        public String toString() {
            return "ResultSet{" +
                    "numbers=" + numbers +
                    ", hasDuplicate=" + hasDuplicate +
                    '}';
        }
    }

    private static class Id {
        private final Marker marker;
        private final int index;

        Id(Marker marker, int index) {
            this.marker = marker;
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Id id = (Id) obj;
            return index == id.index && marker == id.marker;
        }

        @Override
        public int hashCode() {
            return Objects.hash(marker, index);
        }

        @Override
        public String toString() {
            return "Id{" +
                    "marker=" + marker +
                    ", index=" + index +
                    '}';
        }
    }

    private enum Marker {
        ROW, COL
    }
}