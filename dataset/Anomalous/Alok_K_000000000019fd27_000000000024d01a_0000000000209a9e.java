import java.util.*;
import java.io.*;

class Solution {

    private static BufferedReader reader;
    private static BufferedWriter writer;

    private static String read() throws IOException {
        String line;
        do {
            line = reader.readLine();
        } while (line.isEmpty());
        return line;
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    private static long parseLong(String s) {
        return Long.parseLong(s);
    }

    private static int[] readIntArray() throws IOException {
        String[] tokens = read().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseInt(tokens[i]);
        }
        return array;
    }

    private static long[] readLongArray() throws IOException {
        String[] tokens = read().split(" ");
        long[] array = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseLong(tokens[i]);
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
            String response = read();
            sb.append(response.charAt(0));
        }

        writer.write(sb.toString());
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        initializeIO();
        int[] input = readIntArray();
        int t = input[0];
        int b = input[1];

        for (int i = 1; i <= t; i++) {
            solve(b);
            read(); // Read and discard the response after solving each test case
        }
    }
}