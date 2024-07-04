import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader reader;
    private static PrintWriter writer;
    private static StringTokenizer tokenizer;
    private static final boolean isLocal = false;

    private static final int RADIUS = (int) (1e9 - 5);
    private static final int MIN = (int) -1e9;

    private static String flushOutput(Object message) throws IOException {
        writer.println(message);
        writer.flush();
        return nextToken();
    }

    private static void processCase() throws IOException {
        for (int x = MIN; x <= MIN + 10; x++) {
            for (int y = -5; y <= 5; y++) {
                String response1 = flushOutput(x + " " + (y - 1));
                String response2 = flushOutput(x + " " + y);
                String response3 = flushOutput(x + " " + (y + 1));
                if ("MISS".equals(response1) && "HIT".equals(response2) && "MISS".equals(response3)) {
                    flushOutput((x + RADIUS) + " " + y);
                    return;
                }
            }
        }
    }

    private static void solve() throws Exception {
        int testCases = nextInt();
        int a = nextInt();
        int b = nextInt();
        for (int i = 1; i <= testCases; i++) {
            processCase();
        }
    }

    private int[] sortArray(int[] array) {
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
        int leftSize = middle - left + 1;
        int rightSize = right - middle;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        System.arraycopy(array, left, leftArray, 0, leftSize);
        System.arraycopy(array, middle + 1, rightArray, 0, rightSize);
        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }
        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }
    }

    private static class Segment implements Comparable<Segment> {
        int start, end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Segment segment = (Segment) obj;
            return start == segment.start && end == segment.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public int compareTo(Segment segment) {
            return start == segment.start ? Integer.compare(end, segment.end) : Integer.compare(start, segment.start);
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

    private static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private static String nextToken() throws IOException {
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