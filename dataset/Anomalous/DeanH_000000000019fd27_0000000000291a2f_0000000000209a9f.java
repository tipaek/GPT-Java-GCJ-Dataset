import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String numberString = scanner.next();
            int length = numberString.length();
            int openBrackets = 0;
            StringBuilder result = new StringBuilder();
            
            for (int index = 0; index < length; index++) {
                int digit = numberString.charAt(index) - '0';
                
                if (digit > openBrackets) {
                    for (int i = 0; i < digit - openBrackets; i++) {
                        result.append('(');
                    }
                } else if (digit < openBrackets) {
                    for (int i = 0; i < openBrackets - digit; i++) {
                        result.append(')');
                    }
                }
                
                result.append(numberString.charAt(index));
                openBrackets = digit;
            }
            
            for (int i = 0; i < openBrackets; i++) {
                result.append(')');
            }
            
            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }
}