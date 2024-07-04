import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine();

            HashSet<Integer>[] rowSets = new HashSet[matrixSize];
            HashSet<Integer>[] colSets = new HashSet[matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                rowSets[i] = new HashSet<>();
                colSets[i] = new HashSet<>();
            }

            int trace = 0;

            for (int i = 0; i < matrixSize; i++) {
                String[] rowValues = scanner.nextLine().trim().split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    int value = Integer.parseInt(rowValues[j]);
                    rowSets[i].add(value);
                    colSets[j].add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            for (HashSet<Integer> rowSet : rowSets) {
                if (rowSet.size() != matrixSize) {
                    duplicateRows++;
                }
            }

            for (HashSet<Integer> colSet : colSets) {
                if (colSet.size() != matrixSize) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}