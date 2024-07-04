import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static boolean isLocal = false;

    static class Segment implements Comparable<Segment> {
        int start, end, index;

        Segment(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Segment other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }

    void handleCase() throws IOException {
        int n = nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            segments[i] = new Segment(nextInt(), nextInt(), i);
        }
        Arrays.sort(segments);
        
        char[] result = new char[n];
        Segment lastC = new Segment(-1, -1, -1);
        Segment lastJ = new Segment(-1, -1, -1);
        
        for (Segment segment : segments) {
            if (segment.start >= lastC.end) {
                lastC = segment;
                result[segment.index] = 'C';
            } else if (segment.start >= lastJ.end) {
                lastJ = segment;
                result[segment.index] = 'J';
            } else {
                out.println("IMPOSSIBLE");
                return;
            }
        }
        out.println(new String(result));
    }

    void solve() throws Exception {
        int t = nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            handleCase();
        }
    }

    int[] sortArray(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
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

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
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