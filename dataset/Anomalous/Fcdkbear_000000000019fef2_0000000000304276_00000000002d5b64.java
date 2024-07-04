import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    private static List<Integer> transform(List<Integer> list, int start, int length) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i < start + length; ++i) {
            result.add(list.get(i));
        }
        for (int i = 0; i < start; ++i) {
            result.add(list.get(i));
        }
        for (int i = start + length; i < list.size(); ++i) {
            result.add(list.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int rank = in.nextInt();
            int suit = in.nextInt();
            List<Integer> initialDeck = new ArrayList<>();
            for (int i = 0; i < suit; ++i) {
                for (int j = 1; j <= rank; ++j) {
                    initialDeck.add(j);
                }
            }
            List<Integer> targetDeck = new ArrayList<>();
            for (int j = 1; j <= rank; ++j) {
                for (int i = 0; i < suit; ++i) {
                    targetDeck.add(j);
                }
            }

            LinkedList<List<Integer>> queue = new LinkedList<>();
            queue.add(initialDeck);
            Map<List<Integer>, Integer> distance = new HashMap<>();
            Map<List<Integer>, Integer> moveA = new HashMap<>();
            Map<List<Integer>, Integer> moveB = new HashMap<>();
            Map<List<Integer>, List<Integer>> previous = new HashMap<>();
            distance.put(initialDeck, 0);

            while (!queue.isEmpty()) {
                List<Integer> currentDeck = queue.poll();
                if (currentDeck.equals(targetDeck)) {
                    break;
                }
                int currentDistance = distance.get(currentDeck);
                for (int a = 1; a < currentDeck.size(); ++a) {
                    for (int b = 1; a + b <= currentDeck.size(); ++b) {
                        List<Integer> nextDeck = transform(currentDeck, a, b);
                        if (!distance.containsKey(nextDeck)) {
                            distance.put(nextDeck, currentDistance + 1);
                            moveA.put(nextDeck, a);
                            moveB.put(nextDeck, b);
                            queue.add(nextDeck);
                            previous.put(nextDeck, currentDeck);
                        }
                    }
                }
            }

            int result = distance.get(targetDeck);
            out.printf("Case #%d: %d\n", testCase, result);
            List<Integer> movesA = new ArrayList<>();
            List<Integer> movesB = new ArrayList<>();
            while (!targetDeck.equals(initialDeck)) {
                movesA.add(moveA.get(targetDeck));
                movesB.add(moveB.get(targetDeck));
                targetDeck = previous.get(targetDeck);
            }
            Collections.reverse(movesA);
            Collections.reverse(movesB);
            for (int i = 0; i < movesA.size(); ++i) {
                out.printf("%d %d\n", movesA.get(i), movesB.get(i));
            }
            out.flush();
        }
        out.close();
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