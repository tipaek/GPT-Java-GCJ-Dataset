import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int openParentheses = 0;
            String input = Integer.toString(scanner.nextInt());
            StringBuilder result = new StringBuilder();
            
            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                
                while (openParentheses < digit) {
                    result.append('(');
                    openParentheses++;
                }
                
                while (openParentheses > digit) {
                    result.append(')');
                    openParentheses--;
                }
                
                result.append(digit);
            }
            
            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}