import java.util.*;
import java.io.*;

class Solution {
    // BufferedReader and BufferedWriter for input and output
    static BufferedReader reader;
    static BufferedWriter writer;

    // Method to read a non-empty line
    static String readLine() throws IOException {
        String line = "";
        while (line.length() == 0) {
            line = reader.readLine();
        }
        return line;
    }

    // Method to parse an integer from a string
    static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    // Method to parse a long from a string
    static long parseLong(String s) {
        return Long.parseLong(s);
    }

    // Method to read an array of integers from a line
    static int[] readIntArray() throws IOException {
        String[] tokens = readLine().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseInt(tokens[i]);
        }
        return array;
    }

    // Method to read an array of longs from a line
    static long[] readLongArray() throws IOException {
        String[] tokens = readLine().split(" ");
        long[] array = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseLong(tokens[i]);
        }
        return array;
    }

    // Method to initialize the reader and writer
    static void initializeIO() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    // Method to calculate a unique hash for a pair of integers
    static int calculateHash(int i, int j) {
        return (i + j) * (i + j + 1) + i;
    }

    public static void main(String[] args) throws IOException {
        initializeIO();
        int t = parseInt(readLine());
        int caseNumber = 1;

        while (t-- > 0) {
            int n = parseInt(readLine());
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i] = readIntArray();
            }

            int[][] originalIntervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                originalIntervals[i][0] = intervals[i][0];
                originalIntervals[i][1] = intervals[i][1];
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            Map<Integer, Character> assignmentMap = new HashMap<>();
            int cEnd = 0, jEnd = 0;
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                if (cEnd <= intervals[i][0]) {
                    cEnd = intervals[i][1];
                    assignmentMap.put(calculateHash(intervals[i][0], intervals[i][1]), 'C');
                } else if (jEnd <= intervals[i][0]) {
                    jEnd = intervals[i][1];
                    assignmentMap.put(calculateHash(intervals[i][0], intervals[i][1]), 'J');
                } else {
                    isImpossible = true;
                    break;
                }
            }

            writer.write("Case #" + caseNumber + ": ");
            if (isImpossible) {
                writer.write("IMPOSSIBLE\n");
            } else {
                for (int i = 0; i < n; i++) {
                    writer.write(assignmentMap.get(calculateHash(originalIntervals[i][0], originalIntervals[i][1])));
                }
                writer.write("\n");
            }

            caseNumber++;
        }

        writer.flush();
    }
}