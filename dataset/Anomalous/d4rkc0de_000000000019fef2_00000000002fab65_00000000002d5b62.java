import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tok;
    private static final boolean isLocal = false;

    private String ans;
    private int targetX, targetY;

    private void findPath(int x, int y, int step, String path) {
        if (step > 10) return;
        if (x == targetX && y == targetY) {
            if (path.length() < ans.length()) {
                ans = path;
            }
            return;
        }
        int distance = 1 << step;
        findPath(x - distance, y, step + 1, path + "W");
        findPath(x + distance, y, step + 1, path + "E");
        findPath(x, y - distance, step + 1, path + "S");
        findPath(x, y + distance, step + 1, path + "N");
    }

    private void processCase() throws IOException {
        targetX = nextInt();
        targetY = nextInt();
        ans = "###############";
        findPath(0, 0, 0, "");
        out.println(ans.equals("###############") ? "IMPOSSIBLE" : ans);
    }

    private void solve() throws Exception {
        int testCases = nextInt();
        for (int i = 1; i <= testCases; i++) {
            out.print("Case #" + i + ": ");
            processCase();
        }
    }

    private int[] sortArray(int[] array) {
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);
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

    private class Segment implements Comparable<Segment> {
        private final int start;
        private final int end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Segment segment = (Segment) o;
            return start == segment.start && end == segment.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public int compareTo(Segment segment) {
            int startComparison = Integer.compare(this.start, segment.start);
            return startComparison != 0 ? startComparison : Integer.compare(this.end, segment.end);
        }
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
            exit(1);
        }
    }
}