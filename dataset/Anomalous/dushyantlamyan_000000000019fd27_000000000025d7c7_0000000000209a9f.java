import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            boolean isBinary = input.chars().allMatch(c -> c == '0' || c == '1');
            
            StringBuilder output = new StringBuilder();
            StringBuilder onesBuffer = new StringBuilder();
            
            if (isBinary) {
                for (int j = 0; j < input.length(); j++) {
                    char currentChar = input.charAt(j);
                    if (currentChar == '0') {
                        if (onesBuffer.length() != 0) {
                            output.append(onesBuffer).append(')');
                            onesBuffer.setLength(0);
                        }
                        output.append('0');
                    } else {
                        if (onesBuffer.length() == 0) {
                            output.append('(');
                        }
                        onesBuffer.append('1');
                        if (j == input.length() - 1) {
                            output.append(onesBuffer).append(')');
                        }
                    }
                }
            } else {
                String startBrackets = "((((((((((";
                String endBrackets = "))))))))))";
                int previousNumber = 0;
                
                for (int j = 0; j < input.length(); j++) {
                    int currentNumber = Character.getNumericValue(input.charAt(j));
                    
                    if (j == 0) {
                        onesBuffer.append(startBrackets, 0, currentNumber)
                                  .append(input.charAt(j))
                                  .append(endBrackets, 0, Math.abs(previousNumber - currentNumber));
                    } else {
                        onesBuffer.append(startBrackets, 0, Math.abs(previousNumber - currentNumber))
                                  .append(input.charAt(j))
                                  .append(endBrackets, 0, Math.abs(previousNumber - currentNumber));
                    }
                    
                    previousNumber = currentNumber;
                }
                
                output.append(onesBuffer);
            }
            
            System.out.println("Case #" + caseNumber + ": " + output.toString());
        }
    }
}