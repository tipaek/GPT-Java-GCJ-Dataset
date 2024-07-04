import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
                int matrixSize = scanner.nextInt();
                int trace = 0;
                List<Set<Integer>> columnSets = new ArrayList<>();
                Set<Integer> rowsWithDuplicates = new HashSet<>();
                Set<Integer> columnsWithDuplicates = new HashSet<>();
                
                for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int columnIndex = 0; columnIndex < matrixSize; columnIndex++) {
                        if (columnSets.size() <= columnIndex) {
                            columnSets.add(new HashSet<>());
                        }
                        
                        int element = scanner.nextInt();
                        if (rowIndex == columnIndex) {
                            trace += element;
                        }
                        if (!rowSet.add(element)) {
                            rowsWithDuplicates.add(rowIndex);
                        }
                        if (!columnSets.get(columnIndex).add(element)) {
                            columnsWithDuplicates.add(columnIndex);
                        }
                    }
                }

                String result = String.format("%d %d %d", trace, rowsWithDuplicates.size(), columnsWithDuplicates.size());
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }
}