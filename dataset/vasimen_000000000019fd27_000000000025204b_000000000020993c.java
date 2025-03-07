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
        for (int i = 0; i < matrix.length; i++) {
            int[] hash = new int[matrix.length];
            int max = 0;
            for (int j = 0; j < matrix.length; j++) {
                hash[matrix[i][j] -1]++;
                max = Math.max(max, hash[matrix[i][j] - 1]);
            }
            rowsDuplicateCount = Math.max(rowsDuplicateCount,  max > 1 ? max : 0);
        }

        int columnsDuplicateCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] hash = new int[matrix.length];
            int max = 0;
            for (int j = 0; j < matrix.length; j++) {
                hash[matrix[j][i]-1]++;
                max = Math.max(max, hash[matrix[j][i]-1]);
            }

            columnsDuplicateCount = Math.max(columnsDuplicateCount,  max > 1 ? max : 0);
        }

        return String.format("%d %d %d", diagonal, rowsDuplicateCount, columnsDuplicateCount);
    }
}
