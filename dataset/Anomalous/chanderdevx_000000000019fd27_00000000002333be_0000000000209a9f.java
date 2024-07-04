import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[testCases];
        
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            String input = scanner.nextLine();
            StringBuilder formattedString = new StringBuilder();
            
            boolean isOpen = false;
            for (char ch : input.toCharArray()) {
                if (ch == '1' && !isOpen) {
                    formattedString.append('(');
                    isOpen = true;
                } else if (ch != '1' && isOpen) {
                    formattedString.append(')');
                    isOpen = false;
                }
                formattedString.append(ch);
            }
            
            if (isOpen) {
                formattedString.append(')');
            }
            
            results[caseIndex] = "Case #" + (caseIndex + 1) + ": " + formattedString.toString();
        }
        
        for (String result : results) {
            System.out.println(result);
        }
        
        scanner.close();
    }
}