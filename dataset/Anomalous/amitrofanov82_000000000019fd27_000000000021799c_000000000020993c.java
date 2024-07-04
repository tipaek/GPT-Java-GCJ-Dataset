import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = getScanner();
        int testCases = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCases; i++) {
            int N = Integer.parseInt(sc.nextLine());
            int[][] matrix = readMatrix(sc, N);
            String result = processMatrix(matrix);
            System.out.println(result);
        }

        sc.close();
    }

    private static Scanner getScanner() throws Exception {
        if (System.getProperty("user.name").equals("Alexey")) {
            System.err.println("development mode, reading from file");
            return new Scanner(new FileInputStream("input.txt"));
        } else {
            return new Scanner(System.in);
        }
    }

    private static int[][] readMatrix(Scanner sc, int N) {
        int[][] matrix = new int[N][N];
        for (int row = 0; row < N; row++) {
            String[] rowValues = sc.nextLine().split(" ");
            for (int col = 0; col < N; col++) {
                matrix[row][col] = Integer.parseInt(rowValues[col]);
            }
        }
        return matrix;
    }

    private static String processMatrix(int[][] matrix) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        int N = matrix.length;

        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
            if (hasRepeats(matrix[i])) rowRepeats++;
            if (hasRepeats(getColumn(matrix, i))) colRepeats++;
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }

    private static boolean hasRepeats(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) return true;
            seen[value - 1] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int N = matrix.length;
        int[] column = new int[N];
        for (int row = 0; row < N; row++) {
            column[row] = matrix[row][colIndex];
        }
        return column;
    }
}