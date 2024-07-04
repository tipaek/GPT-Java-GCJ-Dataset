import java.io.*;
import java.util.*;

public class Solution {

    private static String result = "";
    private static int openCount = 0;

    private static void addOpenBrackets(int count) {
        openCount += count;
        result += "(".repeat(count);
    }

    private static void addCloseBrackets(int count) {
        openCount -= count;
        result += ")".repeat(count);
    }

    private static String balanceBrackets(String digits) {
        result = "";
        openCount = 0;

        int length = digits.length();
        for (int i = 0; i < length; i++) {
            int currentNum = digits.charAt(i) - '0';
            int diff = currentNum - openCount;
            if (diff > 0) {
                addOpenBrackets(diff);
            } else if (diff < 0) {
                addCloseBrackets(-diff);
            }
            result += digits.charAt(i);
        }
        addCloseBrackets(openCount);

        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            String balancedResult = balanceBrackets(input);
            System.out.println("Case #" + i + ": " + balancedResult);
        }
    }
}