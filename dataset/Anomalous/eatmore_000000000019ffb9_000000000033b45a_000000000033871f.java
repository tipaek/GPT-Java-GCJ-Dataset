import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static void heapSort(int[] array, int n, int[] values) {
        if (n == 0) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int currentIndex = i;
            int currentElement = array[i];
            int currentValue = values[currentElement];
            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                int parentElement = array[parentIndex];
                if (currentValue <= values[parentElement]) {
                    break;
                }
                array[currentIndex] = parentElement;
                currentIndex = parentIndex;
            }
            array[currentIndex] = currentElement;
        }
        int lastElement = array[0];
        for (int i = n - 1; i > 0; i--) {
            int currentIndex = 0;
            while (2 * currentIndex + 2 < i) {
                int leftChild = 2 * currentIndex + 1;
                int rightChild = 2 * currentIndex + 2;
                currentIndex = (values[array[rightChild]] > values[array[leftChild]]) ? rightChild : leftChild;
            }
            if (2 * currentIndex + 2 == i) {
                currentIndex = 2 * currentIndex + 1;
            }
            int temp = array[i];
            array[i] = lastElement;
            lastElement = temp;
            int currentValue = values[lastElement];
            while (currentIndex > 0 && values[array[(currentIndex - 1) / 2]] < currentValue) {
                array[currentIndex] = array[(currentIndex - 1) / 2];
                currentIndex = (currentIndex - 1) / 2;
            }
            array[currentIndex] = lastElement;
        }
        array[0] = lastElement;
    }

    static void solve() throws Exception {
        int c = scanInt(), d = scanInt();
        int[] x = new int[c];
        int[] idx = new int[c];
        for (int i = 1; i < c; i++) {
            x[i] = scanInt();
            idx[i] = i;
        }
        heapSort(idx, c, x);
        int[] u = new int[d], v = new int[d];
        for (int i = 0; i < d; i++) {
            u[i] = scanInt() - 1;
            v[i] = scanInt() - 1;
        }
        int p1;
        for (p1 = 0; idx[p1] != 0; p1++) {}
        int p2 = p1, p = 1, t = 0;
        while (p < c) {
            if (p1 > 0 && x[idx[p1 - 1]] == -p) {
                ++t;
                for (--p1; p1 >= 0 && x[idx[p1]] == -p; p1--) {
                    x[idx[p1]] = t;
                }
                ++p1;
            } else {
                t = x[idx[p2 + 1]];
                for (++p2; p2 < c && x[idx[p2]] == t; p2++) {}
                --p2;
            }
            p = p2 - p1 + 1;
        }
        printCase();
        for (int i = 0; i < d; i++) {
            out.print(Math.max(Math.abs(x[u[i]] - x[v[i]]), 1) + " ");
        }
        out.println();
    }

    static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    static long scanLong() throws IOException {
        return Long.parseLong(scanString());
    }

    static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static int test;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int tests = scanInt();
            for (test = 1; test <= tests; test++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}