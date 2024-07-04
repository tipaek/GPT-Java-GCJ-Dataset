
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= tests; ++i) {
            String expr = createExpr(scanner.nextLine());
            System.out.println("Case #" + i + ": " + expr);
        }
    }

    private static String createExpr(String line) {
        char[] chars = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        int lastNum = chars[0] - '0';
        append(sb, '(', lastNum);
        for (int i = 0; i <= chars.length; ) {
            if (i == chars.length) {
                append(sb, ')', lastNum);
                break;
            }
            int currentNum = chars[i] - '0';
            if (lastNum == currentNum) {
                sb.append(currentNum);
                ++i;
            } else if (lastNum < currentNum) {
                append(sb, '(', currentNum - lastNum);
                lastNum = currentNum;
            } else {
                append(sb, ')', lastNum - currentNum);
                lastNum = currentNum;
            }
        }
        return sb.toString();
    }

    private static void append(StringBuilder sb, char c, int times) {
        for (int i = 0; i < times; ++i) {
            sb.append(c);
        }
    }
}
