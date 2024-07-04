import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= t; i++) {
            String s = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int j = 0; j < s.length(); j++) {
                int currentDigit = s.charAt(j) - '0';

                // Add necessary opening brackets
                while (openBrackets < currentDigit) {
                    result.append('(');
                    openBrackets++;
                }

                // Add necessary closing brackets
                while (openBrackets > currentDigit) {
                    result.append(')');
                    openBrackets--;
                }

                result.append(currentDigit);
            }

            // Close any remaining open brackets
            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }

        sc.close();
    }
}