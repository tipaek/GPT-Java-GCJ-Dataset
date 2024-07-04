import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Program {
    public static void main(String[] args) {
        int argIndex = 0;
        
        while (argIndex < args.length) {
            int numberOfRows = Integer.parseInt(args[argIndex]);
            List<List<Integer>> matrix = new ArrayList<>();
            
            for (int i = 0; i < numberOfRows; i++) {
                String[] inputRow = args[argIndex + 1 + i].split(" ");
                List<Integer> intList = new ArrayList<>();
                
                for (String number : inputRow) {
                    intList.add(Integer.parseInt(number));
                }
                
                matrix.add(intList);
            }
            
            computeOutput(numberOfRows, matrix);
            argIndex += numberOfRows + 1;
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
            List<Integer> columnList = new ArrayList<>();
            
            for (int j = 0; j < numberOfRows; j++) {
                columnList.add(matrix.get(j).get(i));
            }
            
            Set<Integer> columnSet = new HashSet<>(columnList);
            
            if (columnSet.size() != columnList.size()) {
                totalDuplicateColumns++;
            }
            
            // Sum of Diagonal
            sumOfDiagonal += matrix.get(i).get(i);
        }
        
        System.out.println(sumOfDiagonal + " " + totalDuplicateRows + " " + totalDuplicateColumns);
    }
}