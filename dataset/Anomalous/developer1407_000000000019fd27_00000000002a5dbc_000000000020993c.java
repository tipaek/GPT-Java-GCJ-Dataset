import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); // Dimension of the matrix
            int[][] mat = new int[n][n];
            
            // Read the matrix elements
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mat[j][k] = in.nextInt();
                }
            }
            trace(mat, i);
        }
        in.close();
    }
    
    public static void trace(int[][] mat, int caseNumber) {
        int n = mat.length;
        int trace = 0;
        int[] rowCounts = new int[n];
        int[] colCounts = new int[n];
        Set<Integer>[] rowSets = new HashSet[n];
        Set<Integer>[] colSets = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += mat[i][j];
                }
                if (!rowSets[i].add(mat[i][j])) {
                    rowCounts[i] = 1;
                }
                if (!colSets[j].add(mat[i][j])) {
                    colCounts[j] = 1;
                }
            }
        }

        int sr = Arrays.stream(rowCounts).sum();
        int sc = Arrays.stream(colCounts).sum();
        
        System.out.println("Case #" + caseNumber + ": " + trace + " " + sr + " " + sc);
    }
}