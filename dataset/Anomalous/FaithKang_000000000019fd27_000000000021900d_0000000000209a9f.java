import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                char previousChar = i > 0 ? input.charAt(i - 1) : ' ';
                
                if ((i == 0 && currentChar == '1') || (i > 0 && previousChar == '0' && currentChar == '1')) {
                    result.append("(").append(currentChar);
                } else if (i > 0 && previousChar == '1' && currentChar == '0') {
                    result.append(")").append(currentChar);
                } else {
                    result.append(currentChar);
                }
                
                if (i == input.length() - 1 && currentChar == '1') {
                    result.append(")");
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
        
        scanner.close();
    }
}