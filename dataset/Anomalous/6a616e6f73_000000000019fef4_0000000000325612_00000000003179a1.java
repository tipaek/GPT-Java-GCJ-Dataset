import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        // Uncomment to use example or bigTest methods
        // scanner = example();
        // scanner = bigTest();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            Input input = Input.fromScanner(scanner);
            printCase(t, solve(input));
        }
    }

    private static Scanner example() throws FileNotFoundException {
        return new Scanner(new File("/tmp/sample.in.txt"));
    }

    private static Scanner bigTest() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int T = 100;
        int A = 255;
        int maxLength = 500;

        sb.append(T).append('\n');
        for (int t = 0; t < T; t++) {
            sb.append(A).append('\n');
            for (int i = 0; i < A; i++) {
                int length = 1 + random.nextInt(maxLength);
                // TODO: Generate random string of length
            }
        }

        return new Scanner(sb.toString());
    }

    private static class Input {
        private final int U;
        private final Map<Long, List<String>> queries;

        public Input(int U, Map<Long, List<String>> queries) {
            this.U = U;
            this.queries = queries;
        }

        public static Input fromScanner(Scanner scanner) {
            int U = scanner.nextInt();
            Map<Long, List<String>> q = new HashMap<>();
            IntStream.range(0, 10000).forEach(i -> {
                long m = scanner.nextLong();
                String r = scanner.next();
                q.computeIfAbsent(m, k -> new ArrayList<>()).add(r);
            });
            return new Input(U, q);
        }
    }

    private static void printCase(int t, String s) {
        System.out.printf("Case #%d: %s%n", t + 1, s);
    }

    private static String solve(Input input) {
        Map<Character, Integer> freqs = new HashMap<>();
        input.queries.values().stream()
                .flatMap(Collection::stream)
                .map(r -> r.charAt(0))
                .forEach(c -> freqs.merge(c, 1, Integer::sum));

        char[] D = new char[10];
        List<Character> sorted = freqs.keySet().stream()
                .sorted(Comparator.comparingInt(freqs::get).reversed())
                .collect(Collectors.toList());

        for (int i = 0; i < sorted.size(); i++) {
            D[i + 1] = sorted.get(i);
        }
        D[0] = '?';
        input.queries.values().stream()
                .flatMap(Collection::stream)
                .flatMapToInt(String::chars)
                .mapToObj(i -> (char) i)
                .filter(c -> !freqs.containsKey(c))
                .findAny()
                .ifPresent(c -> D[0] = c);

        return new String(D);
    }
}