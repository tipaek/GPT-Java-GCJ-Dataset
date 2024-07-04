import java.util.Scanner;

public class Solution {
    private static Scanner sc = new Scanner(System.in);
    private static int caseNumber = 1;

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String s = sc.nextLine();
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        int currentNum = Character.getNumericValue(chars[0]);
        int openBrackets = currentNum;

        appendBrackets(result, '(', currentNum);
        result.append(currentNum);

        for (int i = 1; i < chars.length; i++) {
            int nextNum = Character.getNumericValue(chars[i]);
            if (nextNum > currentNum) {
                appendBrackets(result, '(', nextNum - currentNum);
                openBrackets += nextNum - currentNum;
            } else if (nextNum < currentNum) {
                appendBrackets(result, ')', currentNum - nextNum);
                openBrackets -= currentNum - nextNum;
            }
            result.append(nextNum);
            currentNum = nextNum;
        }

        appendBrackets(result, ')', openBrackets);
        System.out.println("Case #" + (caseNumber++) + ": " + result.toString());
    }

    private static void appendBrackets(StringBuilder sb, char bracket, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(bracket);
        }
    }
}