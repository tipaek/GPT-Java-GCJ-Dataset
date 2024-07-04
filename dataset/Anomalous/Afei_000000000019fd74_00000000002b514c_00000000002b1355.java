import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; i++) {
                int rows = scanner.nextInt();
                int columns = scanner.nextInt();
                int[][] matrix = readMatrix(scanner, rows, columns);
                long result = processMatrix(rows, columns, matrix);
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }

    private static long processMatrix(int rows, int columns, int[][] matrix) {
        int[][] current = matrix;
        matrix = new int[rows][columns];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        long totalSum = 0;

        while (!areMatricesEqual(matrix, current)) {
            int[][] temp = matrix;
            matrix = current;
            current = temp;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    int count = 0;
                    long neighborSum = 0;
                    for (int[] direction : directions) {
                        int newRow = i + direction[0];
                        int newColumn = j + direction[1];
                        while (isValid(newRow, newColumn, rows, columns) && matrix[newRow][newColumn] == 0) {
                            newRow += direction[0];
                            newColumn += direction[1];
                        }
                        if (isValid(newRow, newColumn, rows, columns)) {
                            neighborSum += matrix[newRow][newColumn];
                            count++;
                        }
                    }
                    current[i][j] = (matrix[i][j] * count < neighborSum) ? 0 : matrix[i][j];
                }
            }
            totalSum += calculateSum(matrix);
        }
        return totalSum;
    }

    private static boolean isValid(int row, int column, int rows, int columns) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    private static boolean areMatricesEqual(int[][] matrix1, int[][] matrix2) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static long calculateSum(int[][] matrix) {
        long sum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
            }
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    static long mod = 1000000007;

    static long add(long a, long b) {
        long result = a + b;
        if (result < 0) {
            result += mod;
        }
        return result % mod;
    }

    static long multiply(long a, long b) {
        return (a * b) % mod;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static String arrayToString(int[] array) {
        return Arrays.toString(array).replaceAll("[\\[\\],]", "");
    }

    static int[] readIntArray(Scanner scanner, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
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
        BufferedReader reader;
        StringTokenizer tokenizer;

        FastScanner(File file) {
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        @Override
        public void close() throws IOException {
            reader.close();
        }
    }
}