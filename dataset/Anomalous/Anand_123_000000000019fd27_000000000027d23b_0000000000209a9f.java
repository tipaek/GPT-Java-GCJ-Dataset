import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.next();
            int length = input.length();
            StringBuilder result = new StringBuilder();
            int previousValue = 0;
            
            for (int index = 0; index < length; index++) {
                int currentValue = Character.getNumericValue(input.charAt(index));
                
                if (currentValue > previousValue) {
                    for (int k = 0; k < (currentValue - previousValue); k++) {
                        result.append("(");
                    }
                } else if (currentValue < previousValue) {
                    for (int k = 0; k < (previousValue - currentValue); k++) {
                        result.append(")");
                    }
                }
                
                previousValue = currentValue;
                result.append(input.charAt(index));
            }
            
            for (int j = 0; j < previousValue; j++) {
                result.append(")");
            }
            
            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
        
        scanner.close();
    }
}