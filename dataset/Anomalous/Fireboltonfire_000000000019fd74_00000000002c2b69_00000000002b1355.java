import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static final int DEF = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve(scanner);
        }
        scanner.close();
    }

    public static void solve(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        long sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
                sum += matrix[i][j];
            }
        }

        boolean[] rowFlags = new boolean[rows];
        boolean[] colFlags = new boolean[cols];
        for (int i = 0; i < rows; i++) rowFlags[i] = true;
        for (int i = 0; i < cols; i++) colFlags[i] = true;

        int[][] left = new int[rows][cols];
        int[][] right = new int[rows][cols];
        int[][] top = new int[rows][cols];
        int[][] down = new int[rows][cols];

        long result = 0;
        boolean updateRequired = true;

        while (updateRequired) {
            updateRequired = false;
            result += sum;

            for (int i = 0; i < rows; i++) {
                if (rowFlags[i]) {
                    left[i][0] = DEF;
                    for (int j = 1; j < cols; j++) {
                        left[i][j] = (matrix[i][j - 1] != DEF) ? matrix[i][j - 1] : left[i][j - 1];
                    }
                    right[i][cols - 1] = DEF;
                    for (int j = cols - 2; j >= 0; j--) {
                        right[i][j] = (matrix[i][j + 1] != DEF) ? matrix[i][j + 1] : right[i][j + 1];
                    }
                }
            }

            for (int j = 0; j < cols; j++) {
                if (colFlags[j]) {
                    top[0][j] = DEF;
                    for (int i = 1; i < rows; i++) {
                        top[i][j] = (matrix[i - 1][j] != DEF) ? matrix[i - 1][j] : top[i][j - 1];
                    }
                    down[rows - 1][j] = DEF;
                    for (int i = rows - 2; i >= 0; i--) {
                        down[i][j] = (matrix[i + 1][j] != DEF) ? matrix[i + 1][j] : down[i][j + 1];
                    }
                }
            }

            boolean[] newRowFlags = new boolean[rows];
            boolean[] newColFlags = new boolean[cols];

            for (int i = 0; i < rows; i++) {
                newRowFlags[i] = false;
            }
            for (int i = 0; i < cols; i++) {
                newColFlags[i] = false;
            }

            for (int i = 0; i < rows; i++) {
                if (rowFlags[i]) {
                    for (int j = 0; j < cols; j++) {
                        if (matrix[i][j] != DEF) {
                            double avg = calculateAverage(left[i][j], right[i][j], top[i][j], down[i][j]);
                            if (matrix[i][j] < avg) {
                                newRowFlags[i] = true;
                                newColFlags[j] = true;
                                sum -= matrix[i][j];
                                matrix[i][j] = DEF;
                                updateRequired = true;
                            }
                        }
                    }
                }
            }

            for (int j = 0; j < cols; j++) {
                if (colFlags[j]) {
                    for (int i = 0; i < rows; i++) {
                        if (!rowFlags[i] && matrix[i][j] != DEF) {
                            double avg = calculateAverage(left[i][j], right[i][j], top[i][j], down[i][j]);
                            if (matrix[i][j] < avg) {
                                newRowFlags[i] = true;
                                newColFlags[j] = true;
                                sum -= matrix[i][j];
                                matrix[i][j] = DEF;
                                updateRequired = true;
                            }
                        }
                    }
                }
            }

            rowFlags = newRowFlags;
            colFlags = newColFlags;
        }

        System.out.println(result);
    }

    public static double calculateAverage(int a, int b, int c, int d) {
        int count = 0;
        double sum = 0.0;
        if (a != DEF) {
            count++;
            sum += a;
        }
        if (b != DEF) {
            count++;
            sum += b;
        }
        if (c != DEF) {
            count++;
            sum += c;
        }
        if (d != DEF) {
            count++;
            sum += d;
        }
        return sum / count;
    }
}