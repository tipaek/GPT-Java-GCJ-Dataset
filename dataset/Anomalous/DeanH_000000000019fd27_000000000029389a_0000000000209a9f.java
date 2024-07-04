import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputNumber = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (char ch : inputNumber.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);

                while (previousDigit < currentDigit) {
                    result.append('(');
                    previousDigit++;
                }
                while (previousDigit > currentDigit) {
                    result.append(')');
                    previousDigit--;
                }

                result.append(currentDigit);
            }

            while (previousDigit > 0) {
                result.append(')');
                previousDigit--;
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}