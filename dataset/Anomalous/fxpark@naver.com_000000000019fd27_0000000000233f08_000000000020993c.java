import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer tokenizer;

    private String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private void solve() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(nextToken());
        for (int i = 0; i < testCases; i++) {
            String result = processCase();
            writer.println(String.format("Case #%d: %s", i + 1, result));
        }
        reader.close();
        writer.close();
    }

    private String processCase() throws IOException {
        int n = Integer.parseInt(nextToken());
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;
        int[][] colCheck = new int[n][n];

        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[n];
            boolean rowHasRepeat = false;
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(nextToken());

                if (i == j) {
                    trace += value;
                }

                if (!rowCheck[value - 1]) {
                    rowCheck[value - 1] = true;
                } else {
                    rowHasRepeat = true;
                }

                colCheck[j][value - 1]++;
            }
            if (rowHasRepeat) {
                rowRepeats++;
            }
        }

        for (int j = 0; j < n; j++) {
            for (int val = 0; val < n; val++) {
                if (colCheck[j][val] > 1) {
                    colRepeats++;
                    break;
                }
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }
}