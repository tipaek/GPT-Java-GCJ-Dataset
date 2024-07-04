import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousValue = 0;

            for (char ch : input.toCharArray()) {
                int currentValue = Character.getNumericValue(ch);

                while (previousValue < currentValue) {
                    result.append('(');
                    previousValue++;
                }

                while (previousValue > currentValue) {
                    result.append(')');
                    previousValue--;
                }

                result.append(ch);
            }

            while (previousValue > 0) {
                result.append(')');
                previousValue--;
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}