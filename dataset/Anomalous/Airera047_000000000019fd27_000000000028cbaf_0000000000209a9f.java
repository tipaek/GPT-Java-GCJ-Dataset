import java.util.Scanner;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            String inputString = input.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            
            for (char ch : inputString.toCharArray()) {
                int targetDepth = Character.getNumericValue(ch);
                
                while (currentDepth < targetDepth) {
                    result.append('(');
                    currentDepth++;
                }
                
                while (currentDepth > targetDepth) {
                    result.append(')');
                    currentDepth--;
                }
                
                result.append(ch);
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
        
        input.close();
    }
}