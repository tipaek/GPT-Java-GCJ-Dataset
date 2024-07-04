import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            processTestCase(scanner, caseNumber);
        }
    }

    private static void processTestCase(Scanner scanner, int caseNumber) {
        System.out.print("Case #" + caseNumber + ": ");
        String input = scanner.next();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            while (currentDepth < digit) {
                System.out.print("(");
                currentDepth++;
            }
            while (currentDepth > digit) {
                System.out.print(")");
                currentDepth--;
            }
            System.out.print(digit);
        }
        
        while (currentDepth > 0) {
            System.out.print(")");
            currentDepth--;
        }
        
        System.out.println();
    }
}