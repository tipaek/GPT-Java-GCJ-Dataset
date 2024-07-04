import java.util.Scanner;

public class NestingDepth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(sc.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String input = sc.nextLine();
            StringBuilder resultBuilder = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';

                while (currentDepth < digit) {
                    resultBuilder.append('(');
                    currentDepth++;
                }

                while (currentDepth > digit) {
                    resultBuilder.append(')');
                    currentDepth--;
                }

                resultBuilder.append(digit);
            }

            while (currentDepth > 0) {
                resultBuilder.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + caseNumber + ": " + resultBuilder.toString());
        }
    }
}