import java.io.*;
import java.math.BigInteger;
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
        int X = in.nextInt();
        int Y = in.nextInt();
        String path = in.next();

        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            switch (direction) {
                case 'S': Y--; break;
                case 'N': Y++; break;
                case 'E': X++; break;
                case 'W': X--; break;
            }
            if (Math.abs(X) + Math.abs(Y) <= i + 1) {
                out.println(i + 1);
                return;
            }
        }
        out.println("IMPOSSIBLE");
    }

    static int[] arrTransform(int[] arr, int i, int j, int size) {
        int[] result = new int[size];
        System.arraycopy(arr, j + 1, result, j + 1, size - j - 1);
        System.arraycopy(arr, i + 1, result, 0, j - i);
        System.arraycopy(arr, 0, result, j - i, j + 1);
        return result;
    }

    static class Node {
        int[] arr;
        int size;
        BigInteger hash;
        int moves;
        StringBuilder solution;

        Node(int[] arr, int size, int moves) {
            this.arr = Arrays.copyOf(arr, size);
            this.size = size;
            this.moves = moves;
            this.hash = calcHash(this.arr, size);
            this.solution = new StringBuilder();
        }
    }

    static void printResult(Node n) {
        out.println(n.moves);
        out.println(n.solution);
    }

    static BigInteger calcHash(int[] arr, int size) {
        BigInteger hash = BigInteger.ZERO;
        for (int value : arr) {
            hash = hash.multiply(BigInteger.TEN).add(BigInteger.valueOf(value));
        }
        return hash;
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String str = reader.readLine();
                    if (str == null) return "";
                    tokenizer = new StringTokenizer(str);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}