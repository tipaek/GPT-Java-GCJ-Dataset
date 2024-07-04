
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private int countDiffs(Set<Integer> sets[]) {
        int count = 0;

        for (Set<Integer> s : sets) {
            if (s.size() != sets.length)
                count++;
        }

        return count;
    }

    public void solve(int test, int [][]matrix) {
        int k = 0;
        Set<Integer> countR[] = new Set[matrix.length], countC[] = new Set[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            countC[i] = new HashSet<>();
            countR[i] = new HashSet<>();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                if (i == j) k += matrix[i][j];

                countC[i].add(matrix[i][j]);
                countR[j].add(matrix[i][j]);
            }
        }

        //int total = (int) (matrix.length * (1.0/2.0 + matrix.length / 2.0));
        System.out.println("Case #" + test + ": " + k + " " + countDiffs(countR) + " " + countDiffs(countC));

    }



    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        Solution sol = new Solution();

        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= T; t++) {

            int N = Integer.parseInt(scanner.nextLine());
            int matrix[][] = new int[N][N];

            for (int row = 0; row < N; row++) {
                String []line = scanner.nextLine().split(" ");

                for (int col = 0; col < N; col++) {

                    matrix[row][col] = Integer.parseInt(line[col]);
                }

            }

            sol.solve(t, matrix);

        }
    }
}
