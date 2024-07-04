import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);
    private static final String FILENAME = "Input";
    private static final String IN = FILENAME + ".in";
    private static final String OUT = FILENAME + ".out";
    private final PrintStream out = System.out;

    private void solve() {
        StringBuilder result = new StringBuilder();
        String inputString = scanner.nextLine();
        int depth = 0;

        for (char character : inputString.toCharArray()) {
            int number = Character.getNumericValue(character);
            if (number > depth) {
                result.append("(".repeat(number - depth));
                depth = number;
            } else if (number < depth) {
                result.append(")".repeat(depth - number));
                depth = number;
            }
            result.append(character);
        }
        result.append(")".repeat(depth));
        out.println(result.toString());
    }

    private void run() throws Exception {
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= testCases; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        scanner.close();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}