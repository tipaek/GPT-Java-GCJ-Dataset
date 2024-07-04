import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ": " + analyzeMatrix(matrixSize, scanner));
        }
    }

    private static String analyzeMatrix(int size, Scanner scanner) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        Set<Integer>[] rowSets = new HashSet[size];
        Set<Integer>[] colSets = new HashSet[size];

        for (int i = 0; i < size; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        for (int i = 0; i < size; i++) {
            boolean rowHasRepeat = false;
            boolean colHasRepeat = false;

            for (int j = 0; j < size; j++) {
                int value = scanner.nextInt();

                if (i == j) {
                    trace += value;
                }

                if (!rowSets[i].add(value)) {
                    rowHasRepeat = true;
                }

                if (!colSets[j].add(value)) {
                    colHasRepeat = true;
                }
            }

            if (rowHasRepeat) {
                rowRepeats++;
            }

            if (colHasRepeat) {
                colRepeats++;
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }
}