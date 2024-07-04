import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            solve(reader, i + 1);
        }
    }

    private static void swapColumns(int[][] grid, int col1, int col2) {
        for (int[] row : grid) {
            int temp = row[col1];
            row[col1] = row[col2];
            row[col2] = temp;
        }
    }

    private static void solve(BufferedReader reader, int caseNumber) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        if (K % N == 0 && K > 0 && K < N * N) {
            System.out.printf("Case #%d: POSSIBLE%n", caseNumber);
            int[][] grid = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = (j + i) % N + 1;
                }
            }

            int targetValue = K / N;
            for (int i = 0; i < N; i++) {
                if (grid[i][i] != targetValue) {
                    int toSwap = -1;
                    for (int j = 0; j < N; j++) {
                        if (grid[i][j] == targetValue) {
                            toSwap = j;
                            break;
                        }
                    }
                    swapColumns(grid, i, toSwap);
                }
            }

            for (int[] row : grid) {
                for (int j = 0; j < N; j++) {
                    System.out.print(row[j]);
                    if (j < N - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.printf("Case #%d: IMPOSSIBLE%n", caseNumber);
        }
    }
}