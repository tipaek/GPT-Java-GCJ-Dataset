import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] matrix = new int[N][N];

            // Initialize diagonal with 1s and adjust K
            for (int i = 0; i < N; i++) {
                matrix[i][i] = 1;
                K--;
            }

            // Distribute remaining K to the diagonal
            for (int i = 0; i < N && K > 0; i++) {
                int add = Math.min(K, N - 1);
                matrix[i][i] += add;
                K -= add;
            }

            // Prepare sets for rows and columns
            Set<Integer>[] rows = new Set[N];
            Set<Integer>[] cols = new Set[N];
            for (int i = 0; i < N; i++) {
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
            }

            // Populate sets with possible values
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (matrix[i][i] != j) {
                        rows[i].add(j);
                        cols[i].add(j);
                    }
                }
            }

            boolean impossible = false;

            // Fill the matrix
            for (int i = 0; i < N && !impossible; i++) {
                for (int j = 0; j < N && !impossible; j++) {
                    if (matrix[i][j] > 0) continue;

                    Set<Integer> possibleValues = new HashSet<>(rows[i]);
                    possibleValues.retainAll(cols[j]);

                    if (possibleValues.isEmpty()) {
                        impossible = true;
                    } else {
                        int value = possibleValues.iterator().next();
                        matrix[i][j] = value;
                        rows[i].remove(value);
                        cols[j].remove(value);
                    }
                }
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                System.out.printf("Case #%d: POSSIBLE\n", t);
                for (int[] row : matrix) {
                    System.out.println(Arrays.stream(row)
                                             .mapToObj(Integer::toString)
                                             .collect(Collectors.joining(" ")));
                }
            }
        }
    }
}