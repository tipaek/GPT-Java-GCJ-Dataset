import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int depth = 0;
            
            for (char ch : input.toCharArray()) {
                int num = Character.getNumericValue(ch);
                
                while (depth < num) {
                    result.append('(');
                    depth++;
                }
                
                while (depth > num) {
                    result.append(')');
                    depth--;
                }
                
                result.append(ch);
            }
            
            while (depth > 0) {
                result.append(')');
                depth--;
            }
            
            System.out.println("Case #" + i + ": " + result);
        }
        
        scanner.close();
    }
}