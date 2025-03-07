import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            int previousDigit = Character.getNumericValue(input.charAt(0));
            for (int i = 0; i < previousDigit; i++) {
                result.append('(');
            }
            result.append(input.charAt(0));

            for (int i = 1; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                if (currentDigit < previousDigit) {
                    for (int j = 0; j < previousDigit - currentDigit; j++) {
                        result.append(')');
                    }
                } else if (currentDigit > previousDigit) {
                    for (int j = 0; j < currentDigit - previousDigit; j++) {
                        result.append('(');
                    }
                }
                result.append(input.charAt(i));
                previousDigit = currentDigit;
            }

            for (int i = 0; i < previousDigit; i++) {
                result.append(')');
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }

        scanner.close();
    }
}