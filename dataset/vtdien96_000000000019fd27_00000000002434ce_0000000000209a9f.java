
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTest = Integer.parseInt(input.nextLine());
        for (int caseIndex = 0; caseIndex < numOfTest; caseIndex++) {
            String numberSequence = input.nextLine();
            solve(caseIndex + 1, numberSequence);
        }
    }

    private static void solve(int caseIndex, String inputStr) {
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        String[] numberSequence = inputStr.split("");
        for (String numberStr : numberSequence) {
            int integer = Integer.parseInt(numberStr);
            int tmp = integer - pre;
            if (tmp > 0) {
                sb.append(repeat("(", tmp));
            } else if (tmp < 0) {
                sb.append(repeat(")", -tmp));
            }
            sb.append(integer);
            pre = integer;
        }

        sb.append(repeat(")", pre));
        System.out.println(String.format("Case #%s: %s", caseIndex, sb.toString()));
    }

    private static String repeat(String s, int pre) {
        StringBuilder result = new StringBuilder();
        while (pre > 0) {
            result.append(s);
            pre--;
        }
        return result.toString();
    }
}