import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static long factorial(int number) {
        if (number <= 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static int binarySearch(int[] array, int low, int high, int element) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == element) {
                return mid;
            } else if (array[mid] < element) {
                return binarySearch(array, mid + 1, high, element);
            } else {
                return binarySearch(array, low, mid - 1, element);
            }
        }
        return -1;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int testCases = Reader.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = Reader.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Reader.nextInt();
                }
            }
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            for (int j = 0; j < n; j++) {
                diagonalSum += matrix[j][j];
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    rowSet.add(matrix[j][k]);
                    colSet.add(matrix[k][j]);
                }
                if (rowSet.size() < n) {
                    duplicateRows++;
                }
                if (colSet.size() < n) {
                    duplicateCols++;
                }
            }
            System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}

class Reader {
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    public static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    public static String nextLine() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(nextLine());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(nextLine());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(nextLine());
    }

    public static float nextFloat() throws IOException {
        return Float.parseFloat(nextLine());
    }

    public static int[] nextIntArray(int length) throws IOException {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(nextLine());
        }
        return array;
    }

    public static long[] nextLongArray(int length) throws IOException {
        long[] array = new long[length];
        for (int i = 0; i < length; i++) {
            array[i] = Long.parseLong(nextLine());
        }
        return array;
    }
}