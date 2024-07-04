import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            for (int row = 0; row < N; row++) {
                for (int column = 0; column < N; column++) {
                    matrix[row][column] = scanner.nextInt();
                }
            }
            //calculate trace
            int trace = 0;
            for (int j = 0; j < N; j++) {
                trace += matrix[j][j];
            }
            //check repeated row
            int repeatedRow = 0;
            for (int row = 0; row < N; row++) {
                Set<Integer> set = new HashSet<>();
                for (int column = 0; column < N; column++) {
                    set.add(matrix[row][column]);
                }
                if (set.size() < N) {
                    repeatedRow++;
                }
            }

            //check repeated column
            int repeatedColumn = 0;
            for (int column = 0; column < N; column++) {
                Set<Integer> set = new HashSet<>();
                for (int row = 0; row < N; row++) {
                    set.add(matrix[row][column]);
                }
                if (set.size() < N) {
                    repeatedColumn++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + repeatedRow + " " + repeatedColumn);
        }
    }
}
