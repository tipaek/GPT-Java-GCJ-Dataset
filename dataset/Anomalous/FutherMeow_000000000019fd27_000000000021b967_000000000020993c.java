import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static final int LIM = 1000000;

    static void solve() throws Exception {
        int n = scanInt();
        int sum = 0;
        int countVertical = 0;
        int countHorizontal = 0;

        HashSet<Integer>[] verticalSets = new HashSet[n];
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
            tokenizer = new StringTokenizer(in.readLine());
        }
        return tokenizer.nextToken();
    }

    static void printCase(String result) {
        out.println("Case #" + testCaseNumber + ": " + result);
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tokenizer;
    static int testCaseNumber;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int numberOfTests = scanInt();
            for (testCaseNumber = 1; testCaseNumber <= numberOfTests; testCaseNumber++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}