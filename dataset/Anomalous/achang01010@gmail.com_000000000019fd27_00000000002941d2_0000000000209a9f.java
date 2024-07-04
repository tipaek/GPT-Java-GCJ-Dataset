import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            
            for (char digit : input.toCharArray()) {
                int value = Character.getNumericValue(digit);
                
                for (int i = 0; i < value; i++) {
                    result.append('(');
                }
                
                result.append(digit);
                
                for (int i = 0; i < value; i++) {
                    result.append(')');
                }
            }
            
            String output = result.toString();
            while (output.contains(")(")) {
                output = output.replace(")(", "");
            }
            
            System.out.println("Case #" + (t + 1) + ": " + output);
        }
        
        scanner.close();
    }
}