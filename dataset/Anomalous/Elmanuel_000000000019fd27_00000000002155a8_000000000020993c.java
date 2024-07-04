import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ": " + analyzeMatrix(matrixSize, scanner));
        }
    }

    public static String analyzeMatrix(int size, Scanner scanner) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        Set<Integer>[] rowSets = new HashSet[size];
        Set<Integer>[] colSets = new HashSet[size];

        for (int i = 0; i < size; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        for (int i = 0; i < size; i++) {
            boolean rowHasDuplicates = false;
            boolean colHasDuplicates = false;

            for (int j = 0; j < size; j++) {
                int value = scanner.nextInt();
                if (i == j) trace += value;

                // Check rows for duplicates
                if (!rowHasDuplicates && rowSets[i].contains(value)) {
                    rowHasDuplicates = true;
                } else {
                    rowSets[i].add(value);
                }

                // Check columns for duplicates
                if (!colHasDuplicates && colSets[j].contains(value)) {
                    colHasDuplicates = true;
                } else {
                    colSets[j].add(value);
                }
            }
            if (rowHasDuplicates) rowRepeats++;
            if (colHasDuplicates) colRepeats++;
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }
}