import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        scanner.nextLine(); // Consume the remaining newline
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentLevel = 0;
            
            for (char ch : input.toCharArray()) {
                int num = Character.getNumericValue(ch);
                
                while (num > currentLevel) {
                    result.append('(');
                    currentLevel++;
                }
                
                while (num < currentLevel) {
                    result.append(')');
                    currentLevel--;
                }
                
                result.append(ch);
            }
            
            while (currentLevel > 0) {
                result.append(')');
                currentLevel--;
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        scanner.close();
    }
}