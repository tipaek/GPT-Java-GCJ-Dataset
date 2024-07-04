import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int t = 0; t < testCases; t++) {
            String input = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = input.charAt(i) - '0';

                while (openBrackets < currentDigit) {
                    result.append('(');
                    openBrackets++;
                }

                while (openBrackets > currentDigit) {
                    result.append(')');
                    openBrackets--;
                }

                result.append(input.charAt(i));
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }

        sc.close();
    }
}