import java.util.*;
import java.io.*;

class Solution {
    // Input and output handlers
    static BufferedReader reader;
    static BufferedWriter writer;

    static void initializeIO() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    static String readLine() throws IOException {
        String line;
        do {
            line = reader.readLine();
        } while (line.isEmpty());
        return line;
    }

    static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    static long parseLong(String input) {
        return Long.parseLong(input);
    }

    static int[] parseIntArray() throws IOException {
        String[] tokens = readLine().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseInt(tokens[i]);
        }
        return array;
    }

    static long[] parseLongArray() throws IOException {
        String[] tokens = readLine().split(" ");
        long[] array = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseLong(tokens[i]);
        }
        return array;
    }

    public static void main(String[] args) throws IOException {
        initializeIO();
        int testCases = parseInt(readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = parseInt(readLine());
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                matrix[i] = parseIntArray();
                trace += matrix[i][i];
            }

            int duplicateRows = 0, duplicateCols = 0;
            Set<Integer> uniqueElements = new HashSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    uniqueElements.add(matrix[i][j]);
                }
                if (uniqueElements.size() != n) {
                    duplicateRows++;
                }
                uniqueElements.clear();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    uniqueElements.add(matrix[j][i]);
                }
                if (uniqueElements.size() != n) {
                    duplicateCols++;
                }
                uniqueElements.clear();
            }

            writer.write(String.format("Case #%d: %d %d %d%n", caseNumber++, trace, duplicateRows, duplicateCols));
        }
        writer.flush();
    }
}