import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.nextLine();
            char[] characters = inputString.toCharArray();

            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (char character : characters) {
                int numericValue = Character.getNumericValue(character);

                while (openParentheses != numericValue) {
                    if (openParentheses < numericValue) {
                        result.append("(");
                        openParentheses++;
                    } else {
                        result.append(")");
                        openParentheses--;
                    }
                }
                result.append(character);
            }

            while (openParentheses > 0) {
                result.append(")");
                openParentheses--;
            }

            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}