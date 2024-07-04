import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= t; i++) {
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
                
                result.append(digit);
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}