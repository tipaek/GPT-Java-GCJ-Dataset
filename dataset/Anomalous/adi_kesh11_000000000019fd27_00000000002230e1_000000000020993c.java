import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SolutionVestigium {
    private static final String OUTPUT_FORMAT = "Case #%d: %d %d %d";

    public static void main(String[] args) {
        try {
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int trace = 0, rowRepeats = 0, colRepeats = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
            if (hasDuplicates(matrix[i])) {
                rowRepeats++;
            }
            if (hasDuplicates(getColumn(matrix, i))) {
                colRepeats++;
            }
        }

        System.out.println(String.format(OUTPUT_FORMAT, caseNum, trace, rowRepeats, colRepeats));
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

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}