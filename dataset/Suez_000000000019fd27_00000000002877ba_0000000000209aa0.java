import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {

    static int[][] ans = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            int K = in.nextInt();
            int[][] ar = new int[N][N];
            ans = null;
            List<Set<Integer>> cols = new ArrayList<>();
            List<Set<Integer>> rows = new ArrayList<>();
            for (int i=0; i<N; i++) {
                cols.add(new HashSet<>());
                rows.add(new HashSet<>());
            }

            dfs(ar, 0, 0, N, rows, cols, K, 0);
            System.out.println(String.format("Case #%s: %s", t+1, ans == null ? "IMPOSSIBLE" : "POSSIBLE"));
            if (ans == null) {
                continue;
            }
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    System.out.print(ans[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

    private static void dfs(int[][] ar, int x, int y, int N, List<Set<Integer>> rows, List<Set<Integer>> cols,
                            int K, int k) {
        if (ans != null) {
            return;
        }

//        print(ar);
        for (int i=1; i<=N; i++) {
//            if (k+i > K) continue;
            if (cols.get(x).contains(i)) continue;
            if (rows.get(y).contains(i)) continue;

            cols.get(x).add(i);
            rows.get(y).add(i);
            ar[x][y] = i;
//            if (x == y) k+=i;

            if (x+1 == N && y+1 == N) {
                int sum = 0;
                for (int j=0; j<N; j++) sum+=ar[j][j];
                if (sum == K) {
                    ans = new int[N][N];
                    for (int a=0; a<N; a++) for (int b=0; b<N; b++) ans[a][b] = ar[a][b];
                }
            } else if (x+1 == N) {
                dfs(ar, 0, y+1, N, rows, cols, K, k);
            } else {
                dfs(ar, x+1, y, N, rows, cols, K, k);
            }

            cols.get(x).remove(i);
            rows.get(y).remove(i);
            ar[x][y] = 0;
//            if (x == y) k-=i;
        }
    }


    private static void print(int[][] ar) {
        for (int i=0; i<ar.length; i++) {
            for (int j=0; j<ar[i].length; j++) {
                System.out.print(ar[i][j]);
            }
            System.out.println();
        }
        System.out.println("==========");
    }
}
