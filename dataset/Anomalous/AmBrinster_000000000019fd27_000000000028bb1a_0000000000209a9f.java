import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            System.out.print("Case #" + caseNumber + ": ");
            processAndPrint(input);
            System.out.println();
        }
    }

    private static void processAndPrint(String input) {
        int currentDepth = 0;
        StringBuilder result = new StringBuilder();
        
        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            while (currentDepth < digit) {
                result.append("(");
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(")");
                currentDepth--;
            }
            result.append(digit);
        }
        
        while (currentDepth > 0) {
            result.append(")");
            currentDepth--;
        }
        
        System.out.print(result.toString());
    }
}