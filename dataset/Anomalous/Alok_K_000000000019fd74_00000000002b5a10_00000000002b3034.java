import java.util.*;
import java.io.*;

class Solution {

    static BufferedReader reader;
    static BufferedWriter writer;

    static String read() throws IOException {
        String line = "";
        while (line.length() == 0) {
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

    static int[] parseIntArray() throws IOException {
        String[] tokens = read().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseInt(tokens[i]);
        }
        return array;
    }

    static long[] parseLongArray() throws IOException {
        String[] tokens = read().split(" ");
        long[] array = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseLong(tokens[i]);
        }
        return array;
    }

    static void initialize() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void main(String[] args) throws IOException {
        initialize();
        int testCases = parseInt(read());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = parseInt(read());
            String[] arr = new String[n];
            int maxLength = 0;
            int maxLengthIndex = -1;
            Set<Character> charSet = new HashSet<>();

            for (int i = 0; i < n; i++) {
                arr[i] = new StringBuilder(read()).reverse().toString();
                if (arr[i].length() > maxLength) {
                    maxLength = arr[i].length();
                    maxLengthIndex = i;
                }
            }

            boolean isValid = true;
            int j = 0;
            int starCount = 0;
            boolean[] isProcessed = new boolean[n];

            while (true) {
                for (int i = 0; i < n; i++) {
                    if (isProcessed[i]) {
                        continue;
                    }
                    if (arr[i].charAt(j) == '*') {
                        starCount++;
                        isProcessed[i] = true;
                        continue;
                    }
                    charSet.add(arr[i].charAt(j));
                }
                j++;
                if (charSet.size() > 1) {
                    isValid = false;
                    break;
                }
                if (starCount == n) {
                    break;
                }
                charSet.clear();
            }

            writer.write("Case #" + caseNumber + ": ");
            if (isValid) {
                for (int i = maxLength - 2; i >= 0; i--) {
                    writer.write(arr[maxLengthIndex].charAt(i));
                }
            } else {
                writer.write("*");
            }
            writer.write("\n");
            caseNumber++;
        }
        writer.flush();
    }
}