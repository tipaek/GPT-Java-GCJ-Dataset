import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;
            int previousDigit = 0;

            for (char ch : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);

                if (currentDigit > previousDigit) {
                    for (int j = 0; j < currentDigit - previousDigit; j++) {
                        result.append('(');
                        openBrackets++;
                    }
                } else if (currentDigit < previousDigit) {
                    for (int j = 0; j < previousDigit - currentDigit; j++) {
                        result.append(')');
                        openBrackets--;
                    }
                }

                result.append(ch);
                previousDigit = currentDigit;
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}