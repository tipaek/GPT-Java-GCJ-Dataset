import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            System.out.println("Case #" + caseNumber + ": " + calculateNestingDepth(inputString));
        }
    }

    private static String calculateNestingDepth(String inputString) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;
        
        for (int i = 0; i < inputString.length(); i++) {
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
        
        return result.toString();
    }
}