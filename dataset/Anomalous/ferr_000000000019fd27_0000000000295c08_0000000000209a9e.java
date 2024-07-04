import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    int ask(int id, int q) {
        System.out.println(id);
        System.out.flush();
        int response = nextInt();
        System.err.printf("ask(%d) == %d (%d)\n", id, response, q + 1);
        return response;
    }

    void reverse(int[] array, int B) {
        for (int i = 1, j = B; i <= j; ++i, --j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    void inverse(int[] array, int B) {
        for (int i = 1; i <= B; ++i) {
            if (array[i] != -1) {
                array[i] = 1 - array[i];
            }
        }
    }

    public String solveCase(int B) {
        System.err.println("Started");
        int[] array = new int[B + 1];
        Arrays.fill(array, -1);
        int testSame = 1, testDiff = 1;

        for (int q = 0; q < 150;) {
            if (q > 0 && q % 10 == 0) {
                int sameValue = ask(testSame, q); q++;
                int diffValue = ask(testDiff, q); q++;
                boolean sameSame = sameValue == array[testSame];
                boolean diffSame = diffValue == array[testDiff];

                if (!sameSame && !diffSame) {
                    inverse(array, B);
                } else if (sameSame && !diffSame) {
                    reverse(array, B);
                } else if (!sameSame && diffSame) {
                    reverse(array, B);
                    inverse(array, B);
                }
                continue;
            }

            for (int p = 1; p <= B; ++p) {
                if (array[p] == -1) {
                    array[p] = ask(p, q); q++;
                    array[B - p + 1] = ask(B - p + 1, q); q++;
                    if (array[p] == array[B - p + 1]) {
                        testSame = p;
                    } else {
                        testDiff = p;
                    }
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= B; ++i) {
                result.append(array[i]);
            }
            System.err.printf("Finished %s\n", result.toString());
            return result.toString();
        }
        throw new RuntimeException("Failed to solve case");
    }

    public void solve() {
        int t = nextInt();
        int B = nextInt();
        System.err.printf("T = %d, B = %d\n", t, B);
        for (int i = 0; i < t; ++i) {
            String answer = solveCase(B);
            pw.println(answer);
            pw.flush();
            if (!next().equals("Y")) {
                return;
            }
        }
    }

    static final String filename = "A";
    static final boolean fromConsole = true;

    public void run() {
        try {
            if (!fromConsole) {
                in = new BufferedReader(new FileReader(filename + ".in"));
                pw = new PrintWriter(new FileWriter(filename + ".out"));
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            st = new StringTokenizer("");
            long startTime = System.currentTimeMillis();
            solve();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private StringTokenizer st;
    private BufferedReader in;
    private PrintWriter pw;

    boolean hasNext() {
        try {
            while (!st.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null) {
                    return false;
                }
                st = new StringTokenizer(line);
            }
            return st.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String next() {
        return hasNext() ? st.nextToken() : null;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
}