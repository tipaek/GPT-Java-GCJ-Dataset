import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        boolean debug = false;
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int num = Character.getNumericValue(ch);
                
                while (currentDepth < num) {
                    result.append("(");
                    currentDepth++;
                }
                
                while (currentDepth > num) {
                    result.append(")");
                    currentDepth--;
                }
                
                result.append(num);
            }
            
            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }

            if (debug) {
                System.out.println("Case #" + i + ": " + input);
                System.out.println(result);
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}