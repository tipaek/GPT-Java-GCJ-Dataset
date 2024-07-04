import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       Scanner scanner = new Scanner(System.in);

        int times = Integer.parseInt(scanner.nextLine());
        long start = System.currentTimeMillis();
        for (int t = 1; t <= times; t++) {
            try {
                System.out.println(String.format("Case #%d: %s", t, new Solution().solve(scanner)));
            } catch (Throwable e) {
                System.err.println("ERROR in case #" + t);
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.err.println(String.format("Time used: %.3fs", (end - start) / 1000.0));

    }

    public String solve(Scanner scanner) {
        int size = scanner.nextInt();
        scanner.nextLine();
        int [][] matrix = new int[size][size];
        for (int i = 0; i < size; ++i) {
            String[] line = scanner.nextLine().split(" ");
            for(int j = 0; j < size; ++j) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        return compute(matrix);
     }

      private String compute(int[][] matrix) {
        long diagonal = 0;
        for (int i = 0, j = 0; i < matrix.length; i++, j++) {
            diagonal += matrix[i][j];
        }
        int rowsDuplicateCount = 0;
        int columnsDuplicateCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] hash1 = new int[matrix.length];
            int[] hash2 = new int[matrix.length];

            int max1 = 0;
            int max2 = 0;

            for (int j = 0; j < matrix.length; j++) {
                hash1[matrix[i][j] -1]++;
                hash2[matrix[j][i]-1]++;
                max1 = Math.max(max1, hash1[matrix[i][j] - 1]);
                max2 = Math.max(max2, hash2[matrix[j][i]-1]);
            }
            rowsDuplicateCount = Math.max(rowsDuplicateCount,  max1 > 1 ? max1 : 0);
            columnsDuplicateCount = Math.max(columnsDuplicateCount,  max2 > 1 ? max2 : 0);
        }

        return String.format("%d %d %d", diagonal, rowsDuplicateCount, columnsDuplicateCount);
    }
}
