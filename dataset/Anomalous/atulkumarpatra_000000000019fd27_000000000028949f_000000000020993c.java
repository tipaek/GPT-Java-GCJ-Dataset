import java.util.*;

public class Matrixx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int z = 1; z <= T; z++) {
            int size = sc.nextInt();
            int[][] mat = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int k = calculateTrace(mat, size);
            int r = countRowDuplicates(mat, size);
            int c = countColumnDuplicates(mat, size);

            System.out.println("Case #" + z + ": " + k + " " + r + " " + c);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}