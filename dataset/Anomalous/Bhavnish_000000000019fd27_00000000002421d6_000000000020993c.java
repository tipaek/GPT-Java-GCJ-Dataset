import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    matrix[j][l] = in.nextInt();
                    if (j == l) {
                        trace += matrix[j][l];
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if (hasDuplicates(matrix[j])) {
                    rowRepeats++;
                }
            }

            for (int l = 0; l < n; l++) {
                int[] column = new int[n];
                for (int j = 0; j < n; j++) {
                    column[j] = matrix[j][l];
                }
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        in.close();
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