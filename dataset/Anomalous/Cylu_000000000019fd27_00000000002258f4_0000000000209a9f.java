import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private static final String FILENAME = "Input";
    private static final String IN = FILENAME + ".in";
    private static final String OUT = FILENAME + ".out";
    private final Scanner sc = new Scanner(System.in);
    private PrintStream out = System.out;

    private void solve() {
        StringBuilder result = new StringBuilder();
        String inputString = sc.nextLine();
        int depth = 0;

        for (char ch : inputString.toCharArray()) {
            int currentDepth = ch;
            if (currentDepth > depth) {
                for (int i = 0; i < currentDepth - depth; i++) {
                    result.append("(");
                }
                depth = currentDepth;
            } else if (currentDepth < depth) {
                for (int i = 0; i < depth - currentDepth; i++) {
                    result.append(")");
                }
                depth = currentDepth;
            }
            result.append(ch);
        }
        
        for (int i = 0; i < depth; i++) {
            result.append(")");
        }

        out.println(result);
    }

    private void run() throws Exception {
        // out = new PrintStream(new FileOutputStream(OUT));
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer input
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