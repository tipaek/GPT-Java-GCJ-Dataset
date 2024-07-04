import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static void solve() throws Exception {
        int r = scanInt();
        int s = scanInt();
        int[] a1 = new int[r * s];
        int[] a2 = new int[r * s];
        
        for (int i = 0; i < r * s; i++) {
            a1[i] = i % r;
        }
        
        printCase();
        out.println((r * (s - 1) + 1) / 2);
        
        for (int i = (r * (s - 1) + 1) / 2 - 1; i >= 0; i--) {
            int p1, p2;
            if (i == 0 && (r * (s - 1) & 1) != 0) {
                p1 = findIndex(a1, 0);
                p2 = r * s;
            } else {
                p1 = findNextDistinctIndex(a1, 0, 2);
                p2 = findNextDistinctIndex(a1, p1, r - 1);
            }
            out.println(p1 + " " + (p2 - p1));
            rearrangeArray(a1, a2, p1, p2, r * s);
            int[] temp = a1;
            a1 = a2;
            a2 = temp;
        }
        
        validateArray(a1, r, s);
    }

    static int findIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
    
    static int findNextDistinctIndex(int[] array, int start, int distinctCount) {
        int count = 0;
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                count++;
                if (count == distinctCount) {
                    return i;
                }
            }
        }
        return -1;
    }

    static void rearrangeArray(int[] source, int[] target, int p1, int p2, int length) {
        System.arraycopy(source, 0, target, p2 - p1, p1);
        System.arraycopy(source, p1, target, 0, p2 - p1);
        System.arraycopy(source, p2, target, p2, length - p2);
    }

    static void validateArray(int[] array, int r, int s) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i / s) {
                throw new AssertionError();
            }
        }
    }

    static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    static long scanLong() throws IOException {
        return Long.parseLong(scanString());
    }

    static String scanString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static void printCase() {
        out.print("Case #" + testNumber + ": ");
    }

    static BufferedReader reader;
    static PrintWriter out;
    static StringTokenizer tokenizer;
    static int testNumber;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int testCount = scanInt();
            for (testNumber = 1; testNumber <= testCount; testNumber++) {
                solve();
            }
            reader.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}