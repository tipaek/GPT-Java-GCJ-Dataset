import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Program {
    public static void main(String[] args) {
        int caseNumber = 1;
        for (int i = 1; i < args.length; ) {
            int numberOfRows = Integer.parseInt(args[i]);
            List<List<Integer>> matrix = new ArrayList<>();

            for (int j = 0; j < numberOfRows; j++) {
                String[] inputRow = args[i + j + 1].split(" ");
                List<Integer> intList = new ArrayList<>();
                for (String number : inputRow) {
                    intList.add(Integer.valueOf(number));
                }
                matrix.add(intList);
            }

            computeOutput(caseNumber, numberOfRows, matrix);
            i += numberOfRows + 1;
            caseNumber++;
        }
    }

    public static void computeOutput(int caseNumber, int numberOfRows, List<List<Integer>> matrix) {
        int duplicateRows = 0;
        int duplicateColumns = 0;
        int diagonalSum = 0;

        for (int i = 0; i < numberOfRows; i++) {
            // Check Row for duplicates
            List<Integer> row = matrix.get(i);
            Set<Integer> rowSet = new HashSet<>(row);
            if (rowSet.size() != row.size()) {
                duplicateRows++;
            }

            // Check Column for duplicates
            List<Integer> column = new ArrayList<>();
            for (int j = 0; j < numberOfRows; j++) {
                column.add(matrix.get(j).get(i));
            }
            Set<Integer> columnSet = new HashSet<>(column);
            if (columnSet.size() != column.size()) {
                duplicateColumns++;
            }

            // Sum of Diagonal
            diagonalSum += matrix.get(i).get(i);
        }

        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
    }
}