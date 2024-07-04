import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int testCaseCount = sc.nextInt();
        sc.nextLine();

        for (int t = 0; t < testCaseCount; t++) {
            System.out.println("Case #" + (t + 1) + ": " + parenthesize(sc.nextLine()));
        }
    }

    private static String parenthesize(String s) {
        StringBuilder sb = new StringBuilder();
        int priorDigit = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentDigit = Character.getNumericValue(s.charAt(i));
            int diff = currentDigit - priorDigit;

            String parenthesis = "";
            if (diff > 0) {
                parenthesis = "(";
            } else if (diff < 0) {
                parenthesis = ")";
            }

            for (int j = 0; j < Math.abs(diff); j++) {
                sb.append(parenthesis);
            }
            sb.append(currentDigit);
            priorDigit = currentDigit;
        }

        for (int j = 0; j < priorDigit; j++) {
            sb.append(")");
        }

        return sb.toString();
    }
}
