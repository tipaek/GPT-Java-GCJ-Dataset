import java.util.Scanner;

public class Solution {
    private static Scanner sc;
    private static int caseNumber = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int currentNumber = Character.getNumericValue(chars[0]);
        int openBrackets = currentNumber;

        // Append opening brackets for the first character
        for (int i = 0; i < currentNumber; i++) {
            sb.append('(');
        }
        sb.append(currentNumber);

        // Process the rest of the characters
        for (int i = 1; i < chars.length; i++) {
            int nextNumber = Character.getNumericValue(chars[i]);
            if (nextNumber > currentNumber) {
                for (int j = 0; j < nextNumber - currentNumber; j++) {
                    sb.append('(');
                    openBrackets++;
                }
            } else if (nextNumber < currentNumber) {
                for (int j = 0; j < currentNumber - nextNumber; j++) {
                    sb.append(')');
                    openBrackets--;
                }
            }
            sb.append(nextNumber);
            currentNumber = nextNumber;
        }

        // Close any remaining open brackets
        while (openBrackets-- > 0) {
            sb.append(')');
        }

        System.out.println("Case #" + (caseNumber++) + ": " + sb.toString());
    }
}