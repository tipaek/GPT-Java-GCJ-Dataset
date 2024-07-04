import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        B = scanner.nextInt();
        try {
            for (int t = 1; t <= T; t++) {
                new Solution(scanner).solve();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    final String ZERO = "0", ONE = "1", Y = "Y";

    final Scanner scanner;

    static int B;
    final BitPair[] bps;

    int queryNr = 1;
    int testEqualIndex = 0;
    int testNotEqualIndex = 0;

    public Solution(Scanner scanner) {
        this.scanner = scanner;
        bps = new BitPair[B/2];
        IntStream.range(0, bps.length)
                .forEach(i -> bps[i] = new BitPair());
    }

    private void solve() {
        for(int i = 0; i < bps.length; i++) {
            if (queryNr % 10 == 1 && queryNr > 10) {
                adjustForFluctuations();
            }

            bps[i].first = query(i + 1);
            bps[i].second = query(B - i);
            if (bps[i].areEqual()) {
                testEqualIndex = i;
            } else {
                testNotEqualIndex = i;
            }
        }

        String firstStoredBits = IntStream.range(0, bps.length)
                .mapToObj(i -> bps[i].first)
                .collect(Collectors.joining());
        String secondStoredBits = IntStream.rangeClosed(1, bps.length)
                .mapToObj(i -> bps[bps.length - i].second)
                .collect(Collectors.joining());

        submit(firstStoredBits + secondStoredBits);
    }

    private void adjustForFluctuations() {
        String newFirst = query(testEqualIndex + 1);
        if (!bps[testEqualIndex].first.equals(newFirst)) {
            Stream.of(bps)
                    .filter(BitPair::areEqual)
                    .forEach(BitPair::flip);
        }

        newFirst = query(testNotEqualIndex + 1);
        if (!bps[testNotEqualIndex].first.equals(newFirst)) {
            Stream.of(bps)
                    .filter(BitPair::areNotEqual)
                    .forEach(BitPair::flip);
        }
    }

    private String query(int P) {
        System.out.println(P);
        String response = scanner.next();
        if (!response.equals(ZERO) && !response.equals(ONE)) {
            throw new RuntimeException(response + " response from Judge");
        }
        queryNr++;
        return response;
    }

    private void submit(String solution) {
        System.out.println(solution);
        String verdict = scanner.next();
        if (!verdict.equals(Y)) {
            throw new RuntimeException(verdict + " verdict from Judge");
        }
    }

    class BitPair {
        String first = ZERO, second = ZERO;

        boolean areEqual() {
            return first.equals(second);
        }

        boolean areNotEqual() {
            return !areEqual();
        }

        void flip() {
            first = (first.equals(ZERO)) ? ONE : ZERO;
            second = (second.equals(ZERO)) ? ONE : ZERO;
        }
    }

}
