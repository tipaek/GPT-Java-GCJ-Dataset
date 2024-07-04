import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            System.out.print("CASE #" + t + ": ");
            int currentLayer = 0;
            
            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                
                if (digit < 0 || digit > 9) {
                    throw new IllegalArgumentException("Input contains non-digit characters");
                }
                
                while (currentLayer < digit) {
                    System.out.print('(');
                    currentLayer++;
                }
                
                while (currentLayer > digit) {
                    System.out.print(')');
                    currentLayer--;
                }
                
                System.out.print(ch);
            }
            
            while (currentLayer > 0) {
                System.out.print(')');
                currentLayer--;
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
}