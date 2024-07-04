import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int a = 1; a <= t; ++a) {
            int N = in.nextInt();
            int diagonalCounter = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;
            int diagonalSum = 0;
            Map<Id, ResultSet> values = new HashMap<>();
            for (int i = 0; i < N; i++) {
                values.put(new Id(Marker.ROW, i), new ResultSet());
                values.put(new Id(Marker.COL, i), new ResultSet());
            }
            for (int rowCounter = 0, colCounter = 0, counter = 0; counter < N * N; counter++, diagonalCounter++) {
                int number = in.nextInt();

                Id rowId = new Id(Marker.ROW, colCounter);
                Id colId = new Id(Marker.COL, rowCounter);

                if (!values.get(rowId).isContainsDuplicatedElement() && shouldIncrement(values.get(rowId), number)) {
                    repeatedRows++;
                }
                if (!values.get(colId).isContainsDuplicatedElement() && shouldIncrement(values.get(colId), number)) {
                    repeatedCols++;
                }

                if (diagonalCounter == N + 1) {
                    diagonalCounter = 0;
                }
                if (diagonalCounter == 0) {
                    diagonalSum += number;
                }
                if (rowCounter == N - 1) {
                    rowCounter = 0;
                    ++colCounter;
                    continue;
                }
                ++rowCounter;
            }
            System.out.println("Case #" + a + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);

        }
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

    private static class ResultSet {
        private final Set<Integer> set = new HashSet<>();
        private boolean containsDuplicatedElement = false;

        Set<Integer> getSet() {
            return set;
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