import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer tokenizer = null;

    private String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private void solve() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        
        int testCases = Integer.parseInt(nextToken());
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = Integer.parseInt(nextToken());
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int duplicateRows = matrixSize;
            int duplicateCols = matrixSize;

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(nextToken());
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() == matrixSize) {
                    duplicateRows--;
                }
                trace += matrix[row][row];
            }

            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() == matrixSize) {
                    duplicateCols--;
                }
            }

            writer.println(String.format("Case #%d: %d %d %d", caseNumber, trace, duplicateRows, duplicateCols));
        }

        reader.close();
        writer.close();
    }
}