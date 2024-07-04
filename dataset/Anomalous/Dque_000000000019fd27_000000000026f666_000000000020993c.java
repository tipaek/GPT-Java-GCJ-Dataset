import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
                if (!isUniqueRow(matrix, i)) rowRepeats++;
                if (!isUniqueColumn(matrix, i)) colRepeats++;
            }

            writer.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        writer.close();
    }

    private static boolean isUniqueRow(int[][] matrix, int row) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : matrix[row]) {
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUniqueColumn(int[][] matrix, int col) {
        HashSet<Integer> set = new HashSet<>();
        for (int[] row : matrix) {
            if (!set.add(row[col])) {
                return false;
            }
        }
        return true;
    }
}