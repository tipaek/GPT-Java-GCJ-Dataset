import java.util.*;
import java.io.*;
class Solution {
    List<Set<Integer>> rows;
    List<Set<Integer>> cols;

    public Solution(int n) {
        rows =  new ArrayList<>();
        cols = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for(int k=1; k<=T; k++) {
            int n = scanner.nextInt();
            int trace = scanner.nextInt();
            int[][] arr = new int[n][n];
            Solution s = new Solution(n);
            if(!s.dfs(arr, 0, 0, 0, trace)) {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
                continue;
            }
            System.out.println("Case #" + k + ": POSSIBLE");
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    System.out.print(arr[i][j]);
                    if(j != n-1) System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    private boolean dfs(int[][] arr, int x, int y, int trace, int k ) {
        if(trace > k) return false;
        if(x == arr.length) return trace == k;

        int nx = x, ny = y+1;
        if(ny >= arr.length) {
            nx++;
            ny = 0;
        }

        for(int i=1; i<=arr.length; i++) {
            if(rows.get(x).contains(i) || cols.get(y).contains(i))
                continue;
            arr[x][y] = i;
            rows.get(x).add(i);
            cols.get(y).add(i);
            int newTrace = (x == y) ? trace + i : trace;
            if(dfs(arr, nx, ny, newTrace, k))
                return true;
            rows.get(x).remove(i);
            cols.get(y).remove(i);
        }
        return false;
    }
}