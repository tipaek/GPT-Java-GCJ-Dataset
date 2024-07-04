import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int x = 1; x <= cases; x++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[n][n];
            readMatrix(scanner, matrix);

            int k = trace(matrix);
            int r = rows(matrix);
            int c = cols(matrix);
            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
        }
    }

    private static void readMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            for (int j = 0; j < split.length; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }
    }

    private static int trace(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int rows(int[][] matrix) {
        int dups = 0;
        for (int[] ints : matrix) {
            dups += hasDups(ints) ? 1 : 0;
        }
        return dups;
    }

    private static int cols(int[][] matrix) {
        int dups = 0;

        int[] arr = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int num = matrix[j][i];
                arr[j] = num;
            }
            dups += hasDups(arr) ? 1 : 0;
        }

        return dups;
    }

    private static boolean hasDups(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}