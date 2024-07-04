import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader reader;
    static BufferedWriter writer;

    static String readLine() throws IOException {
        String line = "";
        while (line.isEmpty()) {
            line = reader.readLine();
        }
        return line;
    }

    static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    static long parseLong(String s) {
        return Long.parseLong(s);
    }

    static int[] readIntArray() throws IOException {
        String[] tokens = readLine().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseInt(tokens[i]);
        }
        return array;
    }

    static long[] readLongArray() throws IOException {
        String[] tokens = readLine().split(" ");
        long[] array = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseLong(tokens[i]);
        }
        return array;
    }

    static void initializeIO() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    static void solve(int b) throws IOException {
        if (b != 10) {
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            writer.write((i + 1) + "\n");
            writer.flush();
            String input = readLine();
            result.append(input.charAt(0));
        }

        writer.write(result.toString());
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        initializeIO();
        int[] parameters = readIntArray();
        int t = parameters[0], b = parameters[1];

        for (int ks = 1; ks <= t; ks++) {
            solve(b);
            String response = readLine();
            if (response.charAt(0) == 'N') {
                return;
            }
        }
    }
}