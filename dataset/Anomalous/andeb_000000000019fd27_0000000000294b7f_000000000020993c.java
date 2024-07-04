import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());
        
        for (int caseIndex = 0; caseIndex < cases; caseIndex++) {
            int dimension = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[dimension][dimension];
            
            for (int i = 0; i < dimension; i++) {
                String[] rowValues = reader.readLine().split(" ");
                for (int j = 0; j < rowValues.length; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }

            int trace = calculateTrace(matrix, dimension);
            int rowDuplicates = countRowDuplicates(matrix, dimension);
            int columnDuplicates = countColumnDuplicates(matrix, dimension);

            System.out.printf("Case #%d: %d %d %d%n", caseIndex + 1, trace, rowDuplicates, columnDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix, int dimension) {
        int trace = 0;
        for (int i = 0; i < dimension; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int dimension) {
        int duplicates = 0;
        boolean[] seen = new boolean[dimension];
        
        for (int i = 0; i < dimension; i++) {
            Arrays.fill(seen, false);
            for (int j = 0; j < dimension; j++) {
                int value = matrix[i][j] - 1;
                if (seen[value]) {
                    duplicates++;
                    break;
                }
                seen[value] = true;
            }
        }
        return duplicates;
    }

    private static int countColumnDuplicates(int[][] matrix, int dimension) {
        int duplicates = 0;
        boolean[] seen = new boolean[dimension];
        
        for (int i = 0; i < dimension; i++) {
            Arrays.fill(seen, false);
            for (int j = 0; j < dimension; j++) {
                int value = matrix[j][i] - 1;
                if (seen[value]) {
                    duplicates++;
                    break;
                }
                seen[value] = true;
            }
        }
        return duplicates;
    }
}