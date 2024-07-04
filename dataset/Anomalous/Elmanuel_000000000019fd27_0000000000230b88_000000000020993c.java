import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ": " + solveVestigium(matrixSize, scanner));
        }
    }

    private static String solveVestigium(int matrixSize, Scanner scanner) {
        int trace = 0, rowRepeats = 0, columnRepeats = 0;
        Map<Integer, Set<Integer>> rowValues = new HashMap<>();
        Map<Integer, Set<Integer>> columnValues = new HashMap<>();
        boolean[] repeatFlags = new boolean[matrixSize * 2];

        for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
            for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                int value = scanner.nextInt();
                if (rowIndex == colIndex) {
                    trace += value;
                }

                if (!repeatFlags[rowIndex] && rowValues.containsKey(value) && rowValues.get(value).contains(rowIndex)) {
                    repeatFlags[rowIndex] = true;
                    rowRepeats++;
                } else {
                    rowValues.computeIfAbsent(value, k -> new HashSet<>()).add(rowIndex);
                }

                if (!repeatFlags[matrixSize + colIndex] && columnValues.containsKey(value) && columnValues.get(value).contains(colIndex)) {
                    repeatFlags[matrixSize + colIndex] = true;
                    columnRepeats++;
                } else {
                    columnValues.computeIfAbsent(value, k -> new HashSet<>()).add(colIndex);
                }
            }
        }
        return trace + " " + rowRepeats + " " + columnRepeats;
    }
}