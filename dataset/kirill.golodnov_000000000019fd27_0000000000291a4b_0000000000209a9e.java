import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Solution {

    private static final int REVERSE = 0;
    private static final int REVERSE_SWAP = 1;
    private static final int NOTHING = 2;
    private static final int SWAP = 3;

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, UTF_8), 1 << 15);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out, UTF_8), 1 << 15)) {
            StringTokenizer tokens = new StringTokenizer(in.readLine());
            int tests = parseInt(tokens.nextToken());
            int b = parseInt(tokens.nextToken());
            for (int t = 0; t < tests; t++) {
                if (b == 10) {
                    int[] a = new int[b];
                    readArray(1, b, a, in, out);
                    fixArrayByTwoQueries(1, 5, a, in, out);
                    writeArray(a, in, out);
                } else if (b == 20) {
                    int[] a = new int[b];
                    readArray(1, 5, a, in, out);
                    readArray(16, 20, a, in, out);
                    readArray(6, 10, a, in, out);
                    readArray(11, 15, a, in, out);
                    fixArrayByTwoQueries(6, 5, a, in, out);
                    fixArrayByTwoQueries(1, 5, a, in, out);
                    writeArray(a, in, out);
                } else if (b == 100) {
                    int[] a = new int[b];
                    for (int i = 0; i < 10; i++) {
                        readArray(5 * i + 1, 5 * i + 5, a, in, out);
                        readArray(95 - 5 * i + 1, 95 - 5 * i + 5, a, in, out);
                    }
                    fixArrayByTwoQueries(46, 5, a, in, out);
                    fixArrayByTwoQueries(41, 5, a, in, out);
                    fixArrayByTwoQueries(36, 5, a, in, out);
                    fixArrayByTwoQueries(31, 5, a, in, out);
                    fixArrayByTwoQueries(26, 5, a, in, out);

                    fixArrayByTwoQueries(1, 5, a, in, out);
                    fixArrayByTwoQueries(6, 5, a, in, out);
                    fixArrayByTwoQueries(11, 5, a, in, out);
                    fixArrayByTwoQueries(16, 5, a, in, out);
                    fixArrayByTwoQueries(21, 5, a, in, out);

                    fixArrayByTwoQueries(26, 25, a, in, out);
                    fixArrayByTwoQueries(1, 25, a, in, out);

                    writeArray(a, in, out);
                }
            }
        } catch (IOException e) {
            System.exit(1);
        }
    }

    private static void readArray(int from, int to, int[] a, BufferedReader in, BufferedWriter out) throws IOException {
        for (int i = from; i <= to; i++) {
            out.write(i + "");
            out.newLine();
            out.flush();
            a[i - 1] = parseInt(in.readLine());
        }
    }

    private static void fixArrayByTwoQueries(int from, int size, int[] a, BufferedReader in, BufferedWriter out) throws IOException {
        from--;
        int twoDifferentBits = -1;
        int twoEqualBits = -1;
        for (int i = 0; i < size; i++) {
            if (a[from + i] != a[a.length - 1 - from - i]) {
                twoDifferentBits = from + i;
                break;
            }
        }
        for (int i = 0; i < size; i++) {
            if (a[from + i] == a[a.length - 1 - from - i]) {
                twoEqualBits = from + i;
                break;
            }
        }
        Boolean twoDifferentBitsValueChanged = null;
        Boolean twoEqualBitsValueChanged = null;
        if (twoDifferentBits != -1) {
            twoDifferentBitsValueChanged = readValue(twoDifferentBits, in, out) != a[twoDifferentBits];
        } else {
            readValue(from, in, out);
        }
        if (twoEqualBits != -1) {
            twoEqualBitsValueChanged = readValue(twoEqualBits, in, out) != a[twoEqualBits];
        } else {
            readValue(from, in, out);
        }
        int state = -1;
        if (twoDifferentBitsValueChanged != null && twoEqualBitsValueChanged != null) {
            if (twoDifferentBitsValueChanged && twoEqualBitsValueChanged) {
                state = REVERSE;
            } else if (twoDifferentBitsValueChanged && !twoEqualBitsValueChanged) {
                state = SWAP;
            } else if (!twoDifferentBitsValueChanged && twoEqualBitsValueChanged) {
                state = REVERSE_SWAP;
            } else if (!twoDifferentBitsValueChanged && !twoEqualBitsValueChanged) {
                state = NOTHING;
            }
        } else if (twoDifferentBitsValueChanged != null) {
            state = twoDifferentBitsValueChanged ? REVERSE : NOTHING;
        } else if (twoEqualBitsValueChanged != null) {
            state = twoEqualBitsValueChanged ? REVERSE : NOTHING;
        }
        for (int i = 0; i < size; i++) {
            if (state == SWAP) {
                int x = a[from + i];
                a[from + i] = a[a.length - 1 - from - i];
                a[a.length - 1 - from - i] = x;
            } else if (state == REVERSE) {
                a[from + i] = a[from + i] == 1 ? 0 : 1;
                a[a.length - 1 - from - i] = a[a.length - 1 - from - i] == 1 ? 0 : 1;
            } else if (state == REVERSE_SWAP) {
                a[from + i] = a[from + i] == 1 ? 0 : 1;
                a[a.length - 1 - from - i] = a[a.length - 1 - from - i] == 1 ? 0 : 1;
                int x = a[from + i];
                a[from + i] = a[a.length - 1 - from - i];
                a[a.length - 1 - from - i] = x;
            }
        }
    }

    private static int readValue(int posInArray, BufferedReader in, BufferedWriter out) throws IOException {
        out.write((posInArray + 1) + "");
        out.newLine();
        out.flush();
        return parseInt(in.readLine());
    }

    private static void writeArray(int[] a, BufferedReader in, BufferedWriter out) throws IOException {
        for (int value : a) {
            out.write(value + "");
        }
        out.newLine();
        out.flush();
        String answer = in.readLine();
        if (!answer.equals("Y")) {
            System.exit(1);
        }
    }
}
