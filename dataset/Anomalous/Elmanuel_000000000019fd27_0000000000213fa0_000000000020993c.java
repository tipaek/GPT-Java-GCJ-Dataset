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
            System.out.println("Case #" + caseNumber + ": " + solveVestigium(matrixSize, scanner));
        }
    }

    public static String solveVestigium(int matrixSize, Scanner scanner) {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        Map<Integer, Set<Integer>> rowValues = new HashMap<>();
        Map<Integer, Set<Integer>> colValues = new HashMap<>();

        for (int i = 0; i < matrixSize; i++) {
            boolean rowHasRepeat = false;
            boolean colHasRepeat = false;

            for (int j = 0; j < matrixSize; j++) {
                int value = scanner.nextInt();

                if (i == j) {
                    trace += value;
                }

                // Check for row repeats
                rowValues.putIfAbsent(i, new HashSet<>());
                if (!rowHasRepeat && !rowValues.get(i).add(value)) {
                    rowHasRepeat = true;
                }

                // Check for column repeats
                colValues.putIfAbsent(j, new HashSet<>());
                if (!colHasRepeat && !colValues.get(j).add(value)) {
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