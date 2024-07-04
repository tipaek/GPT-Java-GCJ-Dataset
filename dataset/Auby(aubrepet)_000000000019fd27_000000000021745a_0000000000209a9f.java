import java.util.Scanner;

/**
 *
 * @author peta
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    Scanner in;

    public void run() {
        in = new Scanner(System.in);
        int tests = in.nextInt();
        in.nextLine();
        for (int i = 0; i < tests; i++) {
            String result = solveTestcase();
            System.out.println("Test #" + (i + 1) + ": " + result);
        }

    }

    private String solveTestcase() {
        String line = in.nextLine();
        char[] sepLine = line.toCharArray();
        int deapth = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : sepLine) {
            while (deapth < (c - '0')) {
                sb.append("(");
                deapth++;
            }
            while (deapth > (c - '0')) {
                sb.append(")");
                deapth--;
            }
            sb.append(c);
        }
        while (deapth > 0) {
            sb.append(")");
            deapth--;
        }

        return sb.toString();
    }
}
