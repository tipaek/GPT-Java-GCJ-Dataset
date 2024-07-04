import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Solution implements Runnable {

    private PrintStream out;
    private BufferedReader in;
    private StringTokenizer st;

    public void solve() throws IOException {
        long startTime = System.currentTimeMillis();

        int testCases = nextInt();
        int bits = nextInt();
        for (int test = 1; test <= testCases; test++) {
            boolean[] answer = solveCase(bits);
            out.println(decode(answer));
            out.flush();
            String outcome = next();
            if (!outcome.equals("Y")) {
                break;
            }
        }

        System.err.println("Execution time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private String decode(boolean[] answer) {
        StringBuilder result = new StringBuilder();
        for (boolean bit : answer) {
            result.append(bit ? "1" : "0");
        }
        return result.toString();
    }

    private boolean[] solveCase(int n) throws IOException {
        boolean[] bitsArray = new boolean[n];
        int bitsPerInteraction = 4;
        for (int i = 0; i <= n - 1 - i; i += bitsPerInteraction) {
            for (int j = 0; j < bitsPerInteraction && i + j <= n - 1 - (i + j); j++) {
                bitsArray[i + j] = interact(i + j);
                bitsArray[n - 1 - (i + j)] = interact(n - 1 - (i + j));
            }
            int sameIndex = -1;
            int diffIndex = -1;
            for (int j = 0; j < i; j++) {
                if (bitsArray[j] == bitsArray[n - 1 - j]) {
                    sameIndex = j;
                } else {
                    diffIndex = j;
                }
            }
            if (sameIndex == -1) {
                interact(0);
            } else {
                boolean sameBit = interact(sameIndex);
                if (sameBit != bitsArray[sameIndex]) {
                    invertArray(n, bitsArray, i);
                }
            }
            if (diffIndex == -1) {
                interact(0);
            } else {
                boolean diffBit = interact(diffIndex);
                if (diffBit != bitsArray[diffIndex]) {
                    rotateArray(n, bitsArray, i);
                }
            }
        }
        return bitsArray;
    }

    private void invertArray(int n, boolean[] array, int limit) {
        for (int i = 0; i < limit; i++) {
            array[i] = !array[i];
            array[n - 1 - i] = !array[n - 1 - i];
        }
    }

    private void rotateArray(int n, boolean[] array, int limit) {
        for (int i = 0; i < limit; i++) {
            boolean temp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }
    }

    private boolean interact(int index) throws IOException {
        out.println(index + 1);
        out.flush();
        int result = nextInt();
        return result == 1;
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
    }

    public Solution(String filename) throws IOException {
        Locale.setDefault(Locale.US);
        if (filename == null) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintStream(new BufferedOutputStream(System.out));
        } else {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(filename + ".in")));
            out = new PrintStream(new BufferedOutputStream(new FileOutputStream(filename + ".out")));
        }
        st = new StringTokenizer("");
    }

    public static void main(String[] args) throws IOException {
        new Thread(new Solution(null)).start();
    }
}