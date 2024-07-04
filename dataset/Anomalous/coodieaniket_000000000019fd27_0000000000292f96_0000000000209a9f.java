import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            ArrayList<Character> result = new ArrayList<>();
            int previousValue = 0;

            for (char character : input.toCharArray()) {
                int currentValue = Character.getNumericValue(character);

                if (currentValue > previousValue) {
                    for (int i = 0; i < currentValue - previousValue; i++) {
                        result.add('(');
                    }
                } else if (currentValue < previousValue) {
                    for (int i = 0; i < previousValue - currentValue; i++) {
                        result.add(')');
                    }
                }

                result.add(character);
                previousValue = currentValue;
            }

            for (int i = 0; i < previousValue; i++) {
                result.add(')');
            }

            System.out.print("Case #" + caseNumber + ": ");
            for (Character ch : result) {
                System.out.print(ch);
            }
            System.out.println();
        }

        scanner.close();
    }
}