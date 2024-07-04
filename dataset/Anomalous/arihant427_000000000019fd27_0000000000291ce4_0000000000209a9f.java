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

        for (int i = 0; i < inputs.size(); i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            List<Integer> digits = new ArrayList<>();

            for (char c : inputs.get(i).toCharArray()) {
                digits.add(Character.getNumericValue(c));
            }

            int openBrackets = 0;
            for (int j = 0; j < digits.size(); j++) {
                int currentDigit = digits.get(j);

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