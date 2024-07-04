import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int totalCases = testCases;
        
        for (int i = 1; i <= totalCases; i++) {
            String input = scanner.next();
            System.out.println("Case #" + i + ": " + transformString(input));
        }
    }

    public static String transformString(String s) {
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (char c : s.toCharArray()) {
            int currentValue = Character.getNumericValue(c);

            while (openParentheses < currentValue) {
                result.append("(");
                openParentheses++;
            }

            while (openParentheses > currentValue) {
                result.append(")");
                openParentheses--;
            }

            result.append(c);
        }

        while (openParentheses > 0) {
            result.append(")");
            openParentheses--;
        }

        return result.toString();
    }
}