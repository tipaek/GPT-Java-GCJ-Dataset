import java.io.*;
import java.util.*;

public class Solution {
    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    public static void main(String[] args) {
        try {
            inputStream = System.in;
            out = new PrintWriter(System.out);
            in = new InputReader(inputStream);

            int tests = in.nextInt();
            for (test = 1; test <= tests; test++) {
                printCase();
                solve();
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static void solve() throws Exception {
        int R = in.nextInt();
        int C = in.nextInt();

        int[] arr = new int[R * C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i * C + j] = in.nextInt();
            }
        }

        int[] next = Arrays.copyOf(arr, R * C);
        int interest = calsInterest(arr, R * C);
        int eluminated;

        do {
            eluminated = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (arr[i * C + j] != Integer.MAX_VALUE) {
                        int totalClass = 0;
                        int totalNeighbor = 0;

                        totalNeighbor += updateTotals(arr, i, j, -1, 0, R, C, totalClass);
                        totalNeighbor += updateTotals(arr, i, j, 1, 0, R, C, totalClass);
                        totalNeighbor += updateTotals(arr, i, j, 0, -1, R, C, totalClass);
                        totalNeighbor += updateTotals(arr, i, j, 0, 1, R, C, totalClass);

                        if (totalNeighbor > 0 && arr[i * C + j] * totalNeighbor < totalClass) {
                            next[i * C + j] = Integer.MAX_VALUE;
                            eluminated++;
                        }
                    }
                }
            }
            arr = Arrays.copyOf(next, R * C);
            if (eluminated > 0) {
                interest += calsInterest(arr, R * C);
            }
        } while (eluminated > 0);

        out.println(interest);
    }

    static int updateTotals(int[] arr, int i, int j, int di, int dj, int R, int C, int totalClass) {
        int t = 1;
        while (isValid(i + t * di, j + t * dj, R, C) && arr[(i + t * di) * C + (j + t * dj)] == Integer.MAX_VALUE) {
            t++;
        }
        if (isValid(i + t * di, j + t * dj, R, C)) {
            totalClass += arr[(i + t * di) * C + (j + t * dj)];
            return 1;
        }
        return 0;
    }

    static boolean isValid(int i, int j, int R, int C) {
        return i >= 0 && i < R && j >= 0 && j < C;
    }

    static int calsInterest(int[] array, int len) {
        int interest = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] != Integer.MAX_VALUE) {
                interest += array[i];
            }
        }
        return interest;
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String str = reader.readLine();
                    if (str == null) {
                        return "";
                    } else {
                        tokenizer = new StringTokenizer(str);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}