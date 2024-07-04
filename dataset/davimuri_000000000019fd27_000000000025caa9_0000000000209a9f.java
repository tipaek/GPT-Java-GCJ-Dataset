
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        Solution nestingDepth = new Solution();
        for (int i = 1; i <= testCases; i++) {
            String input = in.next();
            String output = nestingDepth.nest(input);
            System.out.printf("Case #%d: %s%n", i, output);
        }
    }

    private String nest(String digits) {
        StringBuilder sb = new StringBuilder();
        int prevDigit = Integer.parseInt(String.valueOf(digits.charAt(0)), 10);
        append('(', prevDigit, sb);
        sb.append(prevDigit);
        for (int i = 1; i < digits.length(); i++) {
            int currentDigit = Integer.parseInt(String.valueOf(digits.charAt(i)), 10);
            int diff = currentDigit - prevDigit;
            if (diff > 0) {
                append('(', diff, sb);
            } else if (diff < 0) {
                append(')', -diff, sb);
            }
            sb.append(currentDigit);
            prevDigit = currentDigit;
        }
        append(')', prevDigit, sb);
        return sb.toString();
    }

    private void append(char type, int reps, StringBuilder sb) {
        for (int i = 1; i <= reps; i++) {
            sb.append(type);
        }
    }

}
