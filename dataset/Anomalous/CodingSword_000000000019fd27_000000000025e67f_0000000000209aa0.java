import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    
    static int n;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            n = scanner.nextInt();
            int k = scanner.nextInt();
            
            int[] diagonal = new int[n];
            boolean isValid = isValidK(n, k, diagonal);
            
            if (!isValid) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }
            
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i][i] = diagonal[i];
            }
            
            TreeSet<Integer>[] rowSets = new TreeSet[n];
            TreeSet<Integer>[] columnSets = new TreeSet[n];
            
            for (int i = 0; i < n; i++) {
                rowSets[i] = new TreeSet<>(Collections.singleton(matrix[i][i]));
                columnSets[i] = new TreeSet<>();
                for (int j = 1; j <= n; j++) {
                    columnSets[i].add(j);
                }
                columnSets[i].remove(matrix[i][i]);
            }
            
            fillMatrix(0, 0, matrix, columnSets, rowSets);
            
            System.out.println("Case #" + t + ": POSSIBLE");
            for (int[] row : matrix) {
                System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
            }
        }
    }
    
    public static boolean fillMatrix(int y, int x, int[][] matrix, TreeSet<Integer>[] rowSets, TreeSet<Integer>[] columnSets) {
        if (y >= n) return true;
        if (x >= n) return fillMatrix(y + 1, 0, matrix, rowSets, columnSets);
        if (y == x) return fillMatrix(y, x + 1, matrix, rowSets, columnSets);
        
        for (int i = 1; i <= n; i++) {
            if (rowSets[y].contains(i) && !columnSets[x].contains(i)) {
                rowSets[y].remove(i);
                columnSets[x].add(i);
                
                if (fillMatrix(y, x + 1, matrix, rowSets, columnSets)) {
                    matrix[y][x] = i;
                    return true;
                }
                
                rowSets[y].add(i);
                columnSets[x].remove(i);
            }
        }
        return false;
    }
    
    public static boolean isValidK(int n, int k, int[] diagonal) {
        Arrays.fill(diagonal, 1);
        int remaining = k - n;
        
        if (remaining == 0) return true;
        if (remaining == 1) return false;
        
        if (remaining % n == 0) {
            Arrays.fill(diagonal, k / n);
            return true;
        }
        
        if (k == (n * n) - 1) return false;
        
        diagonal[n - 2]++;
        remaining--;
        
        for (int i = n - 1; i >= 0; i--) {
            int add = Math.min(remaining, i == n - 2 ? n - 2 : n - 1);
            diagonal[i] += add;
            remaining -= add;
            
            if (remaining == 0) break;
        }
        
        int sum = diagonal[0] + diagonal[1];
        diagonal[0] = sum / 2;
        diagonal[1] = sum / 2;
        if (sum % 2 != 0) diagonal[1]++;
        
        if (n == 3 && (diagonal[1] == diagonal[2] || diagonal[0] == diagonal[1])) return false;
        
        return true;
    }
}