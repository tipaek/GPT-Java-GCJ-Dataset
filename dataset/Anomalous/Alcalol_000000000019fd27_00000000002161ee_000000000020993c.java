import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Set up input scanner
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Receive first line (How many cases?)
        int caseCount = scanner.nextInt();

        for (int i = 1; i <= caseCount; i++) {
            processCase(i, scanner);
        }
    }

    private static void processCase(int caseNumber, Scanner scanner) {
        int matrixSize = scanner.nextInt();

        HashSet<Integer>[] rowSets = new HashSet[matrixSize];
        HashSet<Integer>[] colSets = new HashSet[matrixSize];
        int diagonalSum = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < matrixSize; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int currentNumber = scanner.nextInt();
                if (i == j) {
                    diagonalSum += currentNumber;
                }
                rowSets[i].add(currentNumber);
                colSets[j].add(currentNumber);
            }
        }

        for (HashSet<Integer> rowSet : rowSets) {
            if (rowSet.size() != matrixSize) {
                rowDuplicates++;
            }
        }

        for (HashSet<Integer> colSet : colSets) {
            if (colSet.size() != matrixSize) {
                colDuplicates++;
            }
        }

        String result = diagonalSum + " " + rowDuplicates + " " + colDuplicates;
        printResult(caseNumber, result);
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}