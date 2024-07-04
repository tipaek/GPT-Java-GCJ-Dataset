import java.util.*;

class Solution {
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

            int traceValue = calculateTrace(mat, size);
            int rowDuplicates = countRowDuplicates(mat, size);
            int colDuplicates = countColDuplicates(mat, size);

            System.out.println("Case #" + z + ": " + traceValue + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    public static int calculateTrace(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int countRowDuplicates(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                count++;
            }
        }
        return count;
    }

    public static int countColDuplicates(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
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