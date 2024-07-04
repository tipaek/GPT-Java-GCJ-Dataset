import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.hasNext() ? sc.nextInt() : 0;

        for (int t = 0; t < T; t++) {
            int N = sc.hasNext() ? sc.nextInt() : 0;
            int[][] matrix = new int[N][N];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            HashSet<Integer> set = new HashSet<>();

            // Read matrix and calculate trace
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (sc.hasNext()) {
                        matrix[i][j] = sc.nextInt();
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                    }
                }
            }

            // Check for row duplicates
            for (int i = 0; i < N; i++) {
                for (int num : matrix[i]) {
                    set.add(num);
                }
                if (set.size() < N) {
                    rowDuplicates++;
                }
                set.clear();
            }

            // Check for column duplicates
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    set.add(matrix[i][j]);
                }
                if (set.size() < N) {
                    colDuplicates++;
                }
                set.clear();
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        sc.close();
    }
}