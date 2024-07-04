import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        execute();
    }

    private static void execute() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            String result = process(input);
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }

    private static String process(String input) {
        StringBuilder result = new StringBuilder();
        int previous = 0;
        int current = 0;
        for (char character : input.toCharArray()) {
            current = character - '0';
            appendParentheses(result, current - previous);
            result.append(character);
            previous = current;
        }
        current = 0;
        appendParentheses(result, current - previous);
        return result.toString();
    }

    private static void appendParentheses(StringBuilder sb, int difference) {
        int count = Math.abs(difference);
        for (int i = 0; i < count; i++) {
            sb.append(difference > 0 ? "(" : ")");
        }
    }

    static final long MOD = 1000000007L;

    static long addModulo(long a, long b) {
        long result = a + b;
        if (result < 0) {
            result += MOD;
        }
        return result % MOD;
    }

    static long multiplyModulo(long a, long b) {
        return (a * b) % MOD;
    }

    static int greatestCommonDivisor(int a, int b) {
        return (b == 0) ? a : greatestCommonDivisor(b, a % b);
    }

    static String arrayToString(int[] array) {
        String[] strArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            strArray[i] = Integer.toString(array[i]);
        }
        return String.join(" ", strArray);
    }

    static int[] readIntArray(Scanner scanner, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    static int[][] readIntMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readIntArray(scanner, cols);
        }
        return matrix;
    }

    static char[] readCharArray(Scanner scanner, int size) {
        return scanner.next().toCharArray();
    }

    static String[] readStringArray(Scanner scanner, int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.next();
        }
        return array;
    }

    static Map<Integer, List<Integer>> readEdges(Scanner scanner, int size, boolean directed) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            edges.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            if (!directed) {
                edges.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
            }
        }
        return edges;
    }

    static class FastScanner implements Closeable {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File file) {
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        @Override
        public void close() throws IOException {
            br.close();
        }
    }
}