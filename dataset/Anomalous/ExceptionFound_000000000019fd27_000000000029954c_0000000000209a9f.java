import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next() + scanner.nextLine();
            String[] digits = input.split("");
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;
            
            for (String digitStr : digits) {
                int currentDigit = Integer.parseInt(digitStr);
                
                if (currentDigit > previousDigit) {
                    for (int j = 0; j < currentDigit - previousDigit; j++) {
                        result.append("(");
                    }
                } else if (currentDigit < previousDigit) {
                    for (int j = 0; j < previousDigit - currentDigit; j++) {
                        result.append(")");
                    }
                }
                
                result.append(currentDigit);
                previousDigit = currentDigit;
            }
            
            for (int j = 0; j < previousDigit; j++) {
                result.append(")");
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
        
        scanner.close();
    }
}