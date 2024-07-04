import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Transpose tr = Transpose.getInstance();
        tr.start(new Transpose.Test() {
            @Override
            void onTest(int testCaseNumber, int totalCases) {
                int[] input = tr.nextIntArray();
                int N = input[0];
                int K = input[1];
                if (K % N != 0) {
                    tr.addCase(testCaseNumber, "IMPOSSIBLE");
                } else {
                    tr.addCase(testCaseNumber, "POSSIBLE");
                    int t = K / N;
                    for (int row = 0; row < N; row++) {
                        StringBuilder rowBuilder = new StringBuilder();
                        for (int col = 0; col < N; col++) {
                            int value = roundInt(col + t - row, N);
                            if (value == 0) value = N;
                            rowBuilder.append(value);
                            if (col != N - 1) rowBuilder.append(" ");
                        }
                        tr.addLine(rowBuilder.toString());
                    }
                }
            }
        });
        tr.flush();
    }

    public static int roundInt(int i, int N) {
        int x = i % N;
        return x < 1 ? N + x : x;
    }
}

class Transpose {
    private BufferedReader br;
    private StringBuilder queue;
    private int T = -1;
    private int TE = -1;

    private Transpose() {
        br = new BufferedReader(new InputStreamReader(System.in));
        queue = new StringBuilder();
    }

    public static Transpose getInstance() {
        return new Transpose();
    }

    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int nextInt() {
        return Integer.parseInt(nextLine());
    }

    public int[] nextIntArray() {
        String[] tokens = nextLine().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }
        return array;
    }

    public void start(Test test) {
        int[] testCases = nextIntArray();
        T = testCases[0];
        if (testCases.length > 1) {
            TE = testCases[1];
        }
        for (int i = 1; i <= T; i++) {
            test.onTest(i, T);
        }
    }

    public Transpose add(String s) {
        queue.append(s);
        return this;
    }

    public Transpose addCase(int i, String s) {
        return addLine("Case #" + i + ": " + s);
    }

    public Transpose addLine(String s) {
        return add(s + "\n");
    }

    public void flush() {
        if (queue.length() > 0) {
            System.out.print(queue.toString());
        }
        queue.setLength(0);
    }

    static abstract class Test {
        abstract void onTest(int i, int T);
    }
}