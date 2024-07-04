import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Program {
    public static void main(String[] args) {
        for (int o = 0; o < args.length; o++) {
            int numberOfRows = Integer.parseInt(args[o]);
            List<List<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < numberOfRows; i++) {
                String[] inputRow = args[i + o + 1].split(" ");
                List<Integer> intList = new ArrayList<>();
                for (String number : inputRow) {
                    intList.add(Integer.parseInt(number));
                }
                matrix.add(intList);
            }
            computeOutput(numberOfRows, matrix);
            o += numberOfRows;
        }
    }

    public static void computeOutput(int numberOfRows, List<List<Integer>> matrix) {
        int totalDuplicateRows = 0;
        int totalDuplicateColumns = 0;
        int sumOfDiagonal = 0;

        for (int i = 0; i < numberOfRows; i++) {
            // Check Row
            List<Integer> currentRow = matrix.get(i);
            Set<Integer> rowSet = new HashSet<>(currentRow);
            if (rowSet.size() != currentRow.size()) {
                totalDuplicateRows++;
            }

            // Check Column
            if (i < currentRow.size()) {
                sumOfDiagonal += matrix.get(i).get(i);
                List<Integer> columnList = new ArrayList<>();
                for (int x = 0; x < numberOfRows; x++) {
                    columnList.add(matrix.get(x).get(i));
                }
                Set<Integer> columnSet = new HashSet<>(columnList);
                if (columnList.size() != columnSet.size()) {
                    totalDuplicateColumns++;
                }
            }
        }
        System.out.println(sumOfDiagonal + " " + totalDuplicateRows + " " + totalDuplicateColumns);
    }
}