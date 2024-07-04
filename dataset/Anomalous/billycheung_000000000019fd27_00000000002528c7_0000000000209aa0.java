import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println("Case #" + i + ": " + solve(n, k));
        }
    }

    private static String solve(int n, int k) {
        int[][] matrix = new int[n][n];
        Set<Integer>[] rowSets = new HashSet[n];
        Set<Integer>[] colSets = new HashSet[n];
        
        for (int i = 0; i < n; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }
        
        boolean isPossible = fillMatrix(n, k, matrix, 0, rowSets, colSets);
        return isPossible ? "POSSIBLE\n" + formatMatrix(matrix) : "IMPOSSIBLE";
    }

    private static boolean fillMatrix(int n, int k, int[][] matrix, int index, Set<Integer>[] rowSets, Set<Integer>[] colSets) {
        if (k < 0) return false;
        if (index == n * n) return k == 0;
        
        int row = index / n;
        int col = index % n;
        
        for (int num = 1; num <= n; num++) {
            if (rowSets[row].contains(num) || colSets[col].contains(num)) continue;
            
            matrix[row][col] = num;
            rowSets[row].add(num);
            colSets[col].add(num);
            
            if (fillMatrix(n, (row == col) ? k - num : k, matrix, index + 1, rowSets, colSets)) {
                return true;
            }
            
            rowSets[row].remove(num);
            colSets[col].remove(num);
            matrix[row][col] = 0;
        }
        
        return false;
    }

    private static String formatMatrix(int[][] matrix) {
        return Arrays.stream(matrix)
                .map(row -> Arrays.stream(row)
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }
}