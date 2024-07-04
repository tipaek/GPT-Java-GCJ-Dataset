import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String sequence = scanner.next();
            int[] digits = sequence.chars().map(Character::getNumericValue).toArray();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;
            
            for (int digit : digits) {
                while (currentDepth < digit) {
                    output.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    output.append(')');
                    currentDepth--;
                }
                output.append(digit);
            }
            
            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + output);
        }
        
        scanner.close();
    }
}