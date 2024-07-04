import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        processInput();
    }

    private static void processInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int testCases = Integer.parseInt(tokenizer.nextToken());
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            handleTestCase(testCase, reader);
        }
    }

    private static void handleTestCase(int caseNumber, BufferedReader reader) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int size = Integer.parseInt(tokenizer.nextToken());
        int[][] matrix = new int[size][size];
        
        for (int row = 0; row < size; row++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        
        int trace = calculateTrace(matrix, size);
        int rowCount = calculateRowDuplicates(matrix, size);
        int colCount = calculateColumnDuplicates(matrix, size);

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowCount + " " + colCount);
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int calculateRowDuplicates(int[][] matrix, int size) {
        int rowCount = 0;
        for (int row = 0; row < size; row++) {
            boolean[] seen = new boolean[size + 1];
            for (int col = 0; col < size; col++) {
                if (seen[matrix[row][col]]) {
                    rowCount++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }
        return rowCount;
    }

    private static int calculateColumnDuplicates(int[][] matrix, int size) {
        int colCount = 0;
        for (int col = 0; col < size; col++) {
            boolean[] seen = new boolean[size + 1];
            for (int row = 0; row < size; row++) {
                if (seen[matrix[row][col]]) {
                    colCount++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }
        return colCount;
    }
}