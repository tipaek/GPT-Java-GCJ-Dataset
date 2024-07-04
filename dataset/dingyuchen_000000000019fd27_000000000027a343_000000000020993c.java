import java.util.*;

public class Solution {
    private void solve(int caseNo, int[][] matrix, int N) {
        List<Set<Integer>> rowSetList = new ArrayList<>(N);
        List<Set<Integer>> colSetList = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            rowSetList.add(new HashSet<>());
            colSetList.add(new HashSet<>());
        }
	boolean[] rowSkip = new boolean[N];
        int rowCount = 0;
	boolean[] colSkip = new boolean[N];
        int colCount = 0;
        int trace = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = matrix[i][j];
                if (i == j) {
                    trace += value;
                }
                if (!rowSkip[i] && rowSetList.get(i).contains(value)) {
                    rowCount++;
		    rowSkip[i] = true;
                } else {
                    rowSetList.get(i).add(value);
                }
                if (!colSkip[j] && colSetList.get(j).contains(value)) {
                    colCount++;
		    colSkip[j] = true;
                } else {
                    colSetList.get(j).add(value);
                }
            }
        }
        System.out.println(String.format("Case #%d: %d %d %d", caseNo, trace, rowCount, colCount));
    }
    public void run() {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        for (int i = 0; i < testcases; i++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            this.solve(i + 1, matrix, N);
        }
    }
    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

}
