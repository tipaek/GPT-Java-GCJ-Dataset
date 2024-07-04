import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static void solve() throws Exception {
        int n = scanInt();
        int sum = 0;
        int countVertical = 0;
        int countHorizontal = 0;

        Set<Integer>[] verticalSets = new HashSet[n];
        Boolean[] checkVertical = new Boolean[n];

        for (int i = 0; i < n; i++) {
            Set<Integer> horizontalSet = new HashSet<>(n);
            boolean checkHorizontal = true;

            for (int j = 0; j < n; j++) {
                int value = scanInt();
                if (i == j) {
                    sum += value;
                }
                if (checkHorizontal && !horizontalSet.add(value)) {
                    countHorizontal++;
                    checkHorizontal = false;
                }

                if (verticalSets[j] == null) {
                    verticalSets[j] = new HashSet<>(n);
                    checkVertical[j] = true;
                }

                if (checkVertical[j] && !verticalSets[j].add(value)) {
                    countVertical++;
                    checkVertical[j] = false;
                }
            }
        }

        String result = sum + " " + countHorizontal + " " + countVertical;
        printCase(result);
    }

    static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    static String scanString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static void printCase(String result) {
        out.println("Case #" + test + ": " + result);
    }

    static BufferedReader reader;
    static PrintWriter out;
    static StringTokenizer tokenizer;
    static int test;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int tests = scanInt();
            for (test = 1; test <= tests; test++) {
                solve();
            }
            reader.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}