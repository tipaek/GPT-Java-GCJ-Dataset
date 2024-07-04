import java.util.*;

class Program {
    public static void main(String[] args) {
        int caseNumber = 1;
        for (int i = 0; i < args.length; ) {
            int numberOfRows = Integer.parseInt(args[i]);
            List<List<Integer>> matrix = new ArrayList<>();

            for (int j = 0; j < numberOfRows; j++) {
                String[] inputRow = args[i + j + 1].split(" ");
                List<Integer> row = new ArrayList<>();
                for (String num : inputRow) {
                    row.add(Integer.parseInt(num));
                }
                matrix.add(row);
            }

            computeOutput(caseNumber, numberOfRows, matrix);
            i += numberOfRows + 1;
            caseNumber++;
        }
    }

    public static void computeOutput(int caseNumber, int numberOfRows, List<List<Integer>> matrix) {
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
            List<Integer> columnList = new ArrayList<>();
            for (int j = 0; j < numberOfRows; j++) {
                columnList.add(matrix.get(j).get(i));
            }
            Set<Integer> columnSet = new HashSet<>(columnList);
            if (columnSet.size() != columnList.size()) {
                totalDuplicateColumns++;
            }

            // Sum Diagonal
            sumOfDiagonal += matrix.get(i).get(i);
        }

        System.out.println("Case #" + caseNumber + ": " + sumOfDiagonal + " " + totalDuplicateRows + " " + totalDuplicateColumns);
    }
}