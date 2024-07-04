import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            boolean isOpen = false;
            
            for (char ch : input.toCharArray()) {
                if (ch == '1') {
                    if (!isOpen) {
                        output.append('(');
                        isOpen = true;
                    }
                    output.append('1');
                } else {
                    if (isOpen) {
                        output.append(')');
                        isOpen = false;
                    }
                    output.append('0');
                }
            }
            
            if (isOpen) {
                output.append(')');
            }
            
            System.out.println("Case #" + i + ": " + output.toString());
        }
        
        scanner.close();
    }
}