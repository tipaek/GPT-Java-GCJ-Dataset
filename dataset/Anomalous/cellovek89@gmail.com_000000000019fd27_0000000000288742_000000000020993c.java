import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] matrix = new int[100][100];

        int t = Integer.parseInt(reader.readLine().trim());
        
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < n; i++) {
                String[] toks = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(toks[j]);
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int r = countDuplicateRows(matrix, n);
            int c = countDuplicateColumns(matrix, n);

            sb.append("Case #").append(test + 1).append(": ").append(trace).append(" ").append(r).append(" ").append(c);
            if (test != t - 1) {
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < n; j++) {
                if (!set.add(matrix[i][j])) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateColumns = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < n; j++) {
                if (!set.add(matrix[j][i])) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }
}