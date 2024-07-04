import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int caseNumber = testCases;

        while (testCases > 0) {
            String inputString = scanner.next();
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < inputString.length(); ++i) {
                int digit = inputString.charAt(i) - '0';

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(inputString.charAt(i));
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + (caseNumber - testCases + 1) + ": " + result);
            testCases--;
        }
    }
}