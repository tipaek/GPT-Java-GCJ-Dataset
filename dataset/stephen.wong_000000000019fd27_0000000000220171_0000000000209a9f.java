
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    private final int id;
    private final String input;
    String output;

    public Solution(int id, String input) {
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
                repeat(sb, digit - prev, '(');
            } else if (digit < prev) {
                repeat(sb, prev - digit, ')');
            }
            sb.append(digit);
            prev = digit;
        }
        repeat(sb, prev, ')');
        output = sb.toString();
    }

    private static void repeat(StringBuilder sb, int n, char c) {
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
    }

    static void processInput(InputStream inputStream) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        int tests = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            String input = in.nextLine();
            Solution solution = new Solution(testNumber, input);
            solution.solve();

            System.out.println(solution);
        }
    }

    public static void main(String[] args) {
        processInput(System.in);
    }
}
