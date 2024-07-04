import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numCases = sc.nextInt();
        sc.nextLine(); // consume the newline
        
        for (int c = 0; c < numCases; c++) {
            String unNest = sc.nextLine();
            String nested = generateNestedString(unNest);
            System.out.println("Case #" + (c + 1) + ": " + nested);
        }
    }

    private static String generateNestedString(String unNest) {
        StringBuilder nested = new StringBuilder();
        int currentDepth = 0;

        for (char ch : unNest.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            while (currentDepth < digit) {
                nested.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                nested.append(')');
                currentDepth--;
            }
            nested.append(digit);
        }

        while (currentDepth > 0) {
            nested.append(')');
            currentDepth--;
        }

        return nested.toString();
    }
}