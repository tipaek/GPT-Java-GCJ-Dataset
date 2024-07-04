import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ": ");
            int currentDepth = 0;
            String input = scanner.next();
            
            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                
                if (digit > currentDepth) {
                    for (int i = 0; i < digit - currentDepth; i++) {
                        System.out.print("(");
                    }
                } else if (digit < currentDepth) {
                    for (int i = 0; i < currentDepth - digit; i++) {
                        System.out.print(")");
                    }
                }
                
                System.out.print(digit);
                currentDepth = digit;
            }
            
            while (currentDepth > 0) {
                System.out.print(")");
                currentDepth--;
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
}