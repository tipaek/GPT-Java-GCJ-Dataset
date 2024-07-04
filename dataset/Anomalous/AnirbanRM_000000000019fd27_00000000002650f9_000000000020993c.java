import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            int[][] matrix = new int[n][n];
            Set<Integer>[] colSets = new Set[n];
            for (int i = 0; i < n; i++) {
                colSets[i] = new HashSet<>();
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    rowSet.add(value);
                    colSets[j].add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
                if (rowSet.size() != n) {
                    rowRepeats++;
                }
            }

            for (Set<Integer> colSet : colSets) {
                if (colSet.size() != n) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}