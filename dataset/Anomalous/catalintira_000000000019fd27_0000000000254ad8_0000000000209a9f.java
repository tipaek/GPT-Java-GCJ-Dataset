import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();

        for (int testIndex = 1; testIndex <= numberOfTests; ++testIndex) {
            System.out.print("Case #" + testIndex + ": ");
            String number = scanner.next();
            int currentParensCount = 0;

            for (int i = 0; i < number.length(); ++i) {
                int digit = Character.getNumericValue(number.charAt(i));
                int parensDifference = digit - currentParensCount;
                boolean needToOpenParens = parensDifference > 0;

                currentParensCount += parensDifference;
                String parensCharacter = needToOpenParens ? "(" : ")";
                if (!needToOpenParens) {
                    parensDifference *= -1;
                }

                for (int j = 0; j < parensDifference; ++j) {
                    System.out.print(parensCharacter);
                }

                System.out.print(digit);
            }

            for (int i = 0; i < currentParensCount; ++i) {
                System.out.print(")");
            }
            System.out.println();
        }
    }
}