import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 1; i <= cases; i++) {
            int N = scanner.nextInt();
            System.out.println("Case #" + i + ": " + solveVestigium(N, scanner));
        }
    }

    public static String solveVestigium(int N, Scanner scanner) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        int[][] matrix = new int[N][N];
        Set<Integer>[] rowSets = new Set[N];
        Set<Integer>[] colSets = new Set[N];

        for (int i = 0; i < N; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = scanner.nextInt();
                matrix[i][j] = value;
                if (i == j) {
                    trace += value;
                }
                if (!rowSets[i].add(value)) {
                    rowRepeats++;
                    rowSets[i].clear(); // Prevents counting the same row multiple times
                }
                if (!colSets[j].add(value)) {
                    colRepeats++;
                    colSets[j].clear(); // Prevents counting the same column multiple times
                }
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }
}