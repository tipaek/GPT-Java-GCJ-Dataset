import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int openParens = 0;
            
            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                
                while (openParens < digit) {
                    output.append("(");
                    openParens++;
                }
                
                while (openParens > digit) {
                    output.append(")");
                    openParens--;
                }
                
                output.append(ch);
            }
            
            while (openParens > 0) {
                output.append(")");
                openParens--;
            }
            
            System.out.println("Case #" + i + ": " + output.toString());
        }
    }
}