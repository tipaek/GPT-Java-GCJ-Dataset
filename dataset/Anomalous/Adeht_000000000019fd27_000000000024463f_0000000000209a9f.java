import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();

        for (int testCaseIndex = 1; testCaseIndex <= testCaseCount; testCaseIndex++) {
            String input = sc.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (char ch : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);
                int difference = currentDigit - previousDigit;

                if (difference > 0) {
                    result.append("(".repeat(difference));
                } else if (difference < 0) {
                    result.append(")".repeat(-difference));
                }

                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            result.append(")".repeat(previousDigit));

            System.out.println("Case #" + testCaseIndex + ": " + result.toString());
        }

        sc.close();
    }
}