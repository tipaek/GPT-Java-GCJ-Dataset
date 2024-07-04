import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        
        new Solver().solve(in, out);
        out.close();
    }
}

class Solver {
    private static final int N_MAX = 1000;
    private final int[] startTimes = new int[N_MAX];
    private final int[] finishTimes = new int[N_MAX];
    private final char[] assignments = new char[N_MAX];
    private final Integer[] order = new Integer[N_MAX];

    public void solve(InputReader in, PrintWriter out) {
        int testCases = in.readInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = in.readInt();
            for (int i = 0; i < n; i++) {
                startTimes[i] = in.readInt();
                finishTimes[i] = in.readInt();
                assignments[i] = 'U';
                order[i] = i;
            }

            Arrays.sort(order, 0, n, Comparator.comparingInt(i -> startTimes[i]));
            int cEnd = 0, jEnd = 0;
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                int idx = order[i];
                if (cEnd <= startTimes[idx]) {
                    assignments[idx] = 'C';
                    cEnd = finishTimes[idx];
                } else if (jEnd <= startTimes[idx]) {
                    assignments[idx] = 'J';
                    jEnd = finishTimes[idx];
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                out.printf("Case #%d: IMPOSSIBLE%n", caseNum);
            } else {
                StringBuilder result = new StringBuilder(n);
                for (int i = 0; i < n; i++) {
                    result.append(assignments[i]);
                }
                out.printf("Case #%d: %s%n", caseNum, result.toString());
            }
        }
    }
}

class InputReader {
    private final BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String read() {
        try {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tokenizer.nextToken();
    }

    public int readInt() {
        return Integer.parseInt(read());
    }

    public long readLong() {
        return Long.parseLong(read());
    }

    public void readIntArrays(int[]... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                arrays[j][i] = readInt();
            }
        }
    }

    public void readMatrix(int rows, int columns, int[]... arrays) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arrays[i][j] = readInt();
            }
        }
    }
}