import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    
    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }
    
    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            int[] result = getResult(matrix);
            System.out.print("Case #" + (i + 1) + ": ");
            System.out.print(result[0] + " " + result[1] + " " + result[2]);
            if (i != n - 1)
                System.out.println();
        }
    }

    public static int[] getResult(int[][] matrix) {
        int[] result = new int[3];
        for (int i = 0; i < matrix.length; i++) {
            result[0] += matrix[i][i];
        }

        for (int j = 0; j < matrix.length; j++) {
            Set<Integer> columnSet = new HashSet<>();
            Set<Integer> rowSet = new HashSet<>();
            for (int k = 0; k < matrix.length; k++) {
                if (!columnSet.add(matrix[k][j])) {
                    result[2]++;
                    break;
                }
            }
            for (int l = 0; l < matrix.length; l++) {
                if (!rowSet.add(matrix[j][l])) {
                    result[1]++;
                    break;
                }
            }
        }

        return result;
    }
}
