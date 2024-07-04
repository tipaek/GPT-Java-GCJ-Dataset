import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ": " + solveVestigium(matrixSize, scanner));
        }
    }

    public static String solveVestigium(int N, Scanner scanner) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        Set<Integer>[] rows = new HashSet[N];
        Set<Integer>[] cols = new HashSet[N];

        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }

        for (int i = 0; i < N; i++) {
            boolean rowRepeated = false;
            boolean colRepeated = false;
            for (int j = 0; j < N; j++) {
                int value = scanner.nextInt();
                if (i == j) {
                    trace += value;
                }

                // Analyze rows
                if (!rowRepeated && rows[i].contains(value)) {
                    rowRepeated = true;
                }
                rows[i].add(value);

                // Analyze columns
                if (!colRepeated && cols[j].contains(value)) {
                    colRepeated = true;
                }
                cols[j].add(value);
            }
            if (rowRepeated) rowRepeats++;
            if (colRepeated) colRepeats++;
        }
        return trace + " " + rowRepeats + " " + colRepeats;
    }
}