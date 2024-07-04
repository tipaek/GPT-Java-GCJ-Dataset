import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            boolean isBinary = input.chars().allMatch(ch -> ch == '0' || ch == '1');
            
            StringBuilder output = new StringBuilder();
            StringBuilder onesSequence = new StringBuilder();
            
            if (isBinary) {
                for (int index = 0; index < input.length(); index++) {
                    char currentChar = input.charAt(index);
                    
                    if (currentChar == '0') {
                        if (onesSequence.length() > 0) {
                            output.append(onesSequence).append(')');
                            onesSequence.setLength(0);
                        }
                        output.append('0');
                    } else {
                        if (onesSequence.length() == 0) {
                            output.append('(');
                        }
                        onesSequence.append('1');
                        
                        if (index == input.length() - 1) {
                            output.append(onesSequence).append(')');
                        }
                    }
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + output.toString());
        }
    }
}