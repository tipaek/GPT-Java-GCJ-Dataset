import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Transpose tr = Transpose.getInstance();
        tr.start(new Transpose.Test() {
            @Override
            void onTest(int i, int T) {
                int[] ix = tr.nextIntArray();
                int N = ix[0];
                int K = ix[1];
                if (K % N != 0) {
                    tr.addCase(i, "IMPOSSIBLE");
                } else {
                    tr.addCase(i, "POSSIBLE");
                    int t = K / N;
                    for (int j = 0; j < N; j++) {
                        StringBuilder rowBuilder = new StringBuilder();
                        for (int k = 0; k < N; k++) {
                            int value = roundInt(k + t - j, N);
                            if (value == 0) value = N;
                            rowBuilder.append(value);
                            if (k != N - 1) rowBuilder.append(" ");
                        }
                        tr.addLine(rowBuilder.toString());
                    }
                }
            }
        });
        tr.flush();
    }

    public static int roundInt(int i, int N) {
        return i % N;
    }
}

class Transpose {
    private BufferedReader br;
    private StringBuilder queue = new StringBuilder();
    private int T = -1;
    private int TE = -1;

    private Transpose() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static Transpose getInstance() {
        return new Transpose();
    }

    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int nextInt() {
        return Integer.parseInt(nextLine());
    }

    public String[] nextStringArray() {
        try {
            return br.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{};
    }

    public int[] nextIntArray() {
        String[] ss = nextStringArray();
        int[] sx = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            sx[i] = Integer.parseInt(ss[i]);
        }
        return sx;
    }

    public void start(Test t) {
        int[] ts = nextIntArray();
        T = ts[0];
        if (ts.length > 1) {
            TE = ts[1];
        }
        for (int i = 1; i <= T; i++) {
            t.onTest(i, T);
        }
    }

    public Transpose add(String s) {
        queue.append(s);
        return this;
    }

    public Transpose addCase(int i, String s) {
        addLine("Case #" + i + ": " + s);
        return this;
    }

    public Transpose addLine(String s) {
        return add(s + "\n");
    }

    public void flush() {
        if (queue.length() > 0) {
            System.out.print(queue);
        }
        queue.setLength(0);
    }

    static abstract class Test {
        abstract void onTest(int i, int T);
    }
}