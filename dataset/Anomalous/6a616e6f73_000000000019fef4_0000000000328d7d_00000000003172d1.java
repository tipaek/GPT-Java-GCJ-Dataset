import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        // scanner = example();
        // scanner = bigTest();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            Input input = Input.fromScanner(scanner);
            printCase(t, solve(input));
        }
    }

    private static Scanner example() throws FileNotFoundException {
        return new Scanner("4\n" +
                "1 3\n" +
                "1\n" +
                "2 3\n" +
                "3 2\n" +
                "1 2\n" +
                "1\n" +
                "5 2\n" +
                "10 5 359999999999 123456789 10\n" +
                "5 3\n" +
                "10 5 359999999999 123456789 10\n" +
                "3 2\n" +
                "1 2 3");
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
                // TODO
            }
        }

        return new Scanner(sb.toString());
    }

    private static class Input {
        private final int D;
        private final List<Long> slices;

        private Input(int D, List<Long> slices) {
            this.D = D;
            this.slices = slices;
        }

        public static Input fromScanner(Scanner scanner) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();

            List<Long> slices = new ArrayList<>();
            IntStream.range(0, N).forEach(i -> slices.add(scanner.nextLong()));
            return new Input(D, slices);
        }
    }

    private static void printCase(int t, String s) {
        System.out.printf("Case #%d: %s%n", t + 1, s);
    }

    private static String solve(Input input) {
        Map<Long, Integer> freqs = new HashMap<>();
        input.slices.forEach(slice -> freqs.merge(slice, 1, Integer::sum));

        Set<Integer> fs = new HashSet<>(freqs.values());

        if (fs.contains(input.D)) return "0";
        if (input.D == 2) return "1";

        Set<Long> uSlices = new HashSet<>(input.slices);
        for (long a : uSlices) {
            if (uSlices.contains(2 * a)) return "1";
        }

        return "2";
    }
}