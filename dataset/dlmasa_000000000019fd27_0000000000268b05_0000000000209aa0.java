import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
    public void solve() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for (int t = 1 ; t <= T; t++) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                matrix[i][i] = 1;
                K -= 1;
            }
            for (int i = 0; i < N && 0 < K; i++) {
                matrix[i][i] += Math.min(K, N - 1);
                K -= Math.min(K, N - 1);
            }
            Set<Integer>[] row = new Set[N];
            Set<Integer>[] column = new Set[N];
            for (int i = 0; i < N; i++) {
                row[i] = new HashSet<>();
                column[i] = new HashSet<>();
            }
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (matrix[i][i] == j) {
                        continue;
                    }
                    row[i].add(j);
                    column[i].add(j);
                }
            }
            boolean impossible = false;
            for (int i = 0; i < N && !impossible; i++) {
                for (int j = 0; j < N && !impossible; j++) {
                    if (0 < matrix[i][j]) {
                        continue;
                    }
                    Set<Integer> all = new HashSet<>();
                    all.addAll(row[i]);
                    all.retainAll(column[j]);
                    if (all.size() == 0) {
                        impossible = true;
                        break;
                    }
                    Iterator<Integer> it = all.iterator();
                    int x = it.next();
                    matrix[i][j] = x;
                    row[i].remove(x);
                    column[j].remove(x);
                }
            }
            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                System.out.printf("Case #%d: POSSIBLE\n", t);
                for (int i = 0; i < N; i++) {
                    System.out.println(Arrays.stream(matrix[i]).mapToObj(x -> Integer.toString(x)).collect(Collectors.joining(" ")));
                }
            }
        }
    }
}
