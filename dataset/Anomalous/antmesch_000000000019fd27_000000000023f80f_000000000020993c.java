import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Inizio");
            String output = analyzeTest(in);
            System.out.println("Case #" + i + ": " + output);
        }
    }

    public static String analyzeTest(Scanner in) {
        int size = in.nextInt();
        int[][] matrix = new int[size][size];
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        // Read the matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        // Calculate trace and row/column repeats
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
            if (hasDuplicates(matrix[i])) {
                rowRepeats++;
            }
            if (hasDuplicates(getColumn(matrix, i))) {
                colRepeats++;
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
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

    private static int[] getColumn(int[][] matrix, int index) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][index];
        }
        return column;
    }
}