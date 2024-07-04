import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader reader;
    private static PrintWriter writer;
    private static StringTokenizer tokenizer;
    private static final boolean isLocal = false;

    public static void main(String[] args) throws Exception {
        try {
            if (isLocal) {
                reader = new BufferedReader(new FileReader("src/tests/1.in"));
                writer = new PrintWriter(new BufferedWriter(new FileWriter("src/tests/1.out")));
            } else {
                reader = new BufferedReader(new InputStreamReader(System.in));
                writer = new PrintWriter(new OutputStreamWriter(System.out));
            }

            new Solution().solve();
            reader.close();
            writer.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void solve() throws Exception {
        int testCases = nextInt();
        for (int i = 1; i <= testCases; i++) {
            writer.print("Case #" + i + ": ");
            processCase();
        }
    }

    private void processCase() throws IOException {
        int n = nextInt();
        int diagonalSum = 0, duplicateRows = 0, duplicateCols = 0;
        int[][] matrix = new int[n][n];
        Set<Integer> uniqueElements;

        for (int i = 0; i < n; i++) {
            uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = nextInt();
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != n) {
                duplicateRows++;
            }
        }

        for (int j = 0; j < n; j++) {
            uniqueElements = new HashSet<>();
            for (int i = 0; i < n; i++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != n) {
                duplicateCols++;
            }
        }

        writer.println(diagonalSum + " " + duplicateRows + " " + duplicateCols);
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private int[] readIntArray(int size) throws IOException {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    private long[] readLongArray(int size) throws IOException {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = nextLong();
        }
        return array;
    }

    private void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, middle + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }
}