import java.io.*;
import java.util.*;

class Solution {
    static BufferedReader reader;
    static BufferedWriter writer;

    // Method to read a line from input
    static String readLine() throws IOException {
        String line = "";
        while (line.isEmpty()) {
            line = reader.readLine();
        }
        return line;
    }

    // Method to convert string to integer
    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    // Method to convert string to long
    static long toLong(String s) {
        return Long.parseLong(s);
    }

    // Method to read an array of integers from input
    static int[] readIntArray() throws IOException {
        String[] tokens = readLine().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = toInt(tokens[i]);
        }
        return array;
    }

    // Method to read an array of longs from input
    static long[] readLongArray() throws IOException {
        String[] tokens = readLine().split(" ");
        long[] array = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = toLong(tokens[i]);
        }
        return array;
    }

    // Method to initialize reader and writer
    static void initialize() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void main(String[] args) throws IOException {
        initialize();
        int testCases = toInt(readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = toInt(readLine());
            int[][] intervals = new int[n][3];
            int[][] originalIntervals = new int[n][3];

            for (int i = 0; i < n; i++) {
                int[] interval = readIntArray();
                intervals[i][0] = interval[0];
                intervals[i][1] = interval[1];
                originalIntervals[i][0] = interval[0];
                originalIntervals[i][1] = interval[1];
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int cEnd = 0, jEnd = 0;
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                if (cEnd <= intervals[i][0]) {
                    cEnd = intervals[i][1];
                    intervals[i][2] = 1; // C
                } else if (jEnd <= intervals[i][0]) {
                    jEnd = intervals[i][1];
                    intervals[i][2] = 2; // J
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
                        if (intervals[j][2] == -1) continue;
                        if (originalIntervals[i][0] == intervals[j][0] && originalIntervals[i][1] == intervals[j][1]) {
                            originalIntervals[i][2] = intervals[j][2];
                            intervals[j][2] = -1;
                            break;
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    writer.write(originalIntervals[i][2] == 1 ? 'C' : 'J');
                }
                writer.write("\n");
            }

            caseNumber++;
        }
        writer.flush();
    }
}