import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        
        for (int k = 1; k <= testCases; k++) {
            String input = sc.next();
            StringBuilder result = new StringBuilder();
            boolean openBracket = false;
            
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                
                if (currentChar == '1' && !openBracket) {
                    result.append('(').append(currentChar);
                    openBracket = true;
                } else if (currentChar == '0' && openBracket) {
                    result.append(')').append(currentChar);
                    openBracket = false;
                } else {
                    result.append(currentChar);
                }
            }
            
            if (openBracket) {
                result.append(')');
            }
            
            System.out.println("Case #" + k + ": " + result.toString());
        }
        
        sc.close();
    }
}