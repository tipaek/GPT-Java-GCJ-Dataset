import java.util.*;

public class Solution {
    private void solve(int caseNo, int[][] matrix, int N) {
        List<Set<Integer>> rowSets = new ArrayList<>(N);
        List<Set<Integer>> colSets = new ArrayList<>(N);
        
        for (int i = 0; i < N; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
        }
        
        boolean[] rowHasDuplicate = new boolean[N];
        boolean[] colHasDuplicate = new boolean[N];
        int rowCount = 0;
        int colCount = 0;
        int trace = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = matrix[i][j];
                if (i == j) {
                    trace += value;
                }
                if (!rowHasDuplicate[i] && rowSets.get(i).contains(value)) {
                    rowCount++;
                    rowHasDuplicate[i] = true;
                } else {
                    rowSets.get(i).add(value);
                }
                if (!colHasDuplicate[j] && colSets.get(j).contains(value)) {
                    colCount++;
                    colHasDuplicate[j] = true;
                } else {
                    colSets.get(j).add(value);
                }
            }
        }
        
        System.out.printf("Case #%d: %d %d %d%n", caseNo, trace, rowCount, colCount);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            
            solve(i + 1, matrix, N);
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}