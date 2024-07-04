import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Vestigium {
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
        Map<Integer, Map<Integer, Integer>> rowMap = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> colMap = new HashMap<>();

        for (int i = 0; i < size; i++) {
            boolean rowRepeated = false, colRepeated = false;
            for (int j = 0; j < size; j++) {
                int value = scanner.nextInt();
                if (i == j) trace += value;

                // Analyze rows
                rowMap.putIfAbsent(i, new HashMap<>());
                if (!rowRepeated && rowMap.get(i).containsKey(value)) {
                    if (rowMap.get(i).get(value) == 1) {
                        rowRepeats++;
                        rowMap.get(i).put(value, 2);
                    }
                    rowRepeated = true;
                } else {
                    rowMap.get(i).put(value, 1);
                }

                // Analyze columns
                colMap.putIfAbsent(j, new HashMap<>());
                if (!colRepeated && colMap.get(j).containsKey(value)) {
                    if (colMap.get(j).get(value) == 1) {
                        colRepeats++;
                        colMap.get(j).put(value, 2);
                    }
                    colRepeated = true;
                } else {
                    colMap.get(j).put(value, 1);
                }
            }
            if (rowRepeated) rowRepeats++;
            if (colRepeated) colRepeats++;
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }
}