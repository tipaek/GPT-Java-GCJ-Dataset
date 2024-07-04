import java.io.*;
import java.util.*;

class Solution {
    // BufferedReader and BufferedWriter for input and output operations
    static BufferedReader reader;
    static BufferedWriter writer;

    // Method to read a non-empty line from the input
    static String readLine() throws IOException {
        String line = "";
        while (line.isEmpty()) {
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

    // Method to parse an array of integers from a line of input
    static int[] parseIntArray() throws IOException {
        String[] tokens = readLine().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseInt(tokens[i]);
        }
        return array;
    }

    // Method to parse an array of longs from a line of input
    static long[] parseLongArray() throws IOException {
        String[] tokens = readLine().split(" ");
        long[] array = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseLong(tokens[i]);
        }
        return array;
    }

    // Method to initialize the BufferedReader and BufferedWriter
    static void initializeIO() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void main(String[] args) throws IOException {
        initializeIO();
        int testCases = parseInt(readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = parseInt(readLine());
            int[][] intervals = new int[n][3];

            for (int i = 0; i < n; i++) {
                int[] interval = parseIntArray();
                intervals[i][0] = interval[0];
                intervals[i][1] = interval[1];
            }

            int[][] originalIntervals = new int[n][3];
            for (int i = 0; i < n; i++) {
                originalIntervals[i][0] = intervals[i][0];
                originalIntervals[i][1] = intervals[i][1];
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int cEnd = 0, jEnd = 0;
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                if (cEnd <= intervals[i][0]) {
                    cEnd = intervals[i][1];
                    intervals[i][2] = 1; // Assigned to C
                } else if (jEnd <= intervals[i][0]) {
                    jEnd = intervals[i][1];
                    intervals[i][2] = 2; // Assigned to J
                } else {
                    impossible = true;
                    break;
                }
            }

            writer.write("Case #" + caseNumber + ": ");
            if (impossible) {
                writer.write("IMPOSSIBLE\n");
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (originalIntervals[i][0] == intervals[j][0] && originalIntervals[i][1] == intervals[j][1]) {
                            originalIntervals[i][2] = intervals[j][2];
                            break;
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    char assigned = originalIntervals[i][2] == 1 ? 'C' : 'J';
                    writer.write(assigned);
                }
                writer.write("\n");
            }
            caseNumber++;
        }
        writer.flush();
    }
}