import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        int[][] results = new int[T][3];

        for (int i = 0; i < T; i++) {
            int N = input.nextInt();
            int diagonal = 0;
            int[][] matrix = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int numberInput = input.nextInt();
                    if (j == k)
                        diagonal += numberInput;
                    matrix[j][k] = numberInput;
                }
            }

            results[i][0] = diagonal;

            for (int j = 0; j < N; j++) {
                Set<Integer> row = new HashSet<>();
                Set<Integer> column = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    row.add(matrix[j][k]);
                    column.add(matrix[k][j]);
                }
                int r = row.size();
                int c = column.size();
                if (r < N) {
                    results[i][1]++;
                }
                if (c < N) {
                    results[i][2]++;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(String.format("Case #%d: %d %d %d", i+1, results[i][0], results[i][1], results[i][2]));
        }
    }
}
