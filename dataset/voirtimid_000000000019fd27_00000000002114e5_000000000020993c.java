import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();

            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int k = 0;
            int r = 0;
            int c = 0;
            for (int i = 0; i < N; i++) {
                Set<Integer> set1 = new HashSet<>(N);
                Set<Integer> set2 = new HashSet<>(N);
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        k += matrix[i][j];
                    }
                    set1.add(matrix[i][j]);
                    set2.add(matrix[j][i]);
                }
                if (set1.size() != N) {
                    r++;
                }
                if (set2.size() != N) {
                    c++;
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", t + 1, k, r, c));


        }

    }
}
