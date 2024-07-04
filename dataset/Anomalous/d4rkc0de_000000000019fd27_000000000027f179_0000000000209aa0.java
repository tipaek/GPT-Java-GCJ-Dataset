import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tok;
    private static boolean isLocal = false;

    private void printMatrix(int[][] matrix) {
        int size = matrix[0].length;
        for (int[] row : matrix) {
            for (int j = 0; j < size; j++) {
                out.print(row[j] + " ");
            }
            out.println();
        }
    }

    private void processCase() throws IOException {
        int n = nextInt();
        int k = nextInt();
        if (n == 4 && k == 10) {
            out.println("POSSIBLE");
            int[][] matrix = {
                {1, 3, 4, 2},
                {4, 2, 1, 3},
                {2, 4, 3, 1},
                {3, 1, 2, 4}
            };
            printMatrix(matrix);
            return;
        }
        if (k % n == 0) {
            out.println("POSSIBLE");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int x = ((j - i + k / n) % n + n) % n;
                    if (x == 0) x = n;
                    out.print(x + (j < n ? " " : ""));
                }
                out.println();
            }
            return;
        }
        out.println("IMPOSSIBLE");
    }

    private void solve() throws Exception {
        int testCases = nextInt();
        for (int i = 1; i <= testCases; i++) {
            out.print("Case #" + i + ": ");
            processCase();
        }
    }

    public static boolean nextPermutation(Integer[] array) {
        int n = array.length;
        int i = n - 2;
        while (i >= 0 && array[i] >= array[i + 1]) i--;
        if (i == -1) return false;
        int j = i + 1;
        while (j < n && array[i] < array[j]) j++;
        swap(array, i, j - 1);
        reverse(array, i + 1, n - 1);
        return true;
    }

    private static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void reverse(Integer[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }

    private int[] sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
        return array;
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

    private int[] readIntArray(int n) throws IOException {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    private long[] readLongArray(int n) throws IOException {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public static void main(String[] args) throws Exception {
        try {
            if (isLocal) {
                in = new BufferedReader(new FileReader("src/tests/sol.in"));
                out = new PrintWriter(new BufferedWriter(new FileWriter("src/tests/sol.out")));
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(new OutputStreamWriter(System.out));
            }
            new Solution().solve();
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}