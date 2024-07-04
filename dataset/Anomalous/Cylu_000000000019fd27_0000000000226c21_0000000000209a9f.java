import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private Scanner sc = new Scanner(System.in);
    private static final String FILENAME = "Input";
    private static final String IN = FILENAME + ".in";
    private static final String OUT = FILENAME + ".out";
    private PrintStream out = System.out;

    private void solve() {
        StringBuilder result = new StringBuilder();
        String inputString = sc.nextLine();
        int currentDepth = 0;

        for (char character : inputString.toCharArray()) {
            int numericValue = Character.getNumericValue(character);
            if (numericValue > currentDepth) {
                result.append("(".repeat(numericValue - currentDepth));
                currentDepth = numericValue;
            } else if (numericValue < currentDepth) {
                result.append(")".repeat(currentDepth - numericValue));
                currentDepth = numericValue;
            }
            result.append(character);
        }

        result.append(")".repeat(currentDepth));
        out.println(result.toString());
    }

    private void run() throws Exception {
        // out = new PrintStream(new FileOutputStream(OUT));
        int testCases = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= testCases; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }

        sc.close();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}