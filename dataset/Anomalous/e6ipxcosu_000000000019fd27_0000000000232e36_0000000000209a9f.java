import java.util.Scanner;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';
                
                while (digit > currentDepth) {
                    output.append("(");
                    currentDepth++;
                }
                
                while (digit < currentDepth) {
                    output.append(")");
                    currentDepth--;
                }
                
                output.append(input.charAt(i));
            }
            
            while (currentDepth > 0) {
                output.append(")");
                currentDepth--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + output.toString());
        }
        
        scanner.close();
    }
}