import java.util.Scanner;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int i = 0; i < n + 1; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            char firstChar = input.charAt(0);
            
            if (firstChar == '1') {
                result.append("(1");
            } else {
                result.append('0');
            }
            
            int length = input.length();
            for (int k = 1; k < length; k++) {
                char currentChar = input.charAt(k);
                char previousChar = input.charAt(k - 1);
                
                if (currentChar == '0') {
                    if (previousChar == '1') {
                        result.append(")0");
                    } else {
                        result.append('0');
                    }
                } else if (currentChar == '1') {
                    if (previousChar == '0') {
                        result.append("(1");
                    } else {
                        result.append('1');
                    }
                }
            }
            
            if (input.charAt(length - 1) == '1') {
                result.append(")");
            }
            
            System.out.println(result.toString());
        }
        
        scanner.close();
    }
}