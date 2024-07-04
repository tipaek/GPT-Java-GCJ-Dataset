import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc;
        if (System.getProperty("user.name").equals("Alexey")) {
            sc = new Scanner(new FileInputStream("input.txt"));
            System.err.println("development mode, reading from file");
        } else {
            sc = new Scanner(System.in);
        }

        int testCases = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= testCases; i++) {
            int N = Integer.parseInt(sc.nextLine());
            int[][] matrix = new int[N][N];
            for (int row = 0; row < N; row++) {
                String[] rowValues = sc.nextLine().split(" ");
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = Integer.parseInt(rowValues[col]);
                }
            }

            String result = processSingleCase(matrix);
            System.out.println("Case #" + i + ": " + result);
        }
        sc.close();
    }

    private static String processSingleCase(int[][] matrix) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        int N = matrix.length;

        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];

            if (hasDuplicates(matrix[i])) {
                rowRepeats++;
            }

            int[] column = new int[N];
            for (int j = 0; j < N; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                colRepeats++;
            }
        }

        System.err.println("test debug output");
        return trace + " " + rowRepeats + " " + colRepeats;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}