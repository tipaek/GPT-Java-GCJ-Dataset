import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        
        StringBuilder output = new StringBuilder();
        
        for (int c = 0; c < numCases; c++) {
            String unNest = sc.next();
            StringBuilder nested = new StringBuilder();
            
            int currentDepth = 0;
            
            for (char ch : unNest.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                
                while (currentDepth < digit) {
                    nested.append("(");
                    currentDepth++;
                }
                
                while (currentDepth > digit) {
                    nested.append(")");
                    currentDepth--;
                }
                
                nested.append(digit);
            }
            
            while (currentDepth > 0) {
                nested.append(")");
                currentDepth--;
            }
            
            output.append("Case #").append(c + 1).append(": ").append(nested).append("\n");
        }
        
        System.out.print(output);
    }
}