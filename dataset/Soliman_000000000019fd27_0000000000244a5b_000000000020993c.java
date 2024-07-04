import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter pr = new PrintWriter(System.out);

        int T = sc.nextInt();

        for (int t = 1; t <= T; ++t) {
            int N = sc.nextInt();
            int[][] grid = new int[N][N];

            int trace = 0;
            int rows = 0;
            int cols = 0;


            HashSet<Integer>[] colSets = new HashSet[N];
            HashSet<Integer>[] rowSets = new HashSet[N];
            for (int i = 0; i < N; ++i) {
                colSets[i] = new HashSet<>();
                rowSets[i] = new HashSet<>();
            }
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    grid[i][j] = sc.nextInt();
                    colSets[j].add(grid[i][j]);
                    rowSets[i].add(grid[i][j]);
                    if (i == j) trace += grid[i][j];
                }
            }

            for (int i = 0; i < N; ++i) {
                cols += colSets[i].size() == N ? 0 : 1;
                rows += rowSets[i].size() == N ? 0 : 1;
            }

            pr.printf("Case #%d: %d %d %d\n", t, trace, rows, cols);
        }
        pr.flush();
        pr.close();


    }
}
