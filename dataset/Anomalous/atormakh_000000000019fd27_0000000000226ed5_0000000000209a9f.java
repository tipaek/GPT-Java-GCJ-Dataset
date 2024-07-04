import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int currentDepth = 0;

        for (int i = 1; i <= testCases; ++i) {
            char[] digits = scanner.next().toCharArray();
            StringBuilder result = new StringBuilder();

            for (char digit : digits) {
                int number = Character.getNumericValue(digit);
                
                while (currentDepth > number) {
                    result.append(")");
                    currentDepth--;
                }
                
                while (currentDepth < number) {
                    result.append("(");
                    currentDepth++;
                }
                
                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}