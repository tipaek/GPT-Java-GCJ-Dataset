import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder(input);
            int offset = 0;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '1') {
                    result.insert(i + offset, "(");
                    offset++;
                    
                    for (int j = i + 1; j < input.length(); j++) {
                        if (input.charAt(j) == '0') {
                            result.insert(j + offset, ")");
                            offset++;
                            break;
                        }
                        
                        if (j == input.length() - 1) {
                            result.append(")");
                            offset++;
                            i = input.length();
                        }
                    }
                }
            }
            
            if (result.charAt(result.length() - 1) == '1') {
                result.append(")");
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }
}