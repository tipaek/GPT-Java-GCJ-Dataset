import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            int balance = 0;
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < inputString.length(); i++) {
                int currentDigit = inputString.charAt(i) - '0';
                
                while (balance > currentDigit) {
                    result.append(")");
                    balance--;
                }
                
                while (balance < currentDigit) {
                    result.append("(");
                    balance++;
                }
                
                result.append(currentDigit);
                balance = currentDigit;
            }
            
            while (balance > 0) {
                result.append(")");
                balance--;
            }
            
            System.out.println(result.toString());
        }
    }
}