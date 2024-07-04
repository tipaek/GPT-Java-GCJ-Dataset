import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int testCases = in.nextInt();
        int b = in.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            List<Integer> samePositions = new ArrayList<>();
            List<Integer> differentPositions = new ArrayList<>();
            int queryCount = 1;
            int position = 0;
            int[] result = new int[b];

            while (position < b / 2) {
                if (queryCount % 10 == 1 && queryCount != 1) {
                    if (!samePositions.isEmpty()) {
                        handleQuery(in, out, samePositions.get(0) + 1, result, samePositions, b);
                        queryCount++;
                    }
                    if (!differentPositions.isEmpty()) {
                        handleQuery(in, out, differentPositions.get(0) + 1, result, differentPositions, b);
                        queryCount++;
                    }
                } else if (queryCount % 10 == 0) {
                    out.println(1);
                    out.flush();
                    in.nextInt();
                    queryCount++;
                } else {
                    handlePosition(in, out, position, result, samePositions, differentPositions, b);
                    queryCount += 2;
                    position++;
                }
            }

            for (int i = 0; i < b; ++i) {
                out.print(result[i]);
            }
            out.println();
            out.flush();
            in.next();
        }
        out.close();
    }

    private static void handleQuery(InputReader in, PrintWriter out, int position, int[] result, List<Integer> positions, int b) {
        out.println(position);
        out.flush();
        int value = in.nextInt();
        if (value != result[positions.get(0)]) {
            for (Integer idx : positions) {
                result[idx] ^= 1;
                result[b - idx - 1] ^= 1;
            }
        }
    }

    private static void handlePosition(InputReader in, PrintWriter out, int position, int[] result, List<Integer> samePositions, List<Integer> differentPositions, int b) {
        out.println(position + 1);
        out.flush();
        result[position] = in.nextInt();
        out.println(b - position);
        out.flush();
        result[b - position - 1] = in.nextInt();
        if (result[position] == result[b - position - 1]) {
            samePositions.add(position);
        } else {
            differentPositions.add(position);
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}