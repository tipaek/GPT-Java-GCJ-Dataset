import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Set up input scanner
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Receive first line (How many cases?)
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            processCase(caseNumber, scanner);
        }
    }

    public static void processCase(int caseNumber, Scanner scanner) {
        int matrixSize = scanner.nextInt();

        HashSet<Integer>[] rowSets = new HashSet[matrixSize];
        HashSet<Integer>[] columnSets = new HashSet[matrixSize];
        int diagonalSum = 0;
        int rowDuplicates = 0;
        int columnDuplicates = 0;

        for (int i = 0; i < matrixSize; i++) {
            rowSets[i] = new HashSet<>();
            columnSets[i] = new HashSet<>();
        }

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int currentNumber = scanner.nextInt();
                if (i == j) {
                    diagonalSum += currentNumber;
                }

                rowSets[i].add(currentNumber);
                columnSets[j].add(currentNumber);
            }
        }

        for (HashSet<Integer> rowSet : rowSets) {
            if (rowSet.size() != matrixSize) {
                rowDuplicates++;
            }
        }

        for (HashSet<Integer> columnSet : columnSets) {
            if (columnSet.size() != matrixSize) {
                columnDuplicates++;
            }
        }

        String result = diagonalSum + " " + rowDuplicates + " " + columnDuplicates;
        printResult(caseNumber, result);
    }

    public static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}