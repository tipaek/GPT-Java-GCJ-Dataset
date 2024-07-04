import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tokenizer;
    static boolean isLocal = false;

    void processCase() throws IOException {
        int n = nextInt(), k = nextInt();
        if (k % n != 0) {
            writer.println("IMPOSSIBLE");
            return;
        }
        writer.println("POSSIBLE");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int x = ((j - i + k / n) % n + n) % n;
                if (x == 0) x = n;
                writer.print(x + " ");
            }
            writer.println();
        }
    }

    void solve() throws Exception {
        int t = nextInt();
        for (int i = 1; i <= t; i++) {
            writer.print("Case #" + i + ": ");
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

        for (int p = i + 1, q = n - 1; p < q; p++, q--) {
            swap(array, p, q);
        }
        return true;
    }

    private static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    int[] sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, middle + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArray[i++];
        }

        while (j < n2) {
            arr[k++] = rightArray[j++];
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

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public static void main(String[] args) throws Exception {
        try {
            if (isLocal) {
                reader = new BufferedReader(new FileReader("src/tests/sol.in"));
                writer = new PrintWriter(new BufferedWriter(new FileWriter("src/tests/sol.out")));
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
}