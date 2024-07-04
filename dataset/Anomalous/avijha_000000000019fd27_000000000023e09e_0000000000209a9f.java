import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int test = 1; test <= testCases; test++) {
            String input = scanner.next();
            int openBrackets = 0;
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < input.length(); i++) {
                int digit = Character.getNumericValue(input.charAt(i));
                
                while (openBrackets < digit) {
                    result.append("(");
                    openBrackets++;
                }
                
                while (openBrackets > digit) {
                    result.append(")");
                    openBrackets--;
                }
                
                result.append(digit);
            }
            
            while (openBrackets > 0) {
                result.append(")");
                openBrackets--;
            }
            
            System.out.println("Case #" + test + ": " + result.toString());
        }
        
        scanner.close();
    }
}