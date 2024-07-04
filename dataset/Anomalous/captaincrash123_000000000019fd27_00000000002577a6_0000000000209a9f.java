import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            StringBuffer input = new StringBuffer(scanner.next());
            boolean hasDigits = true;
            
            for (int digit = 1; hasDigits && digit < 10; digit++) {
                int digitCount = 0;
                
                for (int i = 0; i < input.length(); i++) {
                    char currentChar = input.charAt(i);
                    
                    if (currentChar == ')' || currentChar == '(') {
                        continue;
                    }
                    
                    if (Integer.parseInt(String.valueOf(currentChar)) == digit) {
                        input.insert(i, '(');
                        digitCount++;
                        boolean parenthesesClosed = false;
                        
                        for (int j = i + 1; j < input.length() && !parenthesesClosed; j++) {
                            char nextChar = input.charAt(j);
                            
                            if (nextChar == ')') {
                                input.insert(j, ')');
                                parenthesesClosed = true;
                                i = j + 1;
                            } else if (nextChar == '(') {
                                continue;
                            } else if (Integer.parseInt(String.valueOf(nextChar)) < digit) {
                                input.insert(j, ')');
                                parenthesesClosed = true;
                                i = j + 1;
                            } else if (j == input.length() - 1) {
                                input.insert(j + 1, ')');
                                parenthesesClosed = true;
                                i = j;
                            }
                        }
                    }
                }
                
                if (digitCount == 0) {
                    hasDigits = false;
                }
            }
            
            System.out.printf("Case #%d: %s%n", t + 1, input.toString());
        }
        
        scanner.close();
    }
}