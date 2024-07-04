import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = in.nextInt();
        int b = in.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int[] arr = new int[b];
            int found = 0, done = 0;

            while (found < b) {
                if (done % 10 == 0 && done != 0) {
                    handleQuery(arr, found, b, in, out);
                    done += 2;
                }

                out.write((found / 2 + 1) + "\n");
                out.flush();
                arr[found / 2] = in.nextInt();

                out.write((b - found / 2) + "\n");
                out.flush();
                arr[b - 1 - found / 2] = in.nextInt();

                found += 2;
                done += 2;
            }

            StringBuilder result = new StringBuilder();
            for (int bi : arr) {
                result.append(bi);
            }

            out.write(result.toString() + "\n");
            out.flush();

            if (in.next().equals("N")) {
                return;
            }
        }
    }

    private static void handleQuery(int[] arr, int found, int b, FastReader in, BufferedWriter out) throws IOException {
        int eq = findEqualIndex(arr, found, b);
        if (eq != -1) {
            processEqualIndex(arr, eq, b, in, out);
        }

        int diff = findDifferentIndex(arr, found, b);
        if (diff != -1) {
            processDifferentIndex(arr, diff, b, in, out);
        }
    }

    private static int findEqualIndex(int[] arr, int found, int b) {
        for (int i = 0; i < found / 2; i++) {
            if (arr[i] == arr[b - 1 - i]) {
                return i;
            }
        }
        return -1;
    }

    private static void processEqualIndex(int[] arr, int eq, int b, FastReader in, BufferedWriter out) throws IOException {
        out.write((eq + 1) + "\n");
        out.flush();
        int ans = in.nextInt();

        if (ans != arr[eq]) {
            for (int i = 0; i < arr.length / 2; i++) {
                arr[i] ^= 1;
                arr[b - 1 - i] ^= 1;
            }
        }

        out.write((b - eq) + "\n");
        out.flush();
        in.nextInt();
    }

    private static int findDifferentIndex(int[] arr, int found, int b) {
        for (int i = 0; i < found / 2; i++) {
            if (arr[i] != arr[b - 1 - i]) {
                return i;
            }
        }
        return -1;
    }

    private static void processDifferentIndex(int[] arr, int diff, int b, FastReader in, BufferedWriter out) throws IOException {
        out.write((diff + 1) + "\n");
        out.flush();
        int ans = in.nextInt();

        if (ans != arr[diff]) {
            for (int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[b - 1 - i];
                arr[b - 1 - i] = temp;
            }
        }

        out.write((b - diff) + "\n");
        out.flush();
        in.nextInt();
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    public long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

    public double[] nextDoubleArray(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextDouble();
        }
        return array;
    }

    public String[] nextStringArray(int n) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = next();
        }
        return array;
    }
}