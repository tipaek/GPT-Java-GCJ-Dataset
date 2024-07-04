import java.util.*;
import java.io.*;

public class Solution {
    private static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int tests = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < tests; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        char[] digits = input.toCharArray();
        StringBuffer outputDraft = new StringBuffer();
        int openedBrackets = 0;
        for (char digit : digits) {
            int num = digit - '0';
            if (num < openedBrackets) openedBrackets -= closeBrackets(openedBrackets - num, outputDraft);
            else if (num > openedBrackets) openedBrackets += openBrackets(num - openedBrackets, outputDraft);
            outputDraft.append(digit);
        }
        closeBrackets(openedBrackets, outputDraft);
        System.out.println(outputDraft.toString());
    }

    private static int closeBrackets(int value, StringBuffer output) {
        for (int i = 0; i < value; i++) output.append(')');
        return value;
    }

    private static int openBrackets(int value, StringBuffer output) {
        for (int i = 0; i < value; i++) output.append('(');
        return value;
    }
}
