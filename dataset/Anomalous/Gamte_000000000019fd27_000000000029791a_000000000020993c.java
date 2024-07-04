import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int diagonalSum = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            Map<Identifier, ResultSet> valueMap = new HashMap<>();
            for (int i = 0; i < matrixSize; i++) {
                valueMap.put(new Identifier(Type.ROW, i), new ResultSet());
                valueMap.put(new Identifier(Type.COL, i), new ResultSet());
            }

            for (int row = 0, col = 0, cell = 0; cell < matrixSize * matrixSize; cell++) {
                int number = scanner.nextInt();

                Identifier rowId = new Identifier(Type.ROW, col);
                Identifier colId = new Identifier(Type.COL, row);

                if (!valueMap.get(rowId).hasDuplicate() && checkAndAdd(valueMap.get(rowId), number)) {
                    repeatedRows++;
                }
                if (!valueMap.get(colId).hasDuplicate() && checkAndAdd(valueMap.get(colId), number)) {
                    repeatedCols++;
                }

                if (cell % (matrixSize + 1) == 0) {
                    diagonalSum += number;
                }

                if (row == matrixSize - 1) {
                    row = 0;
                    col++;
                } else {
                    row++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static boolean checkAndAdd(ResultSet resultSet, int number) {
        Set<Integer> set = resultSet.getSet();
        if (set.contains(number)) {
            resultSet.markDuplicate();
            return true;
        }
        set.add(number);
        return false;
    }

    private static class ResultSet {
        private final Set<Integer> set = new HashSet<>();
        private boolean hasDuplicate = false;

        Set<Integer> getSet() {
            return set;
        }

        boolean hasDuplicate() {
            return hasDuplicate;
        }

        void markDuplicate() {
            this.hasDuplicate = true;
        }
    }

    private static class Identifier {
        private final Type type;
        private final int index;

        Identifier(Type type, int index) {
            this.type = type;
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Identifier that = (Identifier) obj;
            return index == that.index && type == that.type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, index);
        }
    }

    private enum Type {
        ROW, COL
    }
}