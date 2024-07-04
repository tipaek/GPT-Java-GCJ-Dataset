import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        new Solution().execute();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private String getNextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private int getNextInt() throws IOException {
        return Integer.parseInt(getNextToken());
    }

    private void solve() throws IOException {
        int n = getNextInt();
        boolean[][] schedule = new boolean[24 * 60 + 1][2];
        StringBuilder result = new StringBuilder();
        boolean conflict = false;

        for (int i = 0; i < n; i++) {
            int start = getNextInt();
            int end = getNextInt();
            boolean[] occupied = new boolean[2];

            for (int j = start; j < end; j++) {
                for (int k = 0; k < 2; k++) {
                    occupied[k] |= schedule[j][k];
                }
            }

            if (occupied[0] && occupied[1]) {
                conflict = true;
            }

            int assign = occupied[0] ? 1 : 0;
            result.append(occupied[0] ? "C" : "J");

            for (int j = start; j < end; j++) {
                schedule[j][assign] = true;
            }
        }

        if (conflict) {
            writer.println("IMPOSSIBLE");
        } else {
            writer.println(result.toString());
        }
    }

    private void execute() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);

            int testCases = getNextInt();
            for (int i = 0; i < testCases; i++) {
                writer.printf("Case #%d: ", i + 1);
                solve();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}