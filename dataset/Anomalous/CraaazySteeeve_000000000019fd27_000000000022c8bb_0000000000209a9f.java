import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = Character.getNumericValue(input.charAt(i));
                while (openBrackets < digit) {
                    result.append('(');
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    result.append(')');
                    openBrackets--;
                }
                result.append(input.charAt(i));
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}