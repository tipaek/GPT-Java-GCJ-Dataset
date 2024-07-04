import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int length = input.length();
            int balance = 0;
            
            for (int i = length - 1; i >= 0; i--) {
                int digit = Character.getNumericValue(input.charAt(i));
                
                while (balance < digit) {
                    result.insert(0, ')');
                    balance++;
                }
                
                while (balance > digit) {
                    result.insert(0, '(');
                    balance--;
                }
                
                result.insert(0, digit);
            }
            
            while (balance > 0) {
                result.insert(0, '(');
                balance--;
            }
            
            System.out.println("Case #" + testCase + " " + result);
        }
        
        scanner.close();
    }
}