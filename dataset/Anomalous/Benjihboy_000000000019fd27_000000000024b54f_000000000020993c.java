import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        try (BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            int numberOfTestCases;

            if ((line = stdin.readLine()) != null && !line.isEmpty()) {
                numberOfTestCases = Integer.parseInt(line);
            } else {
                return;
            }

            for (int t = 0; t < numberOfTestCases; t++) {
                if ((line = stdin.readLine()) != null && !line.isEmpty()) {
                    int numberOfRows = Integer.parseInt(line);
                    List<List<Integer>> matrix = new ArrayList<>();

                    for (int i = 0; i < numberOfRows; i++) {
                        line = stdin.readLine();
                        String[] inputRow = line.split(" ");
                        List<Integer> intList = new ArrayList<>();
                        for (String number : inputRow) {
                            intList.add(Integer.valueOf(number));
                        }
                        matrix.add(intList);
                    }
                    computeOutput(numberOfRows, matrix);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void computeOutput(int numberOfRows, List<List<Integer>> matrix) {
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
            sumOfDiagonal += matrix.get(i).get(i);
            List<Integer> columnList = new ArrayList<>();
            for (int j = 0; j < numberOfRows; j++) {
                columnList.add(matrix.get(j).get(i));
            }
            Set<Integer> columnSet = new HashSet<>(columnList);
            if (columnSet.size() != columnList.size()) {
                totalDuplicateColumns++;
            }
        }

        System.out.println(sumOfDiagonal + " " + totalDuplicateRows + " " + totalDuplicateColumns);
    }
}