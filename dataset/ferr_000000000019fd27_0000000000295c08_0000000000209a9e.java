import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    int ask(int id, int q) {
        System.out.println(id);
        System.out.flush();
        int got = nextInt();
        System.err.printf("ask(%d) == %d (%d)\n", id, got, q + 1);
        return got;
    }

    void reverse(int[] arr, int B) {
        for (int i = 1, j = B; i <= j; ++i, --j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    void inverse(int[] arr, int B) {
        for (int i = 1; i <= B; ++i) {
            if (arr[i] != -1) {
                arr[i] = 1 - arr[i];
            }
        }
    }

    public String solveCase(int B) {
        System.err.println("Started");
        int[] arr = new int[B + 1];
        Arrays.fill(arr, -1);
        int testSame = 1, testDiff = 1;
        out:for (int q = 0; q < 150;) {
            if (q > 0 && q % 10 == 0) {
                int sameValue = ask(testSame, q); q++;
                int diffValue = ask(testDiff, q); q++;
                boolean sameSame = sameValue == arr[testSame];
                boolean diffSame = diffValue == arr[testDiff];
                if (!sameSame && !diffSame) {
                    inverse(arr, B);
                } else if (sameSame && !diffSame) {
                    reverse(arr, B);
                } else if (!sameSame && diffSame) {
                    reverse(arr, B);
                    inverse(arr, B);
                }
                continue;
            }
            for (int p = 1; p <= B; ++p) {
                if (arr[p] == -1) {
                    arr[p] = ask(p, q); q++;
                    arr[B - p + 1] = ask(B - p + 1, q); q++;
                    if (arr[p] == arr[B - p + 1])
                        testSame = p;
                    else
                        testDiff = p;
                    continue out;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= B; ++i)
                sb.append(arr[i]);
            System.err.printf("Finished %s\n", sb.toString());
            return sb.toString();
        }
        throw new RuntimeException("123");
    }

    public void solve() {
        int t = nextInt();
        int B = nextInt();
        System.err.printf("T = %d, B = %d\n", t, B);
        for (int i = 0; i < t; ++i) {
            String ans = solveCase(B);
            pw.println(ans);
            pw.flush();
            String s = next();
            if (!s.equals("Y"))
                return;
        }
    }

    static final String filename = "A";
    static final boolean fromConsole = true;

    public void run() {
        try {
            if (!fromConsole) {
                in = new BufferedReader(new FileReader(filename + ".in"));
                pw = new PrintWriter(filename + ".out");
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            st = new StringTokenizer("");
            long st = System.currentTimeMillis();
            solve();
            //pw.printf("\nWorking time: %d ms\n", System.currentTimeMillis() - st);
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