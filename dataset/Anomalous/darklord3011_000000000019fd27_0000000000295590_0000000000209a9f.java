import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (openBrackets < digit) {
                    result.append("(");
                    openBrackets++;
                }

                while (openBrackets > digit) {
                    result.append(")");
                    openBrackets--;
                }

                result.append(ch);
            }

            while (openBrackets > 0) {
                result.append(")");
                openBrackets--;
            }

            System.out.println(result.toString());
        }

        scanner.close();
    }
}