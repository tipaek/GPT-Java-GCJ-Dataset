import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = Integer.parseInt(sc.nextLine());

        for (int test = 1; test <= testcase; test++) {
            int N = Integer.parseInt(sc.nextLine());
            int[][] square = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] row = sc.nextLine().split("\\s");
                for (int j = 0; j < N; j++) {
                    square[i][j] = Integer.parseInt(row[j]);
                }
            }

            int k = calculateDiagonalSum(square);
            int r = countDuplicateRows(square);
            int c = countDuplicateColumns(square);

            System.out.println("Case #" + test + ": " + k + " " + r + " " + c);
        }
    }

    private static int calculateDiagonalSum(int[][] square) {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] square) {
        int count = 0;

        for (int[] row : square) {
            if (hasDuplicates(row)) {
                count++;
            }
        }

        return count;
    }

    private static int countDuplicateColumns(int[][] square) {
        int count = 0;
        int N = square.length;

        for (int col = 0; col < N; col++) {
            int[] column = new int[N];
            for (int row = 0; row < N; row++) {
                column[row] = square[row][col];
            }

            if (hasDuplicates(column)) {
                count++;
            }
        }

        return count;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}