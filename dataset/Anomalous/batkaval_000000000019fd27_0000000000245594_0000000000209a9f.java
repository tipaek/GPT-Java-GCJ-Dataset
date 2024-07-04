import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();

            boolean isOpen = false;
            for (int index = 0; index < inputString.length(); index++) {
                int digit = Character.getNumericValue(inputString.charAt(index));

                if (digit == 0 && isOpen) {
                    result.append(")");
                    isOpen = false;
                }

                if (digit == 1 && !isOpen) {
                    result.append("(");
                    isOpen = true;
                }

                result.append(digit);
            }

            if (isOpen) {
                result.append(")");
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}