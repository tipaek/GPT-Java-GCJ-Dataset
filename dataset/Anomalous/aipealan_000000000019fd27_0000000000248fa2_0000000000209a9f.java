import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int openBrackets = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                while (openBrackets < digit) {
                    output.append('(');
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    output.append(')');
                    openBrackets--;
                }
                output.append(digit);
            }

            while (openBrackets > 0) {
                output.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + i + ": " + output.toString());
        }
    }
}