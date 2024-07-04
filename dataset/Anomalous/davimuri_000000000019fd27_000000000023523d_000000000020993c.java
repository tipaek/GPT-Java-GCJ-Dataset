import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int caseNumber, Scanner scanner) {
        int n = scanner.nextInt();
        int diagonalSum = 0;
        Set<Integer>[] rowSets = new Set[n];
        Set<Integer>[] colSets = new Set[n];
        for (int i = 0; i < n; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }
        int[] rowRepeats = new int[n];
        int[] colRepeats = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = scanner.nextInt();
                if (i == j) {
                    diagonalSum += value;
                }
                if (!rowSets[i].add(value)) {
                    rowRepeats[i] = 1;
                }
                if (!colSets[j].add(value)) {
                    colRepeats[j] = 1;
                }
            }
        }

        int totalRowRepeats = 0;
        for (int repeats : rowRepeats) {
            totalRowRepeats += repeats;
        }

        int totalColRepeats = 0;
        for (int repeats : colRepeats) {
            totalColRepeats += repeats;
        }

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, totalRowRepeats, totalColRepeats);
    }
}