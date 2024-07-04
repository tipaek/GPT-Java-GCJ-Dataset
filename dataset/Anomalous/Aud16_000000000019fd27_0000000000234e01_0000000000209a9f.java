/*
	ID: audreylee16
	LANG: JAVA
	TASK: default
*/
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String result = "";
            String[] inputDigits = scanner.nextLine().split("");
            
            for (String digitStr : inputDigits) {
                int digit = Integer.parseInt(digitStr);
                
                if (digit == 0) {
                    result += "0";
                } else {
                    String toAppend = Integer.toString(digit);
                    String tempResult = result;
                    
                    for (int i = 0; i < digit; i++) {
                        if (result.length() > (i + 1) && result.substring(result.length() - i - 1, result.length() - i).equals(")")) {
                            tempResult = result.substring(0, result.length() - i - 1);
                            toAppend += ")";
                        } else {
                            toAppend = "(" + toAppend + ")";
                        }
                    }
                    result = tempResult + toAppend;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}