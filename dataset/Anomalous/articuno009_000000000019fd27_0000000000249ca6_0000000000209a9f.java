import java.util.Scanner;

public class Solution {

    private static String process(String input) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);
            char prevChar = (index > 0) ? input.charAt(index - 1) : ' ';
            
            if (currentChar == '1' && (index == 0 || prevChar == '0')) {
                result.append('(');
            } else if (currentChar == '0' && index > 0 && prevChar == '1') {
                result.append(')');
            }
            result.append(currentChar);
        }
        
        if (input.charAt(input.length() - 1) == '1') {
            result.append(')');
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            System.out.println(process(input));
        }
        
        scanner.close();
    }
}