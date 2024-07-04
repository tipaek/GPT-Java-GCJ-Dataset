import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNum = 1; caseNum <= numOfCases; caseNum++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';
                
                while (currentDepth < digit) {
                    output.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    output.append(')');
                    currentDepth--;
                }
                output.append(ch);
            }
            
            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + caseNum + ": " + output.toString());
        }
    }
}