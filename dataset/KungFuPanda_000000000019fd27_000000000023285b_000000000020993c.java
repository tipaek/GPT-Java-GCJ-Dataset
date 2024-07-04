import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        System.out.println(T);

        for(int k=1; k<=T; k++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] mat = new int[N][N];
            for(int i=0; i<N; i++) {
                String[] nums = scanner.nextLine().split("\\s+");
                for(int j=0; j<N; j++) {
                    mat[i][j] = Integer.parseInt(nums[j]);
                }
            }
            solve(mat, N, k);
        }
    }

    private static void solve(int[][] mat, int n, int c) {
        boolean[][] row = new boolean[n][n+1];
        boolean[][] col = new boolean[n][n+1];
        int trace = 0;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) trace += mat[i][j];
                if(row[i][mat[i][j]]) rowSet.add(i);
                if(col[j][mat[i][j]]) colSet.add(j);
                row[i][mat[i][j]] = col[j][mat[i][j]] = true;
            }
        }
        System.out.println("Case #"+c+": "+trace+" "+rowSet.size()+" "+colSet.size());
    }
}