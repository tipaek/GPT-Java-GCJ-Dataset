import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            List<Set<Integer>> rows = new ArrayList<>(n);
            List<Set<Integer>> cols = new ArrayList<>(n);
            boolean[] rowHasRepeat = new boolean[n];
            boolean[] colHasRepeat = new boolean[n];
            
            for (int i = 0; i < n; i++) {
                rows.add(new HashSet<>());
                if (i == 0) {
                    for (int j = 0; j < n; j++) {
                        cols.add(new HashSet<>());
                    }
                }
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowHasRepeat[i]) {
                        if (rows.get(i).contains(matrix[i][j])) {
                            rowRepeats++;
                            rowHasRepeat[i] = true;
                        } else {
                            rows.get(i).add(matrix[i][j]);
                        }
                    }
                    if (!colHasRepeat[j]) {
                        if (cols.get(j).contains(matrix[i][j])) {
                            colRepeats++;
                            colHasRepeat[j] = true;
                        } else {
                            cols.get(j).add(matrix[i][j]);
                        }
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats);
        }
    }
}