import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner;
    private final PrintStream out;

    public Solution(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public static void main(String[] args) {
        Solution nestingDepth = new Solution(System.in, System.out);
        nestingDepth.run();
    }

    public void run() {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            processTestCase(i, input);
        }
    }

    private void processTestCase(int testNum, String input) {
        String output = transformInput(input);
        out.println("Case #" + testNum + ": " + output);
    }

    private String transformInput(String input) {
        String[] replacements = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };

        for (int i = 1; i < replacements.length; i++) {
            input = input.replace(replacements[i], "(".repeat(i) + replacements[i] + ")".repeat(i));
        }

        while (input.contains(")(")) {
            input = input.replace(")(", "");
        }

        return input;
    }
}