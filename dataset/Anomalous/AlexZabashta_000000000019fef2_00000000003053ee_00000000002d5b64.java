import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution {

    static class JavaArray {
        private final int[] array;
        private final int hashCode;

        public JavaArray(int[] array) {
            this.array = array;
            this.hashCode = Arrays.hashCode(array);
        }

        @Override
        public int hashCode() {
            return hashCode;
        }

        @Override
        public String toString() {
            return Arrays.toString(array);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            JavaArray other = (JavaArray) obj;
            return hashCode == other.hashCode && Arrays.equals(array, other.array);
        }
    }

    static class Move implements Comparable<Move> {
        private final int len;
        private final JavaArray from;
        private final String string;

        public Move(int len, JavaArray from, String string) {
            this.len = len;
            this.from = from;
            this.string = string;
        }

        @Override
        public int compareTo(Move p) {
            return Integer.compare(len, p.len);
        }

        @Override
        public String toString() {
            return len + " " + from + " " + string;
        }
    }

    private List<String> solve(int r, int s) {
        int n = r * s;
        Map<JavaArray, Move> map = new HashMap<>(1_000_000);
        Queue<JavaArray> queue = new ArrayDeque<>(1_000_000);

        int[] initialArray = new int[n];
        for (int i = 0; i < n; i++) {
            initialArray[i] = i / s;
        }
        JavaArray initialJavaArray = new JavaArray(initialArray);
        map.put(initialJavaArray, new Move(0, null, ""));
        queue.add(initialJavaArray);

        while (!queue.isEmpty()) {
            JavaArray from = queue.poll();
            int len = map.get(from).len + 1;
            int[] array = from.array;

            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    if (a + b > n) continue;

                    int[] copy = array.clone();
                    System.arraycopy(array, 0, copy, b, a);
                    System.arraycopy(array, a, copy, 0, b);

                    JavaArray to = new JavaArray(copy);
                    if (map.containsKey(to)) continue;

                    map.put(to, new Move(len, from, b + " " + a));
                    queue.add(to);
                }
            }
        }

        int[] finalArray = new int[n];
        for (int i = 0; i < n; i++) {
            finalArray[i] = i % r;
        }
        JavaArray current = new JavaArray(finalArray);

        List<String> result = new ArrayList<>();
        while (true) {
            Move move = map.get(current);
            String moveString = move.string;
            if (moveString.isEmpty()) break;
            result.add(moveString);
            current = move.from;
        }

        return result;
    }

    private void run(Interactor interactor) {
        int tests = interactor.nextInt();
        for (int test = 1; test <= tests; test++) {
            int r = interactor.nextInt();
            int s = interactor.nextInt();
            List<String> ans = solve(r, s);
            interactor.printf(Locale.ENGLISH, "Case #%d: %d%n", test, ans.size());
            for (String line : ans) {
                interactor.println(line);
            }
        }
    }

    static class Interactor extends PrintWriter {
        private final BufferedReader reader;
        private StringTokenizer tokenizer = new StringTokenizer("");

        public Interactor(InputStream inputStream, OutputStream outputStream) {
            super(outputStream);
            this.reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        @Override
        public void close() {
            super.close();
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) return false;
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }

        String next() {
            while (!tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(nextLine());
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (Interactor interactor = new Interactor(System.in, System.out)) {
            new Solution().run(interactor);
        }
    }
}