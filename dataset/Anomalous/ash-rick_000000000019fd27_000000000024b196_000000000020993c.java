import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Vestigium v = new Vestigium();

        for (int t = 1; t <= T && T <= 100; t++) {
            int N = sc.nextInt();
            if (N >= 2 && N <= 100) {
                int[][] matrix = new int[N][N];
                v.processMatrix(matrix, N, t, sc);
            }
        }
    }

    public void processMatrix(int[][] matrix, int n, int t, Scanner sc) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];

            if (hasDuplicates(matrix[i])) {
                rowRepeats++;
            }

            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = matrix[j][i];
            }

            if (hasDuplicates(col)) {
                colRepeats++;
            }
        }

        System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }

    private boolean hasDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}