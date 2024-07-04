import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        StringBuilder output = new StringBuilder();

        for (int c = 0; c < numCases; c++) {
            String unNest = sc.nextLine();
            String nested = nestString(unNest);
            output.append("Case #").append(c + 1).append(": ").append(nested).append("\n");
        }

        System.out.print(output.toString());
    }

    private static String nestString(String unNest) {
        int unnestLen = unNest.length();
        StringBuilder nested = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < unnestLen; i++) {
            int digit = Character.getNumericValue(unNest.charAt(i));
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