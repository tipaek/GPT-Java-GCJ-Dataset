import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static boolean isLocal = false;

    void processCase() throws IOException {
        int n = nextInt();
        int k = nextInt();
        if (k % n != 0) {
            out.println("IMPOSSIBLE");
            return;
        }
        out.println("POSSIBLE");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int x = ((j - i + k / n) % n + n) % n;
                if (x == 0) x = n;
                if (x <= 0 || x > n) while (true);  // Infinite loop safeguard
                out.print(x + (j < n ? " " : ""));
            }
            out.println();
        }
    }

    void solve() throws Exception {
        int t = nextInt();
        for (int i = 1; i <= t; i++) {
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
        int temp = array[i];
        array[i] = array[j - 1];
        array[j - 1] = temp;

        for (int p = i + 1, q = n - 1; p < q; p++, q--) {
            temp = array[p];
            array[p] = array[q];
            array[q] = temp;
        }
        return true;
    }

    int[] sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    private int[] readIntArray(int n) throws IOException {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = nextInt();
        return array;
    }

    private long[] readLongArray(int n) throws IOException {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) array[i] = nextLong();
        return array;
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    String next() throws IOException {
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