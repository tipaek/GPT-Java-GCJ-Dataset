import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        
        for (int testCase = 1; testCase <= t; testCase++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;
            
            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                
                while (openBrackets < digit) {
                    result.append('(');
                    openBrackets++;
                }
                
                while (openBrackets > digit) {
                    result.append(')');
                    openBrackets--;
                }
                
                result.append(ch);
            }
            
            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
        
        scanner.close();
    }
}