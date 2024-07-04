import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < T; t++) {
            char[] S = scanner.nextLine().toCharArray();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char c : S) {
                int digit = Character.getNumericValue(c);
                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(c);
            }
            
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }
    }
}