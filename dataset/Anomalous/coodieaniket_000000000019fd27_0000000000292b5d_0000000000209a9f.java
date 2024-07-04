import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            ArrayList<Character> result = new ArrayList<>();
            int previousValue = 0;

            for (char currentChar : inputString.toCharArray()) {
                int currentValue = Character.getNumericValue(currentChar);

                if (currentValue > previousValue) {
                    for (int i = 0; i < currentValue - previousValue; i++) {
                        result.add('(');
                    }
                } else {
                    for (int i = 0; i < previousValue - currentValue; i++) {
                        result.add(')');
                    }
                }

                result.add(currentChar);
                previousValue = currentValue;
            }

            for (int i = 0; i < previousValue; i++) {
                result.add(')');
            }

            System.out.print("Case #" + caseNumber + ": ");
            for (char character : result) {
                System.out.print(character);
            }
            System.out.println();
        }

        scanner.close();
    }
}