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
        int currentLevel = 0;
        StringBuilder result = new StringBuilder();
        String[] digits = input.split("");
        
        for (String digitStr : digits) {
            int digit = Integer.parseInt(digitStr);
            
            while (currentLevel < digit) {
                result.append("(");
                currentLevel++;
            }
            
            while (currentLevel > digit) {
                result.append(")");
                currentLevel--;
            }
            
            result.append(digit);
        }
        
        while (currentLevel > 0) {
            result.append(")");
            currentLevel--;
        }
        
        System.out.print(result.toString());
    }
}