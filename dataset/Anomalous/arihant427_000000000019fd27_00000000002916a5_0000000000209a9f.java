import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.next());
        List<String> inputs = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            inputs.add(scanner.next());
        }

        for (String input : inputs) {
            List<Integer> digits = new ArrayList<>();
            for (char c : input.toCharArray()) {
                digits.add(Character.getNumericValue(c));
            }

            int openBrackets = 0;
            for (int i = 0; i < digits.size(); i++) {
                int currentDigit = digits.get(i);

                while (openBrackets < currentDigit) {
                    System.out.print("(");
                    openBrackets++;
                }

                while (openBrackets > currentDigit) {
                    System.out.print(")");
                    openBrackets--;
                }

                System.out.print(currentDigit);
            }

            while (openBrackets > 0) {
                System.out.print(")");
                openBrackets--;
            }

            System.out.println();
        }

        scanner.close();
    }
}