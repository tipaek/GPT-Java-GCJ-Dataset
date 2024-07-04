import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            input = "0" + input + "0";
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < input.length() - 1; i++) {
                char currentChar = input.charAt(i);
                char nextChar = input.charAt(i + 1);
                
                result.append(currentChar);
                
                if (currentChar < nextChar) {
                    result.append('(');
                } else if (currentChar > nextChar) {
                    result.append(')');
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.substring(1, result.length() - 1));
        }
        
        scanner.close();
    }
}