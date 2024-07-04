import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ": " + solveVestigium(matrixSize, scanner));
        }
    }

    public static String solveVestigium(int n, Scanner scanner) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        Map<Integer, Map<Integer, Integer>> rowMap = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> colMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            boolean rowRepeated = false, colRepeated = false;
            for (int j = 0; j < n; j++) {
                int value = scanner.nextInt();
                if (i == j) {
                    trace += value;
                }

                // Check for row repeats
                rowMap.putIfAbsent(i, new HashMap<>());
                if (!rowRepeated && rowMap.get(i).containsKey(value)) {
                    rowRepeats++;
                    rowRepeated = true;
                }
                rowMap.get(i).put(value, 1);

                // Check for column repeats
                colMap.putIfAbsent(j, new HashMap<>());
                if (!colRepeated && colMap.get(j).containsKey(value)) {
                    colRepeats++;
                    colRepeated = true;
                }
                colMap.get(j).put(value, 1);
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }
}