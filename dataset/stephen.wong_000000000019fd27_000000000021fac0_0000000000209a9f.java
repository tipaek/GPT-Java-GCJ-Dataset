
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem2 {
    private final int id;
    private final String input;
    String output;

    public Problem2(int id, String input) {
        this.id = id;
        this.input = input;
    }

    @Override
    public String toString() {
        return "Case #" + id + ": " + output;
    }

    void solve() {
        char[] chars = input.toCharArray();
        int[] digits = IntStream.range(0, chars.length)
            .map(index -> chars[index] - 48)
            .toArray();

        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (int digit : digits) {
            if (digit > prev) {
                sb.append(String.valueOf('(').repeat(Math.max(0, digit - prev)));
            } else if (digit < prev) {
                sb.append(String.valueOf(')').repeat(Math.max(0, prev - digit)));
            }
            sb.append(digit);
            prev = digit;
        }
        sb.append(String.valueOf(')').repeat(Math.max(0, prev)));
        output = sb.toString();
    }

    static void processInput(InputStream inputStream) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        int tests = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            String input = in.nextLine();
            Problem2 problem2 = new Problem2(testNumber, input);
            problem2.solve();

            System.out.println(problem2);
        }
    }

    public static void main(String[] args) {
        processInput(System.in);
    }
}
