import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            for (int rowIndex = 0, columnIndex = 0, numbers = 0; numbers < n * n; rowIndex++) {
                if (rowIndex == n) {
                    rowIndex = 0;
                    ++columnIndex;
                }
                matrix[columnIndex][rowIndex] = in.nextInt();
                ++numbers;
            }
            Result result = solve(matrix);
            System.out.println("Case #" + i + ": " + result.diagonalSum + " " + result.repeatedRows + " " + result.repeatedCols);

        }
    }

    private static Result solve(int[][] matrix) {
        int length = matrix[0].length;
        int repeatedRows = 0;
        int repeatedCols = 0;
        int diagonalSum = 0;
        Map<Id, ResultSet> values = new HashMap<>();
        for (int i = 0; i < length; i++) {
            values.put(new Id(Marker.ROW, i), new ResultSet());
            values.put(new Id(Marker.COL, i), new ResultSet());
        }
        for (int rowCounter = 0, colCounter = 0, counter = 0; counter < length * length; counter++) {
            int number = matrix[colCounter][rowCounter];

            Id rowId = new Id(Marker.ROW, colCounter);
            Id colId = new Id(Marker.COL, rowCounter);

            if (!values.get(rowId).isContainsDuplicatedElement() && shouldIncrement(values.get(rowId), number)) {
                repeatedRows++;
            }
            if (!values.get(colId).isContainsDuplicatedElement() && shouldIncrement(values.get(colId), number)) {
                repeatedCols++;
            }

            if (rowCounter == length - 1) {
                rowCounter = 0;
                diagonalSum += matrix[colCounter][colCounter];
                ++colCounter;
                continue;
            }
            ++rowCounter;
        }
        return new Result(repeatedRows, repeatedCols, diagonalSum);
    }

    private static boolean shouldIncrement(ResultSet resultSet, int number) {
        Set<Integer> set = resultSet.getSet();
        if (set.contains(number)) {
            resultSet.setContainsDuplicatedElement();
            return true;
        }
        set.add(number);
        return false;
    }

    private static class Result {
        private final int repeatedRows;
        private final int repeatedCols;
        private final int diagonalSum;

        Result(int repeatedRows, int repeatedCols, int diagonalSum) {
            this.repeatedRows = repeatedRows;
            this.repeatedCols = repeatedCols;
            this.diagonalSum = diagonalSum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result = (Result) o;
            return repeatedRows == result.repeatedRows &&
                    repeatedCols == result.repeatedCols &&
                    diagonalSum == result.diagonalSum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(repeatedRows, repeatedCols, diagonalSum);
        }
    }

    private static class ResultSet {
        private final Set<Integer> set = new HashSet<>();
        private boolean containsDuplicatedElement = false;

        Set<Integer> getSet() {
            return set;
        }

        public void addToSet(int num) {
            set.add(num);
        }

        boolean isContainsDuplicatedElement() {
            return containsDuplicatedElement;
        }

        void setContainsDuplicatedElement() {
            this.containsDuplicatedElement = true;
        }

        @Override
        public String toString() {
            return "ResultSet{" +
                    "set=" + set +
                    ", containsDuplicatedElement=" + containsDuplicatedElement +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ResultSet resultSet = (ResultSet) o;
            return containsDuplicatedElement == resultSet.containsDuplicatedElement &&
                    Objects.equals(set, resultSet.set);
        }

        @Override
        public int hashCode() {
            return Objects.hash(set, containsDuplicatedElement);
        }
    }

    static class Id {
        private final Marker marker;
        private final int id;

        Id(Marker marker, int id) {
            this.marker = marker;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Id{" +
                    "marker=" + marker +
                    ", id=" + id +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id1 = (Id) o;
            return id == id1.id &&
                    marker == id1.marker;
        }

        @Override
        public int hashCode() {
            return Objects.hash(marker, id);
        }
    }

    enum Marker {
        ROW,
        COL
    }
}