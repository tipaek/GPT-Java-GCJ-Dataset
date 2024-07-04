import java.io.*;
import java.util.*;

class Solution {
    // Input and output streams
    private static BufferedReader reader;
    private static BufferedWriter writer;

    // Method to read a line of input
    private static String readLine() throws IOException {
        String line = "";
        while (line.isEmpty()) {
            line = reader.readLine();
        }
        return line;
    }

    // Method to parse an integer from a string
    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    // Method to parse a long from a string
    private static long parseLong(String input) {
        return Long.parseLong(input);
    }

    // Method to read an array of integers from a line of input
    private static int[] readIntArray() throws IOException {
        String[] tokens = readLine().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseInt(tokens[i]);
        }
        return array;
    }

    // Method to read an array of longs from a line of input
    private static long[] readLongArray() throws IOException {
        String[] tokens = readLine().split(" ");
        long[] array = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseLong(tokens[i]);
        }
        return array;
    }

    // Method to initialize input and output streams
    private static void initializeIO() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void main(String[] args) throws IOException {
        initializeIO();
        int t = parseInt(readLine());
        int caseNumber = 1;

        while (t-- > 0) {
            int n = parseInt(readLine());
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                matrix[i] = readIntArray();
                trace += matrix[i][i];
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Check for duplicate values in rows and columns
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }

                if (rowSet.size() != n) {
                    rowDuplicates++;
                }

                if (colSet.size() != n) {
                    colDuplicates++;
                }
            }

            // Output the result for the current test case
            writer.write("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates + "\n");
            caseNumber++;
        }

        writer.flush();
    }
}