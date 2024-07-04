import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int caseNo = 1; caseNo <= testCases; caseNo++) {
            String inputLine = sc.nextLine();
            int[] inputDigits = new int[inputLine.length()];
            int[] countBraces = new int[inputLine.length()];

            for (int i = 0; i < inputLine.length(); i++) {
                inputDigits[i] = Character.getNumericValue(inputLine.charAt(i));
            }

            StringBuilder result = new StringBuilder();
            int openBraces = 0;

            for (int i = 0; i < inputDigits.length; i++) {
                while (openBraces < inputDigits[i]) {
                    result.append('(');
                    openBraces++;
                }
                while (openBraces > inputDigits[i]) {
                    result.append(')');
                    openBraces--;
                }
                result.append(inputDigits[i]);
            }

            while (openBraces > 0) {
                result.append(')');
                openBraces--;
            }

            System.out.println("Case #" + caseNo + ": " + result.toString());
        }
    }
}