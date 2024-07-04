import java.util.Scanner;

class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';
                int depthChange = digit - currentDepth;
                
                while (depthChange > 0) {
                    result.append('(');
                    depthChange--;
                }
                while (depthChange < 0) {
                    result.append(')');
                    depthChange++;
                }
                
                result.append(digit);
                currentDepth = digit;
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
        
        scanner.close();
    }
}