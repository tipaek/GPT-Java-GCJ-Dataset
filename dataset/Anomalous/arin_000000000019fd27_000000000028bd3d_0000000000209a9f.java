import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            String inputString = scanner.next();
            StringBuilder resultBuilder = new StringBuilder();
            int currentNesting = 0;
            
            for (int index = 0; index < inputString.length(); index++) {
                char currentChar = inputString.charAt(index);
                int digit = Character.getNumericValue(currentChar);
                
                if (digit > currentNesting) {
                    for (int j = 0; j < digit - currentNesting; j++) {
                        resultBuilder.append('(');
                    }
                    currentNesting = digit;
                } else if (digit < currentNesting) {
                    for (int j = 0; j < currentNesting - digit; j++) {
                        resultBuilder.append(')');
                    }
                    currentNesting = digit;
                }
                
                resultBuilder.append(currentChar);
            }
            
            while (currentNesting > 0) {
                resultBuilder.append(')');
                currentNesting--;
            }
            
            System.out.println("Case #" + i + ": " + resultBuilder.toString());
        }
        
        scanner.close();
    }
}