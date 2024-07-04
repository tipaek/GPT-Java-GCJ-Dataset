import java.util.*;
import java.io.*;

class Solution {

    private static BufferedReader reader;
    private static BufferedWriter writer;

    private static String readLine() throws IOException {
        String line;
        while ((line = reader.readLine()) != null && line.isEmpty()) {
            // Continue reading until a non-empty line is found
        }
        return line;
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    private static long parseLong(String s) {
        return Long.parseLong(s);
    }

    private static int[] readIntArray() throws IOException {
        String[] parts = readLine().split(" ");
        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = parseInt(parts[i]);
        }
        return array;
    }

    private static long[] readLongArray() throws IOException {
        String[] parts = readLine().split(" ");
        long[] array = new long[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = parseLong(parts[i]);
        }
        return array;
    }

    private static void initializeIO() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void solve(int b) throws IOException {
        if (b != 10) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            writer.write((i + 1) + "\n");
            writer.flush();
            String input = readLine();
            sb.append(input.charAt(0));
        }
        writer.write(sb.toString());
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        initializeIO();
        int[] inputParams = readIntArray();
        int t = inputParams[0];
        int b = inputParams[1];
        for (int ks = 1; ks <= t; ks++) {
            solve(b);
        }
    }
}