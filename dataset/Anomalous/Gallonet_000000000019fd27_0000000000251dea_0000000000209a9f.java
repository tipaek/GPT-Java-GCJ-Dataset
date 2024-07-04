import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String inputString = scanner.nextLine() + "0";
            char[] characters = inputString.toCharArray();
            StringBuilder finalString = new StringBuilder();
            int currentDepth = 0;
            
            for (char ch : characters) {
                int digit = Character.getNumericValue(ch);
                StringBuilder parentheses = new StringBuilder();
                
                while (currentDepth != digit) {
                    if (currentDepth < digit) {
                        parentheses.append("(");
                        currentDepth++;
                    } else {
                        parentheses.append(")");
                        currentDepth--;
                    }
                }
                finalString.append(parentheses).append(digit);
            }
            
            System.out.println("Case #" + testCase + ": " + finalString.substring(0, finalString.length() - 1));
        }
        
        scanner.close();
    }
}