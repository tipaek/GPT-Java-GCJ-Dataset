import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = scanner.next();
            String extendedInput = "0" + input + "0";
            StringBuilder result = new StringBuilder();
            int length = extendedInput.length();

            for (int i = 1; i < length; i++) {
                int currentDigit = extendedInput.charAt(i) - '0';
                int previousDigit = extendedInput.charAt(i - 1) - '0';

                if (currentDigit > previousDigit) {
                    for (int j = 0; j < currentDigit - previousDigit; j++) {
                        result.append("(");
                    }
                } else if (currentDigit < previousDigit) {
                    for (int j = 0; j < previousDigit - currentDigit; j++) {
                        result.append(")");
                    }
                }
                
                if (i < length - 1) {
                    result.append(extendedInput.charAt(i));
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }

        scanner.close();
    }
}